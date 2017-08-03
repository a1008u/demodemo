package com.example.form

import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import com.example.bean.HTUDataBean

class HTUDataForm{

    // 画面上の情報を取得---------------
    private val id: Int? = null

    private val name: String? = null

    private val age: String? = null

    private val message: String? = null

    // 画面上で表示するList---------------
    var htudatalist: MutableList<HTUDataBean>? = null

    @NotNull
    @Pattern(regexp = "Repository|JPQL|Criteria API")
    var jpa: String = "Repository"
        get() {return jpa}

    @NotNull
    @Pattern(regexp = "create|read|update|delete")
    var sql: String = "read"
        get() = sql

}