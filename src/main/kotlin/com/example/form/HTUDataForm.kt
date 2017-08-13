package com.example.form

import com.example.bean.HTUDataBean
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern


/**
 * validationを実行させる場合は、SpringBoot ver1.56時点では、
 * kotlinのコンストラクタでは利用ではうまく処理することができない。
 *
 */
class HTUDataForm{
        // 画面上の情報を取得---------------
        @field:Pattern(regexp="[0-9]*")
        var id: String = ""

        var name: String = ""

        var age: String= ""

        var message: String= ""

        // 画面上で表示するList---------------
        var htudatalist: MutableList<HTUDataBean>? = null

        @NotNull
        @Pattern(regexp = "Repository|JPQL|Criteria API")
        var jpa: String = "Repository"

        @NotNull
        @Pattern(regexp = "create|read|update|delete")
        var sql: String = "read"

}