package com.example.bean

import javax.persistence.*

/**
 * controller - serviceのやりとりに利用する
 * @param id 主キー
 * @param name 名前
 * @param age 年齢
 * @param message メッセージ
 */
@Entity
data class HTUDataBean(var id: Int? = 0,
                   var name: String = "",
                   var age: String? = "0",
                   var message: String = "どうかメッセージをください") {}