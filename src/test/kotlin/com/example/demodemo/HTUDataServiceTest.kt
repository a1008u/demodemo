package com.example.demodemo

import com.example.bean.HTUDataBean
import com.example.model.staticModel.Category
import com.example.repository.CategoryRepository
import com.example.service.HTUDataServiceRepository
import org.hamcrest.beans.SamePropertyValuesAs
import org.junit.Assert.*
import org.junit.Before
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
class HTUDataServiceTest{
    @Autowired
    private val HTUDataServiceRepository : HTUDataServiceRepository? = null

    @Autowired
    private val CategoryRepository : CategoryRepository? = null

    val testName = "testuser"
    val testAge = "20"
    val testMessage = "testuserは食べないよ"
    val testMen = "men"
    val testWomen = "women"

    /**
     * 【Before】-------------------------------------------------------------------------
     * 共通項目のSetUpを行います。
     */
    @Before
    fun setUp(){
        // カテゴリー作成
        CategoryRepository?.save(Category(0, testMen))
        CategoryRepository?.save(Category(0, testWomen))

        // HTUData作成
        HTUDataServiceRepository?.run { createHtu(HTUDataBean(1,testName, testAge, testMessage, Category(2, testWomen))) }
        HTUDataServiceRepository?.run { createHtu(HTUDataBean(2,testName, testAge, testMessage, Category(1, testMen))) }
        HTUDataServiceRepository?.run { createHtu(HTUDataBean(3,testName, testAge, testMessage, Category(2, testWomen))) }
        HTUDataServiceRepository?.run { createHtu(HTUDataBean(4,testName, testAge, testMessage, Category(1, testMen))) }
    }

    /**
     * 【Crud】-------------------------------------------------------------------------
     * Createのテスト
     */
    @Test
    fun Test1Create() {

        // ----------------------------- Set Up -----------------------------
        val expected: HTUDataBean = HTUDataBean(1, testName, testAge, testMessage, Category(2, testWomen))

        // ----------------------------- execute -----------------------------
        val actual = HTUDataServiceRepository?.run {findById(HTUDataBean(1))}
        expected.id = 1

        // ----------------------------- Verify -----------------------------
        actual?.forEach { ac ->
            assertThat(ac.id, be((SamePropertyValuesAs.samePropertyValuesAs(expected.id))))
            assertThat(ac.name, be((SamePropertyValuesAs.samePropertyValuesAs(expected.name))))
            assertThat(ac.age, be((SamePropertyValuesAs.samePropertyValuesAs(expected.age))))
            assertThat(ac.message, be((SamePropertyValuesAs.samePropertyValuesAs(expected.message))))
            assertThat(ac.category, be((SamePropertyValuesAs.samePropertyValuesAs(expected.category))))
        }
    }

    /**
     * 【cRud】-------------------------------------------------------------------------
     *  idによるReadのテスト
     */
    @Test
    @Throws(Exception::class)
    fun Test2_0Checkroperty() {

        // ----------------------------- Set Up -----------------------------
        val expected: HTUDataBean = HTUDataBean(1, testName, testAge, testMessage, Category(1, testMen))

        // ----------------------------- execute -----------------------------
        val actual = HTUDataServiceRepository?.run { findById(HTUDataBean(2)) }
        actual?.forEach {ac ->println(ac.category?.codeName)}

        // ----------------------------- Verify -----------------------------
        actual?.forEach { ac -> assertThat(ac.category, be((SamePropertyValuesAs.samePropertyValuesAs(expected.category)))) }
    }

    @Test
    @Throws(Exception::class)
    fun Test2_1FindAll() {

        // ----------------------------- Set Up -----------------------------

        //-----------------------------  execute -----------------------------
        val actual = HTUDataServiceRepository?.run{ findAll() }

        // ----------------------------- Verify -----------------------------
        assertThat(actual?.run { size }, be(4))
    }

