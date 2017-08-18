package com.example.service.htu2Service

import com.example.bean.HTUData2Bean
import com.example.model.dynamicModel.HTUData2
import com.example.repository.htu2JPQL.HTUData2RepositoryJPQL
import com.example.service.HTUData2Service
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.PostConstruct
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Service
@Transactional
class HTUData2ServiceJPQL : HTUData2Service() {

    internal var HTUData2RepositoryJPQL: HTUData2RepositoryJPQL? = null

    @PersistenceContext
    internal var entityManager: EntityManager? = null

    @PostConstruct
    fun init() {
        HTUData2RepositoryJPQL = HTUData2RepositoryJPQL(entityManager as EntityManager)
    }

    // 【Crud】--------------------------------------------
    /**
     * 新規作成
     * @param HTUData2Bean Veiw上のデータ
     */
    override fun createHtu(HTUData2Bean: HTUData2Bean)  {

        val HTUData2 = HTUData2()
        BeanUtils.copyProperties(HTUData2Bean, HTUData2)
        HTUData2RepositoryJPQL?.createHtu(HTUData2)
    }


    // 【cRud】--------------------------------------------
    /**
     * 検索(id利用)
     * @param HTUData2Bean Veiw上のデータ
     * *
     * @return HTUData2Bean Veiwに表示する検索結果
     */
    override fun findById(HTUData2Bean: HTUData2Bean): MutableList<HTUData2Bean> {

        val HTUData2 = HTUData2RepositoryJPQL?.findByid(HTUData2Bean)
        HTUData2?.let {  it -> BeanUtils.copyProperties(it, HTUData2Bean) }
        val HTUData2BeanList = mutableListOf<HTUData2Bean>()
        HTUData2BeanList.add(HTUData2Bean)
        return HTUData2BeanList
    }


    /**
     * 全件検索
     * @param HTUData2Bean Veiw上のデータ
     * *
     * @return HTUData2Bean Veiwに表示する検索結果
     */
    override fun findAll(): MutableList<HTUData2Bean> {

        val HTUData2List = HTUData2RepositoryJPQL?.run{ findAll()}
        val HTUData2BeanList = HTUData2List?.run {
            val HTUData2BeanList = mutableListOf<HTUData2Bean>()

            this.forEach { HTUData2 ->
                val HTUData2Bean = HTUData2Bean()
                BeanUtils.copyProperties(HTUData2, HTUData2Bean)
                HTUData2BeanList.add(HTUData2Bean)
            }
            HTUData2BeanList
        }

        return HTUData2BeanList as MutableList<HTUData2Bean>
    }

    /**
     * 検索(動的に検索条件を設定)
     * @param HTUData2Bean Veiw上のデータ
     * *
     * @return HTUData2BeanList Veiwに表示する検索結果
     */
    override fun findMany(HTUData2Bean: HTUData2Bean): MutableList<HTUData2Bean> {

        val HTUData2List = HTUData2RepositoryJPQL?.run { findMany(HTUData2Bean)}
        val HTUData2BeanList = HTUData2List?.run {
            val HTUData2BeanList = mutableListOf<HTUData2Bean>()

            this.forEach { HTUData2 ->
                val HTUData2Bean = HTUData2Bean()
                BeanUtils.copyProperties(HTUData2, HTUData2Bean)
                HTUData2BeanList.add(HTUData2Bean)
            }
            HTUData2BeanList
        }

        return HTUData2BeanList as MutableList<HTUData2Bean>
    }


    // 【crUd】--------------------------------------------
    /**
     * 更新(id利用)
     * @param HTUData2Bean Veiw上のデータ
     */
    override fun update(HTUData2Bean: HTUData2Bean) {

        val HTUData2 = HTUData2RepositoryJPQL?.findByid(HTUData2Bean)
        HTUData2?.let { BeanUtils.copyProperties(HTUData2Bean, it) } ?: createHtu(HTUData2Bean)
        HTUData2RepositoryJPQL?.run { update(HTUData2 as HTUData2) }

    }

    // 【cruD】--------------------------------------------
    /**
     * 削除
     * @param HTUData2Bean Veiw上のデータ(PKとPK以外で挙動が変わるよ)
     */
    override fun delete(HTUData2Bean: HTUData2Bean) {
        val HTUData2lList = HTUData2RepositoryJPQL?.findMany(HTUData2Bean)
        HTUData2lList?.let { if(it?.size != 0) it.forEach {HTUData2 -> HTUData2RepositoryJPQL?.delete(HTUData2) }}
    }
}
