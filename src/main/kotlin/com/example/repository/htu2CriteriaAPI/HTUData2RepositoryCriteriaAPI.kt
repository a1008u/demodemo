package com.example.repository.htu2CriteriaAPI

import com.example.bean.HTUData2Bean
import com.example.model.dynamicModel.HTUData2
import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils
import java.util.ArrayList
import javax.persistence.EntityManager
import javax.persistence.criteria.Predicate

@Repository
class HTUData2RepositoryCriteriaAPI(private val entityManager: EntityManager) {

    // 【Crud】--------------------------------------------
    fun createHtu(HTUData2: HTUData2) {

        // CriteriaAPIにInsertはないのでJPQLを利用
        entityManager.persist(HTUData2)

    }

    // 【cRud】--------------------------------------------
    fun findByid(HTUData2Bean: HTUData2Bean): HTUData2 {

        // Set Up
        val CB = entityManager.criteriaBuilder
        val query = CB.createQuery(HTUData2::class.java)
        val root = query.from(HTUData2::class.java)
        query.select(root).where(CB.equal(root.get<HTUData2>("id"), HTUData2Bean.id))

        // Execute
        val HTUData2 = entityManager.createQuery(query).singleResult

        return HTUData2
    }

    fun findAll(): List<HTUData2> {

        // Set Up
        val CB = entityManager.criteriaBuilder
        val query = CB.createQuery(HTUData2::class.java)
        val root = query.from(HTUData2::class.java)
        query.select(root)

        val HTUData2List = entityManager.createQuery(query).resultList

        return HTUData2List
    }

    // TODO:メタモデルジェネレータで定義
    fun findMany(HTUData2Bean: HTUData2Bean): List<HTUData2> {

        // Set Up
        val CB = entityManager.criteriaBuilder
        val query = CB.createQuery(HTUData2::class.java)
        val root = query.from(HTUData2::class.java)
        query.select(root)

        val creteria = ArrayList<Predicate>()

        if (HTUData2Bean.id != 0) {

            creteria.add(CB.equal(root.get<HTUData2>("id"), HTUData2Bean.id))

        } else {

            if (!StringUtils.isEmpty(HTUData2Bean.name)) {
                creteria.add(CB.equal(root.get<HTUData2>("name"), HTUData2Bean.name))
            }

            if (!StringUtils.isEmpty(HTUData2Bean.age)) {
                creteria.add(CB.equal(root.get<HTUData2>("age"), HTUData2Bean.age))
            }

            if (!StringUtils.isEmpty(HTUData2Bean.message)) {
                creteria.add(CB.equal(root.get<HTUData2>("message"), HTUData2Bean.message))
            }
        }

        if (creteria.size > 0) {
            query.where(CB.and(*creteria.toTypedArray()))
        }

        val HTUData2List = entityManager.createQuery(query).resultList

        return HTUData2List

    }

    // 【crUd】--------------------------------------------
    fun update(HTUData2: HTUData2) {

        // Set Up
        val CB = entityManager.criteriaBuilder
        val update = CB.createCriteriaUpdate(HTUData2::class.java)

        val query = CB.createQuery(HTUData2::class.java)
        val root = query.from(HTUData2::class.java)

        update.set("name", HTUData2.name)
                .set("age", HTUData2.age)
                .set("message", HTUData2.message)
                .where(CB.equal(root.get<HTUData2>("id"), HTUData2.id))

        // Execute
        entityManager.createQuery(update).executeUpdate()
    }

    // 【cruD】--------------------------------------------
    fun delete(HTUData2: HTUData2) {

        // Set Up
        val CB = entityManager.criteriaBuilder
        val delete = CB.createCriteriaDelete(HTUData2::class.java)

        val query = CB.createQuery(HTUData2::class.java)
        val root = query.from(HTUData2::class.java)

        delete.where(CB.equal(root.get<HTUData2>("id"), HTUData2.id))

        // Execute
        entityManager.createQuery(delete).executeUpdate()
    }

}

