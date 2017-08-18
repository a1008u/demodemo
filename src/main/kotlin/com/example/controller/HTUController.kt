package com.example.controller


import com.example.bean.HTUDataBean
import com.example.form.HTUDataForm
import com.example.model.staticModel.Category
import com.example.repository.CategoryRepository
import com.example.service.HTUDataServiceFactory
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

@Controller
class HTUController{

    @Autowired
    internal var HTUDataServiceFactory: HTUDataServiceFactory? = null

    @Autowired
    private val CategoryRepository : CategoryRepository? = null

    // 1.リクエスト時に必ず呼び出す(Formの初期化)----------------------------
    @ModelAttribute(value = "form")
    internal fun setUphtudataform(): HTUDataForm {
        println("create HTUDataForm")
        CategoryRepository?.save(Category(0, "Men"))
        CategoryRepository?.save(Category(0, "Women"))
        return HTUDataForm()
    }

    // 2.ルート---------------------------------------------------------
    @GetMapping("/htu")
    internal fun MyDataList(@ModelAttribute(value = "form")HTUDataForm: HTUDataForm, mav: ModelAndView): ModelAndView {
        mav.gotoTop(HTUDataForm)
        return mav
    }

    // 3.検索時に利用---------------------------------------------------------
    @PostMapping(value = "operate_form")
    internal fun operate_form(@Validated @ModelAttribute("form")HTUDataForm: HTUDataForm,
                              result: BindingResult,
                              mav: ModelAndView): ModelAndView {

        // 単項目チェック
        if (result.hasErrors()) { return mav.gotoTop(HTUDataForm) }

        //　TODO：相関チェック

        /*　TODO : リファクタリング(Factoryパターン+Strategyパターン+Stateパターンに変更)
		 * sqlの利用
		 * 1.repository + Criteria API 進捗：65%
		 * 2.JPQL 進捗：65%
		 * 3.Criteria API 進捗：65%
		 */

        // Set Up
        val HTUDataBean = HTUDataForm.toBean()

        val HTUDataService = HTUDataServiceFactory?.run { isolate(HTUDataForm) }
        when (HTUDataForm.sql) {

            "create" -> HTUDataService?.run{ createHtu(HTUDataBean) }

            "read" -> {
                HTUDataForm.into(HTUDataService?.run{ findMany(HTUDataBean)})
                mav.topPage(HTUDataForm)
                return mav
            }

            "update" -> HTUDataService?.run{ update(HTUDataBean)}

            "delete" -> HTUDataService?.run{ delete(HTUDataBean)}
        }

        return ModelAndView("redirect:/htu")
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

    internal val RADIO_ITEMS_gender: MutableMap<String, String>
        get() = Collections.unmodifiableMap(object : LinkedHashMap<String, String>() {
            private val serialVersionUID = 1L

            init {
                put("men", "men")
                put("women", "women")
            }
        }
        )

    // ex.ModelAndViewの拡張--------------------------------------------------
    inline private fun ModelAndView.gotoTop(HTUDataForm: HTUDataForm): ModelAndView {
        HTUDataForm.into(HTUDataServiceFactory?.run { isolate(HTUDataForm)}?.run { findAll() })
        topPage(HTUDataForm)
        return this
    }

    inline private fun ModelAndView.topPage(HTUDataForm: HTUDataForm) {

        // addObject("form", HTUDataForm)
        addObject("htudatalist", HTUDataForm.htudatalist)
        addObject("radioItems_sql", RADIO_ITEMS_sql)
        addObject("radioItems_jpa", RADIO_ITEMS_jpa)
        addObject("radioItems_gender", RADIO_ITEMS_gender)
        viewName = "MyDataList"
    }

    // ex.HTUDataFormの拡張---------------------------------------------------
    inline private fun HTUDataForm.into(value : MutableList<HTUDataBean>?) {
        this.htudatalist = value
    }

    inline private fun HTUDataForm.toBean(): HTUDataBean {
        val HTUDataBean = HTUDataBean()
        BeanUtils.copyProperties(this, HTUDataBean)
        HTUDataBean.id = if (id.isEmpty()) 0 else id.toInt()
        HTUDataBean.category?.apply{code = if(gender == "men") 1 else 2}
        return HTUDataBean
    }


}