    @Test
    @Throws(Exception::class)
    fun Test2_2FindMany() {

        // ----------------------------- Set Up -----------------------------
        val expected: HTUDataBean = HTUDataBean(1, testName, testAge, testMessage, Category(2, testWomen))

        // ----------------------------- execute -----------------------------
        val HTUDataBean1 = HTUDataBean(1, testName, testAge, testMessage, Category(2, testWomen))
        val HTUDataBean2 = HTUDataBean(0, testName)?.also { it.category =Category(1, testMen) }
        val HTUDataBean3 = HTUDataBean(0, testName, testMessage)?.apply { category = Category(2, testWomen) }
        val HTUDataBean4 = HTUDataBean(0, testName, testMessage)?.apply { category = Category(1, testMen) }
        val actual1 = HTUDataServiceRepository?.run { findMany(HTUDataBean1) }
        val actual2 = HTUDataServiceRepository?.run { findMany(HTUDataBean2) }
        val actual3 = HTUDataServiceRepository?.run { findMany(HTUDataBean3) }
        val actual4 = HTUDataServiceRepository?.run { findMany(HTUDataBean4) }

        // ----------------------------- Verify -----------------------------
        actual1?.forEach { ac -> assertThat(ac.category, be((SamePropertyValuesAs.samePropertyValuesAs(expected.category)))) }
        //actual2?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }
        //actual3?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }
        //actual4?.forEach { ac -> assertThat(ac, be((SamePropertyValuesAs.samePropertyValuesAs(expected)))) }

    }

    @Test
    @Throws(Exception::class)
    fun Test2_3FindbyName() {

        // ----------------------------- Set Up -----------------------------

        //-----------------------------  execute -----------------------------
        val actual = HTUDataServiceRepository?.run{ findByName(HTUDataBean(name = testName)) }

        // ----------------------------- Verify -----------------------------
        assertThat(actual?.run { size }, be(4))
        actual?.run { forEach { e -> println("_____テスト結果_____ $e") } }
    }

    @Test
    @Throws(Exception::class)
    fun Test2_4FindbyNameList() {

        // ----------------------------- Set Up -----------------------------

        //-----------------------------  execute -----------------------------
        val actual = HTUDataServiceRepository?.run{ findByNameList(HTUDataBean(name = testName)) }

        // ----------------------------- Verify -----------------------------
        assertThat(actual?.run { size }, be(4))
        actual?.run { forEach { HTUDataBean -> println("_____テスト結果_____ $HTUDataBean") } }
    }

    /**
     * 【crUd】-------------------------------------------------------------------------
     * Updateのテスト
     */
    @Test
    @Throws(Exception::class)
    fun Test3Update() {

        // ----------------------------- Set Up -----------------------------
        val target = HTUDataServiceRepository?.run { findById(HTUDataBean(1)) }

        val nameUpdate = "usertest"
        val ageUpdate = "30"
        val messageUpdate = "usertestにupdateしたよ"
        val category = CategoryRepository?.run{ findOne(1) }

        target?.forEach { HTUDataBean ->
            HTUDataBean.name = nameUpdate
            HTUDataBean.age = ageUpdate
            HTUDataBean.message = messageUpdate
            HTUDataBean.category = category
        }

        HTUDataServiceRepository?.run { update(target?.get(0) as HTUDataBean) }

        // ----------------------------- execute -----------------------------
        val expected = HTUDataBean(1, nameUpdate, ageUpdate, messageUpdate, category)
        val actual = HTUDataServiceRepository?.run { findById(HTUDataBean(1)) }

        // ----------------------------- Verify -----------------------------
        actual?.forEach { ac ->
            assertThat(ac.id, be((SamePropertyValuesAs.samePropertyValuesAs(expected.id))))
            assertThat(ac.name, be((SamePropertyValuesAs.samePropertyValuesAs(expected.name))))
            assertThat(ac.age, be((SamePropertyValuesAs.samePropertyValuesAs(expected.age))))
            assertThat(ac.message, be((SamePropertyValuesAs.samePropertyValuesAs(expected.message))))
            assertThat(ac.category, be((SamePropertyValuesAs.samePropertyValuesAs(expected.category))))
        }
    }

    /**
     * 【cruD】-------------------------------------------------------------------------
     * Deleteのテスト
     */
    @Test
    @Throws(Exception::class)
    fun Test4Delete() {

        // ----------------------------- Set Up -----------------------------
        val expected = CategoryRepository?.run{ findOne(1) }

        // ----------------------------- execute ----------------------------
        HTUDataServiceRepository?.run { delete(HTUDataBean(1)) }
        val actualHTUDate = HTUDataServiceRepository?.run { findAll() }
        val actualCategory = CategoryRepository?.run { findOne(1) }

        // ----------------------------- Verify -----------------------------
        assertThat(actualHTUDate?.run { size }, be(3))
        assertThat( actualCategory, be((SamePropertyValuesAs.samePropertyValuesAs(expected))))

    }
}


