package com.example.service.htu2Service

/**
 * Created by version1 on 2017/02/11.
 */

import com.example.bean.HTUData2Bean
import com.example.model.dynamicModel.HTUData2
import com.example.repository.htu2Repository.HTUData2Repository
import com.example.repository.htu2Repository.SpecificationsDetailHTUData2
import com.example.service.HTUData2Service
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


/**
 * DBからのデータ取得と加工を行う.
 */
@Service
@Transactional
open class HTUData2ServiceRepository : HTUData2Service() {

    @Autowired
    private val htu2Repository: HTUData2Repository? = null

    @Autowired
    private val SpecificationsDetailHTUData2: SpecificationsDetailHTUData2? = null

    /**
     * HTUData2の登録(Crud)
     * @param HTUData2Bean
     */
    override fun createHtu(HTUData2Bean: HTUData2Bean): Unit {
        val HTUData2 = HTUData2()
        BeanUtils.copyProperties(HTUData2Bean, HTUData2)
        htu2Repository?.run{ saveAndFlush(HTUData2) }
    }

    /**
     * idを利用した検索(cRud)
     * @param HTUData2Bean
     * @return HTUData2Bean
     */
    override fun findById(HTUData2Bean: HTUData2Bean): MutableList<HTUData2Bean> {
        val HTUData2 = htu2Repository?.run{ findByid(HTUData2Bean.id) }
        HTUData2?.let {  it -> BeanUtils.copyProperties(it, HTUData2Bean) }
        val HTUData2BeanList = mutableListOf<HTUData2Bean>()
        HTUData2BeanList.add(HTUData2Bean)
        return HTUData2BeanList
    }

    /**
     * nameを利用した検索(cRud)
     * @param
     * @return HTUData2Bean
     */
    fun findByName(HTUData2Bean: HTUData2Bean): MutableList<HTUData2Bean> {
        val HTUData2 = htu2Repository?.run{ findByname(HTUData2Bean.name) }
        HTUData2?.let {  it -> BeanUtils.copyProperties(it, HTUData2Bean) }
        val HTUData2BeanList = mutableListOf<HTUData2Bean>()
        HTUData2BeanList.add(HTUData2Bean)
        return HTUData2BeanList
    }

    /**
     * nameを利用した検索(cRud)
     * @param
     * @return HTUData2Bean
     */
    fun findByNameList(HTUData2Bean: HTUData2Bean): MutableList<HTUData2Bean> {
        val HTUData2List = htu2Repository?.run{ findBynamelist(HTUData2Bean.name) }
        val HTUData2BeanList = HTUData2List?.run {
            val HTUData2BeanList = mutableListOf<HTUData2Bean>()

            this.forEach { HTUData2 ->
                val HTUData2Bean = HTUData2Bean()
                BeanUtils.copyProperties(HTUData2, HTUData2Bean)
                HTUData2BeanList.add(HTUData2Bean)
            }
            HTUData2BeanList
        }
        return HTUData2BeanList as MutableList<HTUData2Bean> //TODO
    }

    /**
     * 全件検索(cRud)
     * @param HTUData2Bean
     * @return HTUData2BeanList  MutableList<HTUData2Bean>
     */
    override fun findAll(): MutableList<HTUData2Bean> {

        // test用
        // createHtu(HTUData2Bean(name="ssss"))

        val HTUData2List = htu2Repository?.run { findAll() } as MutableList<HTUData2>

        val HTUData2BeanList = HTUData2List?.run {
            val HTUData2BeanList = mutableListOf<HTUData2Bean>()

            this.forEach { HTUData2 ->
                val HTUData2Bean = HTUData2Bean()
                BeanUtils.copyProperties(HTUData2, HTUData2Bean)
                HTUData2BeanList.add(HTUData2Bean)
            }
            HTUData2BeanList
        }

        return HTUData2BeanList as MutableList<HTUData2Bean> //TODO
    }

    /**
     * 検索(動的に検索条件を設定)
     * todo Specificationが使えない
     * @param HTUData2Bean
     * @return MyDataBeanList Veiwに表示する検索結果
     */
    override fun findMany(HTUData2Bean: HTUData2Bean): MutableList<HTUData2Bean> {

        val HTUData2List = SpecificationsDetailHTUData2?.run { findMany(HTUData2Bean) }

        val HTUData2BeanList = HTUData2List?.run {
            val HTUData2BeanList = mutableListOf<HTUData2Bean>()
            this.forEach { HTUData2 ->
                val HTUData2Bean = HTUData2Bean()
                BeanUtils.copyProperties(HTUData2, HTUData2Bean)
                HTUData2BeanList.add(HTUData2Bean)
            }
            HTUData2BeanList
        }

        return HTUData2BeanList as MutableList<HTUData2Bean> //TODO
    }

    /**
     * HTUData2の更新(crUd)
     * @param HTUData2Bean
     */
    override fun update(HTUData2Bean: HTUData2Bean): Unit {
        val HTUData2 = htu2Repository?.run{ findByid(HTUData2Bean.id) }
        HTUData2?.let { BeanUtils.copyProperties(HTUData2Bean, it) } ?: BeanUtils.copyProperties(HTUData2Bean, HTUData2Bean)
        htu2Repository?.run { saveAndFlush(HTUData2) }
    }

    /**
     * HTUData2の削除(crUd)
     * @param HTUData2Bean
     */
    override fun delete(HTUData2Bean: HTUData2Bean): Unit {

        val HTUData2 = htu2Repository?.run{ findByid(HTUData2Bean.id) }
        HTUData2?.let {  htu2Repository?.delete(it) }
    }


}