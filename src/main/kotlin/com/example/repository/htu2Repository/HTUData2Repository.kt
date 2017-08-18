package com.example.repository.htu2Repository


import com.example.model.dynamicModel.HTUData2
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

/**
 * usersテーブルのRepository.
 */

@Repository
interface HTUData2Repository : JpaRepository<HTUData2, Int> , JpaSpecificationExecutor<HTUData2> {

    fun findByid(id: Int): HTUData2

    @Query("SELECT e FROM HTUData e WHERE e.name = :name")
    fun findByname(@Param("name") name :String) : HTUData2

    @Query("SELECT e FROM HTUData e WHERE e.name = :name" + " ORDER BY e.age")
    fun findBynamelist(@Param("name") name :String) : MutableList<HTUData2>

}