package com.example.repository

import com.example.model.dynamicModel.HTUData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
//import samples.model.HTUData


/**
 * usersテーブルのRepository.
 */

@Repository
interface HTURepository : JpaRepository<HTUData, Int> , JpaSpecificationExecutor<HTUData> {

    fun findByid(id: Int): HTUData

    @Query("SELECT e FROM HTUData e JOIN FETCH e.category WHERE name = :name")
    fun findByname(@Param("name") name :String) :  MutableList<HTUData>

    /**
     * N+1問題をJOIN FETCHで打開するパターン
     */
    @Query("SELECT e FROM HTUData e JOIN FETCH e.category WHERE name = :name" + " ORDER BY e.age")
    fun findBynamelist(@Param("name") name :String) : MutableList<HTUData>

}