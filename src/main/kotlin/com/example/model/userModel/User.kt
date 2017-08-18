package com.example.model.userModel

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
@Table(name = "users")
data class User(@Id @GeneratedValue var id: String? = "0",
                @Column(nullable = false) var name: String = "",
                @Column var age: String? = "0",
                @Column(nullable = false) var sex: String = "0") {
}


