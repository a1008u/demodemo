package samples.service

/**
 * Created by version1 on 2017/02/11.
 */

import com.example.repository.HTURepository
import com.example.bean.HTUDataBean
import com.example.model.HTUData
import com.example.repository.SpecificationsDetailHTUData
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * DBからのデータ取得と加工を行う.
 */
@Service
open class HTUDataServiceRepository {

    @Autowired
    private val htuRepository: HTURepository? = null

    @Autowired
    private val SpecificationsDetailHTUData: SpecificationsDetailHTUData? = null


    /**
     * HTUDataの登録(Crud)
     * @param HTUDataBean
     */
    fun create(HTUDataBean: HTUDataBean): Unit {
        val HTUData = HTUData()
        BeanUtils.copyProperties(HTUDataBean, HTUData)
        htuRepository?.run{ create(HTUDataBean) }
    }

    /**
     * idを利用した検索(cRud)
     * @param HTUDataBean
     * @return HTUDataBean
     */
    fun findById(HTUDataBean: HTUDataBean): HTUDataBean {
        val HTUData = htuRepository?.run{ findByid(HTUDataBean.id) }
        HTUData?.let {  it -> BeanUtils.copyProperties(it, HTUDataBean) }
        return HTUDataBean
    }

    /**
     * 全件検索(cRud)
     * @param HTUDataBean
     * @return HTUDataBeanList  MutableList<HTUDataBean>
     */
    fun findAll(HTUDataBean: HTUDataBean): MutableList<HTUDataBean> {
        val HTUDataList = htuRepository?.run { findAll() }

        val HTUDataBeanList = HTUDataList?.run {
            val HTUDataBeanList = mutableListOf<HTUDataBean>()
            this.forEach { HTUData ->
                val HTUDataBean = HTUDataBean()
                BeanUtils.copyProperties(HTUData, HTUDataBean)
                HTUDataBeanList.add(HTUDataBean)
            }
            HTUDataBeanList
        }

        return HTUDataBeanList as MutableList<HTUDataBean> //TODO
    }

    /**
     * 検索(動的に検索条件を設定)
     * @param HTUDataBean
     * @return MyDataBeanList Veiwに表示する検索結果
     */
    fun findMany(HTUDataBean: HTUDataBean): MutableList<HTUDataBean> {

        val HTUDataList = SpecificationsDetailHTUData?.run { findMany(HTUDataBean) }

        val HTUDataBeanList = HTUDataList?.run {
            val HTUDataBeanList = mutableListOf<HTUDataBean>()
            this.forEach { HTUData ->
                val HTUDataBean = HTUDataBean()
                BeanUtils.copyProperties(HTUData, HTUDataBean)
                HTUDataBeanList.add(HTUDataBean)
            }
            HTUDataBeanList
        }

        return HTUDataBeanList as MutableList<HTUDataBean> //TODO
    }

    /**
     * HTUDataの更新(crUd)
     * @param HTUDataBean
     */
    fun update(HTUDataBean: HTUDataBean): Unit {
        val HTUData = htuRepository?.run{ findByid(HTUDataBean.id) }
        HTUData?.let { BeanUtils.copyProperties(HTUDataBean, it) } ?: BeanUtils.copyProperties(HTUDataBean, HTUDataBean)
        htuRepository?.run { saveAndFlush(HTUData) }
    }

    /**
     * HTUDataの削除(crUd)
     * @param HTUDataBean
     */
    fun delete(HTUDataBean: HTUDataBean): Unit {

        val HTUData = htuRepository?.run{ findByid(HTUDataBean.id) }
        HTUData?.let {  htuRepository?.delete(it) }
    }


}