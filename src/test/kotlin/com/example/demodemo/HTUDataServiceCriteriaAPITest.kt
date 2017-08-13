package com.example.demodemo

import com.example.bean.HTUDataBean
import com.example.service.HTUDataServiceCriteriaAPI
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

// @RunWith(SpringRunner::class)
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class HTUDataServiceCriteriaAPITest{

    @Autowired
    private val HTUDataServiceCriteriaAPI : HTUDataServiceCriteriaAPI? = null

    /**
     * 【Crud】-------------------------------------------------------------------------
     * Createのテスト
     */
    @Test
    fun Test1Create() {

        // ----------------------------- Set Up -----------------------------
        val expected : HTUDataBean = HTUDataBean()
        expected.name = "testuser"
        expected.age = "20"
        expected.message = "testuserは食べないよ"

        // ----------------------------- execute -----------------------------
        HTUDataServiceCriteriaAPI?.run { createHtu(expected)}

        val HTCDataBean: HTUDataBean = HTUDataBean(1)
        val actual = HTUDataServiceCriteriaAPI?.run {findById(HTCDataBean)}
        expected.id = 1

        // ----------------------------- Verify -----------------------------
        actual?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }
    }

    /**
     * 【cRud】-------------------------------------------------------------------------
     * Createのテスト
     */
    @Test
    @Throws(Exception::class)
    fun Test2Checkroperty() {

        // ----------------------------- Set Up -----------------------------
        val expected : HTUDataBean = HTUDataBean()
        expected.name = "testuser"
        expected.age = "20"
        expected.message = "testuserは食べないよ"

        // ----------------------------- execute -----------------------------
        HTUDataServiceCriteriaAPI?.run { createHtu(expected)}
        expected.id = 1

        // ----------------------------- execute -----------------------------
        val actual = HTUDataServiceCriteriaAPI?.run { findById(HTUDataBean(1)) }

        // ----------------------------- Verify -----------------------------
        actual?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }
    }

    @Test
    @Throws(Exception::class)
    fun Test2_1FindAll() {

        // ----------------------------- Set Up -----------------------------
        val name = "testuser"
        val age = "20"
        val message = "testuserは食べないよ"

        // ----------------------------- Set Up -----------------------------
        val expected1 : HTUDataBean = HTUDataBean()
        val expected2 : HTUDataBean = HTUDataBean()
        val expected3 : HTUDataBean = HTUDataBean()
        val expected4 : HTUDataBean = HTUDataBean()
        expected1.name = "testuser"
        expected1.age = "20"
        expected1.message = "testuserは食べないよ"
        expected2.name = "testuser"
        expected2.age = "20"
        expected2.message = "testuserは食べないよ"
        expected3.name = "testuser"
        expected3.age = "20"
        expected3.message = "testuserは食べないよ"
        expected4.name = "testuser"
        expected4.age = "20"
        expected4.message = "testuserは食べないよ"

        // ----------------------------- execute -----------------------------
        HTUDataServiceCriteriaAPI?.run { createHtu(expected1)}
        HTUDataServiceCriteriaAPI?.run { createHtu(expected2)}
        HTUDataServiceCriteriaAPI?.run { createHtu(expected3)}
        HTUDataServiceCriteriaAPI?.run { createHtu(expected4)}

        //-----------------------------  execute -----------------------------
        val actual = HTUDataServiceCriteriaAPI?.run{ findAll() }

        // ----------------------------- Verify -----------------------------
        assertThat(actual?.run { size }, be(4))
    }

    @Test
    @Throws(Exception::class)
    fun Test2_2FindMany() {

        // ----------------------------- Set Up -----------------------------
        val name = "testuser"
        val age = "20"
        val message = "testuserは食べないよ"

        HTUDataServiceCriteriaAPI?.run { createHtu(HTUDataBean(1,name, age, message)) }
        val expected: HTUDataBean = HTUDataBean(1, name, age, message)

        // ----------------------------- execute -----------------------------
        val HTUDataBean1 = HTUDataBean(1, name, age, message)
        val HTUDataBean2 = HTUDataBean(0, name)
        val HTUDataBean3 = HTUDataBean(0, name, message)
        val actual1 = HTUDataServiceCriteriaAPI?.run { findMany(HTUDataBean1) }
        val actual2 = HTUDataServiceCriteriaAPI?.run { findMany(HTUDataBean2) }
        val actual3 = HTUDataServiceCriteriaAPI?.run { findMany(HTUDataBean3) }

        // ----------------------------- Verify -----------------------------
        actual1?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }
        actual2?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }
        actual3?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }

    }

    /**
     * 【crUd】-------------------------------------------------------------------------
     * Updateのテスト
     */
    @Test
    @Throws(Exception::class)
    fun Test3Update() {

        // ----------------------------- Set Up -----------------------------
        val name = "testuser"
        val age = "20"
        val message = "testuserは食べないよ"

        HTUDataServiceCriteriaAPI?.run { createHtu(HTUDataBean(1, name, age, message)) }
        val target = HTUDataServiceCriteriaAPI?.run { findById(HTUDataBean(1)) }

        val nameUpdate = "usertest"
        val ageUpdate = "30"
        val messageUpdate = "usertestにupdateしたよ"

        target?.forEach { HTUDataBean ->
            HTUDataBean.name = nameUpdate
            HTUDataBean.age = ageUpdate
            HTUDataBean.message = messageUpdate
        }

        HTUDataServiceCriteriaAPI?.run { update(target?.get(0) as HTUDataBean) }

        // ----------------------------- execute -----------------------------
        val expected = HTUDataBean(1, nameUpdate, ageUpdate, messageUpdate)
        val actual = HTUDataServiceCriteriaAPI?.run { findById(HTUDataBean(1)) }

        // ----------------------------- Verify -----------------------------
        actual?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }
    }

    /**
     * 【cruD】-------------------------------------------------------------------------
     * Deleteのテスト
     */
    @Test
    @Throws(Exception::class)
    fun Test4Delete() {

        // ----------------------------- Set Up -----------------------------
        val name = "testuser"
        val age = "20"
        val message = "testuserは食べないよ"

        HTUDataServiceCriteriaAPI?.run { createHtu(HTUDataBean(1, name, age, message)) }

        // ----------------------------- execute -----------------------------
        HTUDataServiceCriteriaAPI?.run { delete(HTUDataBean(1)) }
        val actual = HTUDataServiceCriteriaAPI?.run { findById(HTUDataBean(1)) }

        // ----------------------------- Verify -----------------------------
        assertThat(actual?.run { size }, be(1))

    }
}


