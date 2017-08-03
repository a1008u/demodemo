package com.example.service

import com.example.bean.HTUDataBean

public abstract class HTUDataService {

    // 【Crud】--------------------------------------------
    /**
     * 新規作成
     * @param HTUDataaBean Veiw上のデータ
     */
    abstract fun create(HTUDataBean: HTUDataBean) :Unit


    // 【cRud】--------------------------------------------
    /**
     * 検索(id利用)
     * @param MyDataBean Veiw上のデータ
     * *
     * @return MyDataBean Veiwに表示する検索結果
     */
    abstract fun findById(MyDataBean: HTUDataBean): HTUDataBean

    /**
     * 全件検索
     * @param HTUDataBean Veiw上のデータ
     * *
     * @return HTUDataBean Veiwに表示する検索結果
     */
    abstract fun findAll(): MutableList<HTUDataBean>

    /**
     * 検索(動的に検索条件を設定)
     * @param HTUDataBean Veiw上のデータ
     * *
     * @return HTUDataBeanList Veiwに表示する検索結果
     */
    abstract fun findMany(HTUDataBean: HTUDataBean): MutableList<HTUDataBean>

    // 【crUd】--------------------------------------------
    /**
     * 更新(id利用)
     * @param HTUDataBean Veiw上のデータ
     */
    abstract fun update(HTUDataBean: HTUDataBean)

    // 【cruD】--------------------------------------------
    /**
     * 削除
     * @param HTUDataBean Veiw上のデータ(PKとPK以外で挙動が変わるよ)
     */
    abstract fun delete(HTUDataBean: HTUDataBean)

}