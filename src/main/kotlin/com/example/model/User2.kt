package com.example.model

/**
 * Created by version1 on 2017/02/11.
 */

import javax.persistence.*

/**
 * userテーブルのEntity.
 * @param id 主キー
 * @param name 名前
 * @param age 年齢
 * @param sex 性別 ( 0・・・ 女  1・・・男)
 */
@Entity
@Table(name = "users2")
data class User2(@Id @GeneratedValue var id: Int? = 0,
                @Column(nullable = false) var name: String = "",
                @Column var age: Int? = 0,
                @Column(nullable = false) var sex: Int = 0) {
}


