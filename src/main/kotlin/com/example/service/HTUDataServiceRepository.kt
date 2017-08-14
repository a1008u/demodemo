package com.example.service

/**
 * Created by version1 on 2017/02/11.
 */


import com.example.bean.HTUDataBean
import com.example.model.HTUData
import com.example.repository.HTURepository
import com.example.repository.SpecificationsDetailHTUData
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


/**
 * DBからのデータ取得と加工を行う.
 */
@Service
@Transactional
open class HTUDataServiceRepository : HTUDataService() {

    @Autowired
    private val htuRepository: HTURepository? = null

    @Autowired
    private val SpecificationsDetailHTUData: SpecificationsDetailHTUData? = null

    /**
     * HTUDataの登録(Crud)
     * @param HTUDataBean
     */
    override fun createHtu(HTUDataBean: HTUDataBean): Unit {
        val HTUData = HTUData()
        BeanUtils.copyProperties(HTUDataBean, HTUData)
        htuRepository?.run{ saveAndFlush(HTUData) }
    }

    /**
     * idを利用した検索(cRud)
     * @param HTUDataBean
     * @return HTUDataBean
     */
    override fun findById(HTUDataBean: HTUDataBean): MutableList<HTUDataBean> {
        val HTUData = htuRepository?.run{ findByid(HTUDataBean.id) }
        HTUData?.let {  it -> BeanUtils.copyProperties(it, HTUDataBean) }
        val HTUDataBeanList = mutableListOf<HTUDataBean>()
        HTUDataBeanList.add(HTUDataBean)
        return HTUDataBeanList
    }

    /**
     * nameを利用した検索(cRud)
     * @param
     * @return HTUDataBean
     */
    fun findByName(HTUDataBean: HTUDataBean): MutableList<HTUDataBean> {
        val HTUData = htuRepository?.run{ findByname(HTUDataBean.name) }
        HTUData?.let {  it -> BeanUtils.copyProperties(it, HTUDataBean) }
        val HTUDataBeanList = mutableListOf<HTUDataBean>()
        HTUDataBeanList.add(HTUDataBean)
        return HTUDataBeanList
    }

    /**
     * nameを利用した検索(cRud)
     * @param
     * @return HTUDataBean
     */
    fun findByNameList(HTUDataBean: HTUDataBean): MutableList<HTUDataBean> {
        val HTUDataList = htuRepository?.run{ findBynamelist(HTUDataBean.name) }
        val HTUDataBeanList = HTUDataList?.run {
            val HTUDataBeanList = mutableListOf<HTUDataBean>()

            this.forEach { HTUData ->
                val HTUDataBean = HTUDataBean()
                BeanUtils.copyProperties(HTUData, HTUDataBean)
                HTUDataBeanList.add(HTUDataBean)
            }
            HTUDataBeanList
        }
        return HTUDataBeanList as MutableList<HTUDataBean> //TODO
    }

    /**
     * 全件検索(cRud)
     * @param HTUDataBean
     * @return HTUDataBeanList  MutableList<HTUDataBean>
     */
    override fun findAll(): MutableList<HTUDataBean> {

        // test用
        // createHtu(HTUDataBean(name="ssss"))

        val HTUDataList = htuRepository?.run { findAll() } as MutableList<HTUData>

        val HTUDataBeanList = HTUDataList?.run {
            val HTUDataBeanList = mutableListOf<HTUDataBean>()

            this.forEach { HTUData ->
                val HTUDataBean = HTUDataBean()
                BeanUtils.copyProperties(HTUData, HTUDataBean)
                HTUDataBeanList.add(HTUDataBean)
            }
            HTUDataBeanList
        }

        return HTUDataBeanList as MutableList<HTUDataBean> //TODO
    }

    /**
     * 検索(動的に検索条件を設定)
     * todo Specificationが使えない
     * @param HTUDataBean
     * @return MyDataBeanList Veiwに表示する検索結果
     */
    override fun findMany(HTUDataBean: HTUDataBean): MutableList<HTUDataBean> {

        val HTUDataList = SpecificationsDetailHTUData?.run { findMany(HTUDataBean) }

        val HTUDataBeanList = HTUDataList?.run {
            val HTUDataBeanList = mutableListOf<HTUDataBean>()
            this.forEach { HTUData ->
                val HTUDataBean = HTUDataBean()
                BeanUtils.copyProperties(HTUData, HTUDataBean)
                HTUDataBeanList.add(HTUDataBean)
            }
            HTUDataBeanList
        }

        return HTUDataBeanList as MutableList<HTUDataBean> //TODO
    }

    /**
     * HTUDataの更新(crUd)
     * @param HTUDataBean
     */
    override fun update(HTUDataBean: HTUDataBean): Unit {
        val HTUData = htuRepository?.run{ findByid(HTUDataBean.id) }
        HTUData?.let { BeanUtils.copyProperties(HTUDataBean, it) } ?: BeanUtils.copyProperties(HTUDataBean, HTUDataBean)
        htuRepository?.run { saveAndFlush(HTUData) }
    }

    /**
     * HTUDataの削除(crUd)
     * @param HTUDataBean
     */
    override fun delete(HTUDataBean: HTUDataBean): Unit {

        val HTUData = htuRepository?.run{ findByid(HTUDataBean.id) }
        HTUData?.let {  htuRepository?.delete(it) }
    }


}