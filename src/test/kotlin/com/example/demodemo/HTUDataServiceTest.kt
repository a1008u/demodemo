package com.example.demodemo

import com.example.bean.HTUDataBean
import com.example.service.HTUDataServiceRepository
import org.hamcrest.beans.SamePropertyValuesAs
import org.junit.Assert.*
import org.hamcrest.CoreMatchers.`is` as be
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner

// @RunWith(SpringRunner::class)
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class HTUDataServiceTest{
    @Autowired
    private val HTUDataServiceRepository : HTUDataServiceRepository? = null


    /**
     * 【Crud】--------------------------------------------
     * Createのテスト
     */
    @Test
    fun Test1Create() {
        // Set Up
        val expected : HTUDataBean = HTUDataBean()
        expected.name = "testuser"
        expected.age = "20"
        expected.message = "testuserは食べないよ"

        // execute
        HTUDataServiceRepository?.run { createHtc(expected)}

        val HTCDataBean: HTUDataBean = HTUDataBean(1)
        val actual = HTUDataServiceRepository?.run {findById(HTCDataBean)}
        expected.id = 1

        // Verify
        actual?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }
    }

    /**
     * 【cRud】--------------------------------------------
     * Createのテスト
     */
    @Test
    @Throws(Exception::class)
    fun Test2FindById() {

        // Set Up
        val testData : HTUDataBean = HTUDataBean()
        testData.name = "testuser"
        testData.age = "20"
        testData.message = "testuserは食べないよ"
        HTUDataServiceRepository?.run { createHtc(testData)}
        val expected: HTUDataBean = HTUDataBean(1, "testuser", "20", "testuserは食べないよ")

        // execute
        val HTUDataBean = HTUDataBean(1)
        val actual = HTUDataServiceRepository?.run { findById(HTUDataBean) }

        // Verify
        actual?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }
    }


}


