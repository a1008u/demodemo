package com.example.bean

import com.example.model.staticModel.Category

/**
 * controller - serviceのやりとりに利用する
 * @param id 主キー
 * @param name 名前
 * @param age 年齢
 * @param message メッセージ
 */
data class HTUDataBean(var id: Int = 0,
                   var name: String = "",
                   var age: String = "",
                   var message: String = "どうかメッセージをください",
                   var category: Category? = null) {
}