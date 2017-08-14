package com.example.repository

import com.example.bean.HTUDataBean
import com.example.model.HTUData
import org.springframework.util.StringUtils
import java.util.HashMap
import javax.persistence.EntityManager

class HTUDataRepositoryJPQL(private val entityManager: EntityManager) {
    

    // 【Crud】--------------------------------------------
    fun createHtu(HTUData: HTUData) {

        entityManager.persist(HTUData)

    }

    // 【cRud】--------------------------------------------
    fun findByid(HTUDataBean: HTUDataBean): HTUData {

        val qstr = "from HTUData where id= :id"

        val query = entityManager.createQuery(qstr).setParameter("id", HTUDataBean.id)

        val HTUData = query.singleResult as HTUData
        return HTUData
    }

    fun findAll(): MutableList<Any?>? {

        val qstr = "from HTUData"

        val query = entityManager.createQuery(qstr)

        val HTUDataList = query.resultList

        return HTUDataList
    }


    fun findMany(HTUDataBean: HTUDataBean): MutableList<HTUData>? {

        var HTUDataList: MutableList<HTUData>? = null
        val parameterMap = HashMap<String, String>()
        val buf = StringBuilder()
        var condCnt = 0

        buf.append("from HTUData")

        if (HTUDataBean.id  != 0) {

            val HTUData = findByid(HTUDataBean)
            val HTUDataList = mutableListOf<HTUData>()
            HTUDataList.add(HTUData)

        } else {

            if (!StringUtils.isEmpty(HTUDataBean.name)) {
                buf.append(if (condCnt++ == 0) " where" else " and")
                buf.append(" name = :name")
                parameterMap.put("name", HTUDataBean.name)
            }

            if (!StringUtils.isEmpty(HTUDataBean.age)) {
                buf.append(if (condCnt++ == 0) " where" else " and")
                buf.append(" age = :age")
                parameterMap.put("age", HTUDataBean.age)
            }

            if (!StringUtils.isEmpty(HTUDataBean.message)) {
                buf.append(if (condCnt++ == 0) " where" else " and")
                buf.append(" message = :message")
                parameterMap.put("message", HTUDataBean.message)
            }

            val query = entityManager.createQuery(buf.toString())

            if (parameterMap.size > 0) parameterMap.forEach { key, value -> query.setParameter(key, value) }

            HTUDataList = query.resultList as MutableList<HTUData>?

        }

        return HTUDataList

    }

    // 【crUd】--------------------------------------------
    fun update(HTUData: HTUData) {
        val qstr = "update HTUData set name = :name, age = :age, message = :message where id= :id"

        // TODO:動的にupdateできるようにする

        val query = entityManager.createQuery(qstr).setParameter("name", HTUData.name)
                .setParameter("age", HTUData.age)
                .setParameter("message", HTUData.message)
                .setParameter("id", HTUData.id)

        query.executeUpdate()
    }

    // 【cruD】--------------------------------------------
    fun delete(HTUData: HTUData) {
        val qstr = "delete from HTUData where id= :id"

        val query = entityManager.createQuery(qstr).setParameter("id", HTUData.id)
        query.executeUpdate()
    }

}
