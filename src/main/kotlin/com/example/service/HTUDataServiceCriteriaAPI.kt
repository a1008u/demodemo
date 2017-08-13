package com.example.service

import com.example.bean.HTUDataBean
import com.example.model.HTUData
import com.example.repository.HTUDataRepositoryCriteriaAPI
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.PostConstruct
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * DBからのデータ取得と加工を行う.
 */
@Service
@Transactional
open class HTUDataServiceCriteriaAPI: HTUDataService() {


    internal var HTUDataRepositoryCriteriaAPI: HTUDataRepositoryCriteriaAPI? = null

    @PersistenceContext
    internal var entityManager: EntityManager? = null

    @PostConstruct
    fun init() {
        HTUDataRepositoryCriteriaAPI = HTUDataRepositoryCriteriaAPI(entityManager as EntityManager)
    }

    // 【Crud】--------------------------------------------
    /**
     * 新規作成
     * @param HTUDataBean Veiw上のデータ
     */
    override fun createHtu(HTUDataBean: HTUDataBean) {

        val HTUData = HTUData()
        BeanUtils.copyProperties(HTUDataBean, HTUData)
        HTUDataRepositoryCriteriaAPI?.run{ createHtu(HTUData) }
    }


    // 【cRud】--------------------------------------------
    /**
     * 検索(id利用)
     * @param HTUDataBean Veiw上のデータ
     * *
     * @return HTUDataBean Veiwに表示する検索結果
     */
    override fun findById(HTUDataBean: HTUDataBean): MutableList<HTUDataBean> {

        val HTUData = HTUDataRepositoryCriteriaAPI?.run { findByid(HTUDataBean) }
        HTUData?.let {  it -> BeanUtils.copyProperties(it, HTUDataBean) }
        val HTUDataBeanList = mutableListOf<HTUDataBean>()
        HTUDataBeanList.add(HTUDataBean)
        return HTUDataBeanList
    }

    /**
     * 全件検索
     * @param HTUDataBean Veiw上のデータ
     * *
     * @return HTUDataBean Veiwに表示する検索結果
     */
    override fun findAll(): MutableList<HTUDataBean>  {

        val HTUDataList = HTUDataRepositoryCriteriaAPI?.run{ findAll() }
        val HTUDataBeanList = HTUDataList?.run {
            val HTUDataBeanList = mutableListOf<HTUDataBean>()

            this.forEach { HTUData ->
                val HTUDataBean = HTUDataBean()
                BeanUtils.copyProperties(HTUData, HTUDataBean)
                HTUDataBeanList.add(HTUDataBean)
            }
            HTUDataBeanList
        }

        return HTUDataBeanList as MutableList<HTUDataBean>
    }

    /**
     * 検索(動的に検索条件を設定)
     * @param HTUDataBean Veiw上のデータ
     * *
     * @return HTUDataBeanList Veiwに表示する検索結果
     */
    override fun findMany(HTUDataBean: HTUDataBean): MutableList<HTUDataBean> {

        val HTUDataList = HTUDataRepositoryCriteriaAPI?.run{ findMany(HTUDataBean)}
        val HTUDataBeanList = HTUDataList?.run {
            val HTUDataBeanList = mutableListOf<HTUDataBean>()

            this.forEach { HTUData ->
                val HTUDataBean = HTUDataBean()
                BeanUtils.copyProperties(HTUData, HTUDataBean)
                HTUDataBeanList.add(HTUDataBean)
            }
            HTUDataBeanList
        }

        return HTUDataBeanList as MutableList<HTUDataBean>
    }


    // 【crUd】--------------------------------------------
    /**
     * 更新(id利用)
     * @param HTUDataBean Veiw上のデータ
     */
    override fun update(HTUDataBean: HTUDataBean) {

        val HTUData = HTUDataRepositoryCriteriaAPI?.run {findByid(HTUDataBean)}
        HTUData?.let { BeanUtils.copyProperties(HTUDataBean, it) } ?: createHtu(HTUDataBean)
        HTUDataRepositoryCriteriaAPI?.run { update(HTUData as HTUData) }
    }

    // 【cruD】--------------------------------------------
    /**
     * 削除
     * @param HTUDataBean Veiw上のデータ(PKとPK以外で挙動が変わるよ)
     */
    override fun delete(HTUDataBean: HTUDataBean) {

        val HTUDatalList = HTUDataRepositoryCriteriaAPI?.run {findMany(HTUDataBean)}
        HTUDatalList?.let { if(it?.size != 0) it.forEach {HTUData -> HTUDataRepositoryCriteriaAPI?.delete(HTUData) }}
    }
}
