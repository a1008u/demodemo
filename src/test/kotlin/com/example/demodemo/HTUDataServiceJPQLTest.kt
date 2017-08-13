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

// @RunWith(SpringRunner::class)
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class HTUDataServiceJPQLTest{

    @Autowired
    private val HTUDataServiceJPQL : HTUDataServiceRepository? = null

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
        HTUDataServiceJPQL?.run { createHtu(expected)}

        val HTCDataBean: HTUDataBean = HTUDataBean(1)
        val actual = HTUDataServiceJPQL?.run {findById(HTCDataBean)}
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
        val name = "testuser"
        val age = "20"
        val message = "testuserは食べないよ"

        HTUDataServiceJPQL?.run { createHtu(HTUDataBean(1,name, age, message)) }
        val expected: HTUDataBean = HTUDataBean(1, name, age, message)

        // ----------------------------- execute -----------------------------
        val actual = HTUDataServiceJPQL?.run { findById(HTUDataBean(1)) }

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

        HTUDataServiceJPQL?.run { createHtu(HTUDataBean(1,name, age, message)) }
        HTUDataServiceJPQL?.run { createHtu(HTUDataBean(2,name, age, message)) }
        HTUDataServiceJPQL?.run { createHtu(HTUDataBean(3,name, age, message)) }
        HTUDataServiceJPQL?.run { createHtu(HTUDataBean(4,name, age, message)) }

        //-----------------------------  execute -----------------------------
        val actual = HTUDataServiceJPQL?.run{ findAll() }

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

        HTUDataServiceJPQL?.run { createHtu(HTUDataBean(1,name, age, message)) }
        val expected: HTUDataBean = HTUDataBean(1, name, age, message)

        // ----------------------------- execute -----------------------------
        val HTUDataBean1 = HTUDataBean(1, name, age, message)
        val HTUDataBean2 = HTUDataBean(0, name)
        val HTUDataBean3 = HTUDataBean(0, name, message)
        val actual1 = HTUDataServiceJPQL?.run { findMany(HTUDataBean1) }
        val actual2 = HTUDataServiceJPQL?.run { findMany(HTUDataBean2) }
        val actual3 = HTUDataServiceJPQL?.run { findMany(HTUDataBean3) }

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

        HTUDataServiceJPQL?.run { createHtu(HTUDataBean(1, name, age, message)) }
        val target = HTUDataServiceJPQL?.run { findById(HTUDataBean(1)) }

        val nameUpdate = "usertest"
        val ageUpdate = "30"
        val messageUpdate = "usertestにupdateしたよ"

        target?.forEach { HTUDataBean ->
            HTUDataBean.name = nameUpdate
            HTUDataBean.age = ageUpdate
            HTUDataBean.message = messageUpdate
        }

        HTUDataServiceJPQL?.run { update(target?.get(0) as HTUDataBean) }

        // ----------------------------- execute -----------------------------
        val expected = HTUDataBean(1, nameUpdate, ageUpdate, messageUpdate)
        val actual = HTUDataServiceJPQL?.run { findById(HTUDataBean(1)) }

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

        HTUDataServiceJPQL?.run { createHtu(HTUDataBean(1, name, age, message)) }

        // ----------------------------- execute -----------------------------
        HTUDataServiceJPQL?.run { delete(HTUDataBean(1)) }
        val actual = HTUDataServiceJPQL?.run { findById(HTUDataBean(1)) }

        // ----------------------------- Verify -----------------------------
        assertThat(actual?.run { size }, be(1))

    }
}


