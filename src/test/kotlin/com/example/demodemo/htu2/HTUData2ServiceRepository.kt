package com.example.demodemo.htu2

import com.example.bean.HTUData2Bean
import com.example.repository.CategoryRepository
import com.example.service.htu2Service.HTUData2ServiceRepository
import org.hamcrest.beans.SamePropertyValuesAs
import org.junit.Assert.*
import org.hamcrest.CoreMatchers.`is` as be
import org.junit.FixMethodOrder
import org.junit.Ignore
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
class HTUData2ServiceTest{
    @Autowired
    private val HTUData2ServiceRepository : HTUData2ServiceRepository? = null

    @Autowired
    private val CategoryRepository : CategoryRepository? = null


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
        HTUData2ServiceRepository?.run { createHtu(expected)}

        val HTCDataBean: HTUData2Bean = HTUData2Bean(1)
        val actual = HTUData2ServiceRepository?.run {findById(HTCDataBean)}
        expected.id = 1

        // ----------------------------- Verify -----------------------------
        actual?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }
    }

    /**
     * 【cRud】-------------------------------------------------------------------------
     * Readのテスト
     */
    @Test
    @Throws(Exception::class)
    fun Test2Checkroperty() {

        // ----------------------------- Set Up -----------------------------
        val name = "testuser"
        val age = "20"
        val message = "testuserは食べないよ"

        val codeName ="test"

        HTUData2ServiceRepository?.run { createHtu(HTUData2Bean(1,name, age, message)) }
        val expected: HTUData2Bean = HTUData2Bean(1, name, age, message)

        // ----------------------------- execute -----------------------------
        val actual = HTUData2ServiceRepository?.run { findById(HTUData2Bean(1)) }

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

        HTUData2ServiceRepository?.run { createHtu(HTUData2Bean(1,name, age, message)) }
        HTUData2ServiceRepository?.run { createHtu(HTUData2Bean(2,name, age, message)) }
        HTUData2ServiceRepository?.run { createHtu(HTUData2Bean(3,name, age, message)) }
        HTUData2ServiceRepository?.run { createHtu(HTUData2Bean(4,name, age, message)) }

        //-----------------------------  execute -----------------------------
        val actual = HTUData2ServiceRepository?.run{ findAll() }

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

        HTUData2ServiceRepository?.run { createHtu(HTUData2Bean(1,name, age, message)) }
        val expected: HTUData2Bean = HTUData2Bean(1, name, age, message)

        // ----------------------------- execute -----------------------------
        val HTUData2Bean1 = HTUData2Bean(1, name, age, message)
        val HTUData2Bean2 = HTUData2Bean(0, name)
        val HTUData2Bean3 = HTUData2Bean(0, name, message)
        val actual1 = HTUData2ServiceRepository?.run { findMany(HTUData2Bean1) }
        val actual2 = HTUData2ServiceRepository?.run { findMany(HTUData2Bean2) }
        val actual3 = HTUData2ServiceRepository?.run { findMany(HTUData2Bean3) }

        // ----------------------------- Verify -----------------------------
        actual1?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }
        actual2?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }
        actual3?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }

    }

    @Test
    @Throws(Exception::class)
    fun Test2_3FindbyName() {

        // ----------------------------- Set Up -----------------------------
        val name = "testuser"
        val age = "20"
        val message = "testuserは食べないよ"

        HTUData2ServiceRepository?.run { createHtu(HTUData2Bean(1, name, age, message)) }

        //-----------------------------  execute -----------------------------
        val actual = HTUData2ServiceRepository?.run{ findByName(HTUData2Bean(name = "testuser")) }

        // ----------------------------- Verify -----------------------------
        assertThat(actual?.run { size }, be(1))
        actual?.run { forEach { e -> println("_____テスト結果_____ $e") } }
    }

    @Ignore
    @Test
    @Throws(Exception::class)
    fun Test2_4FindbyNameList() {

        // ----------------------------- Set Up -----------------------------
        val name = "testuser"
        val age = "20"
        val message = "testuserは食べないよ"

        HTUData2ServiceRepository?.run { createHtu(HTUData2Bean(1, name, "21", message)) }
        HTUData2ServiceRepository?.run { createHtu(HTUData2Bean(2, name, "52", message)) }
        HTUData2ServiceRepository?.run { createHtu(HTUData2Bean(3, name, "10", message)) }
        HTUData2ServiceRepository?.run { createHtu(HTUData2Bean(4, name, age, message)) }

        //-----------------------------  execute -----------------------------
        //val actual = HTUData2ServiceRepository?.run{ findByNameList(HTUData2Bean(name = name)) }
        val actual = HTUData2ServiceRepository?.run{ findAll() }

        // ----------------------------- Verify -----------------------------
        assertThat(actual?.run { size }, be(4))
        actual?.run { forEach { e -> println("_____テスト結果_____ $e") } }
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

        HTUData2ServiceRepository?.run { createHtu(HTUData2Bean(1, name, age, message)) }
        val target = HTUData2ServiceRepository?.run { findById(HTUData2Bean(1)) }

        val nameUpdate = "usertest"
        val ageUpdate = "30"
        val messageUpdate = "usertestにupdateしたよ"

        target?.forEach { HTUData2Bean ->
            HTUData2Bean.name = nameUpdate
            HTUData2Bean.age = ageUpdate
            HTUData2Bean.message = messageUpdate
        }

        HTUData2ServiceRepository?.run { update(target?.get(0) as HTUData2Bean) }

        // ----------------------------- execute -----------------------------
        val expected = HTUData2Bean(1, nameUpdate, ageUpdate, messageUpdate)
        val actual = HTUData2ServiceRepository?.run { findById(HTUData2Bean(1)) }

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

        HTUData2ServiceRepository?.run { createHtu(HTUData2Bean(1, name, age, message)) }

        // ----------------------------- execute -----------------------------
        HTUData2ServiceRepository?.run { delete(HTUData2Bean(1)) }
        val actual = HTUData2ServiceRepository?.run { findById(HTUData2Bean(1)) }

        // ----------------------------- Verify -----------------------------
        assertThat(actual?.run { size }, be(1))

    }
}