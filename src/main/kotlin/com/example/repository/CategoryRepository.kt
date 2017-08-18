package com.example.repository

import com.example.model.staticModel.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Int> { }