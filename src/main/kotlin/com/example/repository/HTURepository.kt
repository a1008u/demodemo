package com.example.repository

import com.example.model.HTUData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository


/**
 * usersテーブルのRepository.
 */

@Repository
interface HTURepository : JpaRepository<HTUData, Long> , JpaSpecificationExecutor<HTUData> {

    fun findByid(id: Int?): HTUData


}