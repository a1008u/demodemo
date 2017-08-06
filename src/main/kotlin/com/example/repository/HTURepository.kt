package com.example.repository

import com.example.model.HTUData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
//import samples.model.HTUData


/**
 * usersテーブルのRepository.
 */

@Repository
interface HTURepository : JpaRepository<HTUData, Int> , JpaSpecificationExecutor<HTUData> {

    fun findByid(id: Int?): HTUData


}