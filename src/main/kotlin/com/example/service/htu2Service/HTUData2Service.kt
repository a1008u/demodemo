package com.example.service

import com.example.bean.HTUData2Bean


abstract class HTUData2Service {

    // 【Crud】--------------------------------------------
    /**
     * 新規作成
     * @param HTUData2aBean Veiw上のデータ
     */
    abstract fun createHtu(HTUData2Bean: HTUData2Bean) :Unit


    // 【cRud】--------------------------------------------
    /**
     * 検索(id利用)
     * @param MyDataBean Veiw上のデータ
     * *
     * @return MyDataBean Veiwに表示する検索結果
     */
    abstract fun findById(HTUData2Bean: HTUData2Bean): MutableList<HTUData2Bean>

    /**
     * 全件検索
     * @param HTUData2Bean Veiw上のデータ
     * *
     * @return HTUData2Bean Veiwに表示する検索結果
     */
    abstract fun findAll(): MutableList<HTUData2Bean>

    /**
     * 検索(動的に検索条件を設定)
     * @param HTUData2Bean Veiw上のデータ
     * *
     * @return HTUData2BeanList Veiwに表示する検索結果
     */
    abstract fun findMany(HTUData2Bean: HTUData2Bean): MutableList<HTUData2Bean>

    // 【crUd】--------------------------------------------
    /**
     * 更新(id利用)
     * @param HTUData2Bean Veiw上のデータ
     */
    abstract fun update(HTUData2Bean: HTUData2Bean)

    // 【cruD】--------------------------------------------
    /**
     * 削除
     * @param HTUData2Bean Veiw上のデータ(PKとPK以外で挙動が変わるよ)
     */
    abstract fun delete(HTUData2Bean: HTUData2Bean)

}