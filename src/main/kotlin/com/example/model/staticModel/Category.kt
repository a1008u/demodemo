package com.example.model.staticModel

import javax.persistence.*

@Entity
@Table(name = "category")
class Category(
        @Id @GeneratedValue var code :Int = 0,
        @Column var codeName : String = "test"){}