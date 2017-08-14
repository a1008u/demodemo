package com.example.repository

import com.example.model.HTUData
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
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

    @Query("SELECT e FROM HTUData e WHERE name = :name")
    fun findByname(@Param("name") name :String) : HTUData

    @Query("SELECT e FROM HTUData e WHERE name = :name" + " ORDER BY e.age")
    fun findBynamelist(@Param("name") name :String) : MutableList<HTUData>

}