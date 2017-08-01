package com.example.algorithm.typeA

import java.util.*

class Mathematics {

    val listNumber = listOf(Math.abs(Random().nextInt(100))
            , Math.abs(Random().nextInt(100))
            , Math.abs(Random().nextInt(100)))

    fun max() {

        println("====最大値を求める====")

        print(listNumber)
        var maxInt = listNumber.run {
            var max = this.iterator().next()
            this.iterator().forEach { if( max < it) max = it }
            max
        }

        /* -----------------------------------
        var listNumberIte = this.iterator()
        var max2 = this.iterator().next()
        while (listNumberIte.hasNext()) {
            var charanger = listNumberIte.next()
            this.filter { max2 < charanger }
            max2 = charanger
        }
        ----------------------------------- */

        println("最大値：" + maxInt)

    }

    fun min() {

        println("====最小値を求める====")

        print(listNumber)
        var mixInt = listNumber.run {
            var mix = this.iterator().next()
            this.iterator().forEach { if( mix > it) mix = it }
            mix
        }

        println("最小値：" + mixInt)

    }

    fun sum(){

        print(listNumber)
        var sumInt = listNumber.run {
            var sum = 0
            this.iterator().forEach { sum += it }
            sum
        }

        println("合計値：" + sumInt)
    }


    fun compaire(){

        val listNumber2 = listOf(Math.abs(Random().nextInt(100)), Math.abs(Random().nextInt(100)))
        println(listNumber2)

        listNumber2.apply {
            var A = this.iterator().next()
            this.iterator().forEach {
                if(it > A)   println("$it  【1番目の数値の方が大きい】")
                if(it === A) println("$it  【1番目と2番目は同じ数値です】")
                if(it < A)   println("$it  【2番目の数値の方が大きい】")
            }
        }

    }

}


