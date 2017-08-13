package com.example.repository

import com.example.bean.HTUDataBean
import com.example.model.HTUData
import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils
import java.util.ArrayList
import javax.persistence.EntityManager
import javax.persistence.criteria.Predicate

@Repository
class HTUDataRepositoryCriteriaAPI(private val entityManager: EntityManager) {

    // 【Crud】--------------------------------------------
    fun createHtu(HTUData: HTUData) {

        // CriteriaAPIにInsertはないのでJPQLを利用
        entityManager.persist(HTUData)

    }

    // 【cRud】--------------------------------------------
    fun findByid(HTUDataBean: HTUDataBean): HTUData {

        // Set Up
        val CB = entityManager.criteriaBuilder
        val query = CB.createQuery(HTUData::class.java)
        val root = query.from(HTUData::class.java)
        query.select(root).where(CB.equal(root.get<HTUData>("id"), HTUDataBean.id))

        // Execute
        val HTUData = entityManager.createQuery(query).singleResult

        return HTUData
    }

    fun findAll(): List<HTUData> {

        // Set Up
        val CB = entityManager.criteriaBuilder
        val query = CB.createQuery(HTUData::class.java)
        val root = query.from(HTUData::class.java)
        query.select(root)

        val HTUDataList = entityManager.createQuery(query).resultList

        return HTUDataList
    }

    // TODO:メタモデルジェネレータで定義
    fun findMany(HTUDataBean: HTUDataBean): List<HTUData> {

        // Set Up
        val CB = entityManager.criteriaBuilder
        val query = CB.createQuery(HTUData::class.java)
        val root = query.from(HTUData::class.java)
        query.select(root)

        val creteria = ArrayList<Predicate>()

        if (HTUDataBean.id != 0) {

            creteria.add(CB.equal(root.get<HTUData>("id"), HTUDataBean.id))

        } else {

            if (!StringUtils.isEmpty(HTUDataBean.name)) {
                creteria.add(CB.equal(root.get<HTUData>("name"), HTUDataBean.name))
            }

            if (!StringUtils.isEmpty(HTUDataBean.age)) {
                creteria.add(CB.equal(root.get<HTUData>("age"), HTUDataBean.age))
            }

            if (!StringUtils.isEmpty(HTUDataBean.message)) {
                creteria.add(CB.equal(root.get<HTUData>("message"), HTUDataBean.message))
            }
        }

        if (creteria.size > 0) {
            query.where(CB.and(*creteria.toTypedArray()))
        }

        val HTUDataList = entityManager.createQuery(query).resultList

        return HTUDataList

    }

    // 【crUd】--------------------------------------------
    fun update(HTUData: HTUData) {

        // Set Up
        val CB = entityManager.criteriaBuilder
        val update = CB.createCriteriaUpdate(HTUData::class.java)

        val query = CB.createQuery(HTUData::class.java)
        val root = query.from(HTUData::class.java)

        update.set("name", HTUData.name)
                .set("age", HTUData.age)
                .set("message", HTUData.message)
                .where(CB.equal(root.get<HTUData>("id"), HTUData.id))

        // Execute
        entityManager.createQuery(update).executeUpdate()
    }

    // 【cruD】--------------------------------------------
    fun delete(HTUData: HTUData) {

        // Set Up
        val CB = entityManager.criteriaBuilder
        val delete = CB.createCriteriaDelete(HTUData::class.java)

        val query = CB.createQuery(HTUData::class.java)
        val root = query.from(HTUData::class.java)

        delete.where(CB.equal(root.get<HTUData>("id"), HTUData.id))

        // Execute
        entityManager.createQuery(delete).executeUpdate()
    }

}

