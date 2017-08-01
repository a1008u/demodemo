package com.example.model

import javax.persistence.*

/**
 * HTUDataテーブルのEntity.
 * @param id 主キー
 * @param name 名前
 * @param age 年齢
 * @param sex 性別 ( 0・・・ 女  1・・・男)
 */
@Entity
@Table(name = "htudata")
data class HTUData(@Id @GeneratedValue var id: Int? = 0,
                   @Column(nullable = false) var name: String = "",
                   @Column var age: String? = "0",
                   @Column var message: String = "どうかメッセージをください") {}
