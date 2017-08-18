package com.example.controller


import com.example.bean.HTUData2Bean
import com.example.form.HTUData2Form
import com.example.service.HTUData2ServiceFactory
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.GetMapping
import java.util.*
import javax.validation.Valid

@Controller
class HTU2Controller{

    @Autowired
    internal var HTUData2ServiceFactory: HTUData2ServiceFactory? = null

    // 1.リクエスト時に必ず呼び出す(Formの初期化)----------------------------
    @ModelAttribute(value = "form")
    internal fun setUpHTUData2form(): HTUData2Form {
        println("create HTUData2Form")
        return HTUData2Form()
    }

    // 2.ルート---------------------------------------------------------
    @GetMapping("/htu2")
    internal fun MyDataList(@ModelAttribute(value = "form")HTUData2Form: HTUData2Form,
                            mav: ModelAndView): ModelAndView {
        mav.gotoTop(HTUData2Form)
        return mav
    }

    // 3.検索時に利用---------------------------------------------------------
    @PostMapping(value = "htu2_operate_form")
    internal fun operate_form(@Validated @ModelAttribute("form")HTUData2Form: HTUData2Form,
                              result: BindingResult,
                              mav: ModelAndView): ModelAndView {

        // 単項目チェック
        if (result.hasErrors()) { return mav.gotoTop(HTUData2Form) }

        //　TODO：相関チェック

        /*　TODO : リファクタリング(Factoryパターン+Strategyパターン+Stateパターンに変更)
		 * sqlの利用
		 * 1.repository + Criteria API 進捗：65%
		 * 2.JPQL 進捗：65%
		 * 3.Criteria API 進捗：65%
		 */

        // Set Up
        val HTUData2Bean = HTUData2Form.toBean()

        val HTUData2Service = HTUData2ServiceFactory?.run { isolate(HTUData2Form) }
        when (HTUData2Form.sql) {

            "create" -> HTUData2Service?.run{ createHtu(HTUData2Bean) }

            "read" -> {
                HTUData2Form.into(HTUData2Service?.run{ findMany(HTUData2Bean)})
                mav.topPage(HTUData2Form)
                return mav
            }

            "update" -> HTUData2Service?.run{ update(HTUData2Bean)}

            "delete" -> HTUData2Service?.run{ delete(HTUData2Bean)}
        }

        return ModelAndView("redirect:/htu2")
    }


    // ex.画面表示項目---------------------------------------------------
    internal val RADIO_ITEMS_sql: MutableMap<String, String>
        get() = Collections.unmodifiableMap(object : LinkedHashMap<String, String>() {
            private val serialVersionUID = 1L
                init {
                    put("create", "create")
                    put("read", "read")
                    put("update", "update")
                    put("delete", "delete")
                }
            }
        )

    internal val RADIO_ITEMS_jpa: MutableMap<String, String>
        get() = Collections.unmodifiableMap(object : LinkedHashMap<String, String>() {
            private val serialVersionUID = 1L

                init {
                    put("Repository", "Repository")
                    put("JPQL", "JPQL")
                    put("Criteria API", "Criteria API")
                }
            }
        )

    // ex.ModelAndViewの拡張--------------------------------------------------
    inline private fun ModelAndView.gotoTop(HTUData2Form: HTUData2Form): ModelAndView {
        HTUData2Form.into(HTUData2ServiceFactory?.run { isolate(HTUData2Form)}?.run { findAll() })
        topPage(HTUData2Form)
        return this
    }

    inline private fun ModelAndView.topPage(HTUData2Form: HTUData2Form) {

        // addObject("form", HTUData2Form)
        addObject("htudatalist", HTUData2Form.htudatalist)
        addObject("radioItems_sql", RADIO_ITEMS_sql)
        addObject("radioItems_jpa", RADIO_ITEMS_jpa)
        viewName = "MyData2List"
    }

    // ex.HTUData2Formの拡張---------------------------------------------------
    inline private fun HTUData2Form.into(value : MutableList<HTUData2Bean>?) {
        this.htudatalist = value
    }

    inline private fun HTUData2Form.toBean(): HTUData2Bean {
        val HTUData2Bean = com.example.bean.HTUData2Bean()
        BeanUtils.copyProperties(this, HTUData2Bean)
        HTUData2Bean.id = if (id.isEmpty()) 0 else id.toInt()
        return HTUData2Bean
    }


}

