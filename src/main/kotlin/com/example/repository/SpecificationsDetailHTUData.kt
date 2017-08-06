package com.example.repository


import com.example.bean.HTUDataBean
import com.example.model.HTUData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.domain.Specifications
import org.springframework.stereotype.Repository
//import samples.bean.HTUDataBean
//import samples.model.HTUData

@Repository
class SpecificationsDetailHTUData{

    @Autowired
    private val htuRepository: HTURepository? = null

    /**
     * 検索(動的に検索条件を設定)
     * @param HTUDataBean
     * @return MutableList<HTUData>
     */
    fun findMany(HTUDataBean: HTUDataBean): MutableList<HTUData> {
        return htuRepository?.run{ findAll(Specifications
                    .where(idContains(HTUDataBean.id))
                    .and(nameContains(HTUDataBean.name))
                    .and(ageContains(HTUDataBean.age))
                    .and(messageContains(HTUDataBean.message)))} as MutableList<HTUData>
    }

    private fun idContains(id: Int?): Specification<HTUData>? {
        return id?.let {Specification<HTUData> {
            root, query, cb -> cb.equal(root.get<HTUData>("id"), it) }
        }
    }

    private fun nameContains(name: String?): Specification<HTUData>? {
        return name?.let {Specification<HTUData> {
            root, query, cb -> cb.equal(root.get<HTUData>("name"), it) }
        }
    }

    private fun ageContains(age: String?): Specification<HTUData>? {
        return age?.let {Specification<HTUData> {
            root, query, cb -> cb.equal(root.get<HTUData>("age"), it) }
        }
    }

    private fun messageContains(message: String?): Specification<HTUData>? {
        return message?.let {Specification<HTUData> {
            root, query, cb -> cb.equal(root.get<HTUData>("message"), it) }
        }
    }




}