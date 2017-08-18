package com.example.demodemo.htu2

import com.example.bean.HTUData2Bean
import com.example.service.htu2Service.HTUData2ServiceCriteriaAPI
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
class HTUData2ServiceCriteriaAPITest {

    @Autowired
    private val HTUData2ServiceCriteriaAPI: HTUData2ServiceCriteriaAPI? = null

    /**
     * 【Crud】-------------------------------------------------------------------------
     * Createのテスト
     */
    @Test
    fun Test1Create() {

        // ----------------------------- Set Up -----------------------------
        val expected : HTUData2Bean = HTUData2Bean()
        expected.name = "testuser"
        expected.age = "20"
        expected.message = "testuserは食べないよ"

        // ----------------------------- execute -----------------------------
        HTUData2ServiceCriteriaAPI?.run { createHtu(expected)}

        val HTCDataBean: HTUData2Bean = HTUData2Bean(1)
        val actual = HTUData2ServiceCriteriaAPI?.run {findById(HTCDataBean)}
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
        val expected : HTUData2Bean = HTUData2Bean()
        expected.name = "testuser"
        expected.age = "20"
        expected.message = "testuserは食べないよ"

        // ----------------------------- execute -----------------------------
        HTUData2ServiceCriteriaAPI?.run { createHtu(expected)}
        expected.id = 1

        // ----------------------------- execute -----------------------------
        val actual = HTUData2ServiceCriteriaAPI?.run { findById(HTUData2Bean(1)) }

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
        val expected1 : HTUData2Bean = HTUData2Bean()
        val expected2 : HTUData2Bean = HTUData2Bean()
        val expected3 : HTUData2Bean = HTUData2Bean()
        val expected4 : HTUData2Bean = HTUData2Bean()
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
        HTUData2ServiceCriteriaAPI?.run { createHtu(expected1)}
        HTUData2ServiceCriteriaAPI?.run { createHtu(expected2)}
        HTUData2ServiceCriteriaAPI?.run { createHtu(expected3)}
        HTUData2ServiceCriteriaAPI?.run { createHtu(expected4)}

        //-----------------------------  execute -----------------------------
        val actual = HTUData2ServiceCriteriaAPI?.run{ findAll() }

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

        HTUData2ServiceCriteriaAPI?.run { createHtu(HTUData2Bean(1,name, age, message)) }
        val expected: HTUData2Bean = HTUData2Bean(1, name, age, message)

        // ----------------------------- execute -----------------------------
        val HTUData2Bean1 = HTUData2Bean(1, name, age, message)
        val HTUData2Bean2 = HTUData2Bean(0, name)
        val HTUData2Bean3 = HTUData2Bean(0, name, message)
        val actual1 = HTUData2ServiceCriteriaAPI?.run { findMany(HTUData2Bean1) }
        val actual2 = HTUData2ServiceCriteriaAPI?.run { findMany(HTUData2Bean2) }
        val actual3 = HTUData2ServiceCriteriaAPI?.run { findMany(HTUData2Bean3) }

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

        HTUData2ServiceCriteriaAPI?.run { createHtu(HTUData2Bean(1, name, age, message)) }
        val target = HTUData2ServiceCriteriaAPI?.run { findById(HTUData2Bean(1)) }

        val nameUpdate = "usertest"
        val ageUpdate = "30"
        val messageUpdate = "usertestにupdateしたよ"

        target?.forEach { HTUData2Bean ->
            HTUData2Bean.name = nameUpdate
            HTUData2Bean.age = ageUpdate
            HTUData2Bean.message = messageUpdate
        }

        HTUData2ServiceCriteriaAPI?.run { update(target?.get(0) as HTUData2Bean) }

        // ----------------------------- execute -----------------------------
        val expected = HTUData2Bean(1, nameUpdate, ageUpdate, messageUpdate)
        val actual = HTUData2ServiceCriteriaAPI?.run { findById(HTUData2Bean(1)) }

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

        HTUData2ServiceCriteriaAPI?.run { createHtu(HTUData2Bean(1, name, age, message)) }

        // ----------------------------- execute -----------------------------
        HTUData2ServiceCriteriaAPI?.run { delete(HTUData2Bean(1)) }
        val actual = HTUData2ServiceCriteriaAPI?.run { findById(HTUData2Bean(1)) }

        // ----------------------------- Verify -----------------------------
        assertThat(actual?.run { size }, be(1))

    }
}


