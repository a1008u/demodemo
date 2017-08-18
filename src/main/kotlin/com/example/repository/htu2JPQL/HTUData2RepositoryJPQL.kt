package com.example.repository.htu2JPQL

import com.example.bean.HTUData2Bean
import com.example.model.dynamicModel.HTUData2
import org.springframework.util.StringUtils
import java.util.HashMap
import javax.persistence.EntityManager

class HTUData2RepositoryJPQL(private val entityManager: EntityManager) {
    

    // 【Crud】--------------------------------------------
    fun createHtu(HTUData2: HTUData2) {

        entityManager.persist(HTUData2)

    }

    // 【cRud】--------------------------------------------
    fun findByid(HTUData2Bean: HTUData2Bean): HTUData2 {

        val qstr = "from HTUData2 where id= :id"

        val query = entityManager.createQuery(qstr).setParameter("id", HTUData2Bean.id)

        val HTUData2 = query.singleResult as HTUData2
        return HTUData2
    }

    fun findAll(): MutableList<Any?>? {

        val qstr = "from HTUData2"

        val query = entityManager.createQuery(qstr)

        val HTUData2List = query.resultList

        return HTUData2List
    }


    fun findMany(HTUData2Bean: HTUData2Bean): MutableList<HTUData2>? {

        var HTUData2List: MutableList<HTUData2>? = null
        val parameterMap = HashMap<String, String>()
        val buf = StringBuilder()
        var condCnt = 0

        buf.append("from HTUData2")

        if (HTUData2Bean.id  != 0) {

            val HTUData2 = findByid(HTUData2Bean)
            val HTUData2List = mutableListOf<HTUData2>()
            HTUData2List.add(HTUData2)

        } else {

            if (!StringUtils.isEmpty(HTUData2Bean.name)) {
                buf.append(if (condCnt++ == 0) " where" else " and")
                buf.append(" name = :name")
                parameterMap.put("name", HTUData2Bean.name)
            }

            if (!StringUtils.isEmpty(HTUData2Bean.age)) {
                buf.append(if (condCnt++ == 0) " where" else " and")
                buf.append(" age = :age")
                parameterMap.put("age", HTUData2Bean.age)
            }

            if (!StringUtils.isEmpty(HTUData2Bean.message)) {
                buf.append(if (condCnt++ == 0) " where" else " and")
                buf.append(" message = :message")
                parameterMap.put("message", HTUData2Bean.message)
            }

            val query = entityManager.createQuery(buf.toString())

            if (parameterMap.size > 0) parameterMap.forEach { key, value -> query.setParameter(key, value) }

            HTUData2List = query.resultList as MutableList<HTUData2>?

        }

        return HTUData2List

    }

    // 【crUd】--------------------------------------------
    fun update(HTUData2: HTUData2) {
        val qstr = "update HTUData2 set name = :name, age = :age, message = :message where id= :id"

        // TODO:動的にupdateできるようにする

        val query = entityManager.createQuery(qstr).setParameter("name", HTUData2.name)
                .setParameter("age", HTUData2.age)
                .setParameter("message", HTUData2.message)
                .setParameter("id", HTUData2.id)

        query.executeUpdate()
    }

    // 【cruD】--------------------------------------------
    fun delete(HTUData2: HTUData2) {
        val qstr = "delete from HTUData2 where id= :id"

        val query = entityManager.createQuery(qstr).setParameter("id", HTUData2.id)
        query.executeUpdate()
    }

}
