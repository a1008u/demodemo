package com.example.repository.htu2Repository

import com.example.bean.HTUData2Bean
import com.example.model.dynamicModel.HTUData2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.domain.Specifications
import org.springframework.stereotype.Repository

@Repository
class SpecificationsDetailHTUData2{

    @Autowired
    private val htu2Repository: HTUData2Repository? = null

    /**
     * 検索(動的に検索条件を設定)
     * @param HTUData2Bean
     * @return MutableList<HTUData2>
     */
    fun findMany(HTUData2Bean: HTUData2Bean): MutableList<HTUData2> {
        return htu2Repository?.run{ findAll(Specifications
                .where(idContains(HTUData2Bean.id))
                .and(nameContains(HTUData2Bean.name))
                .and(ageContains(HTUData2Bean.age))
                .and(messageContains(HTUData2Bean.message))
        )} as MutableList<HTUData2>
    }

    // TODO デフォルト値の処理を追加 →　null を返す
    private fun idContains(id: Int): Specification<HTUData2>? {
        return if(id == 0) {
            null
        }else{
            Specification<HTUData2>() {
                root, query, cb -> cb.equal(root.get<HTUData2>("id"), id)
            }
        }
    }

    // TODO デフォルト値の処理を追加 →　null を返す
    private fun nameContains(name: String): Specification<HTUData2>? {
        return if(name == "") {
            null
        }else{
            Specification<HTUData2> {
                root, query, cb -> cb.equal(root.get<HTUData2>("name"), name)
            }
        }
    }

    // TODO デフォルト値の処理を追加 →　null を返す
    private fun ageContains(age: String): Specification<HTUData2>? {
        return if(age == "") {
            null
        }else{
            Specification<HTUData2> {
                root, query, cb -> cb.equal(root.get<HTUData2>("age"), age)
            }
        }
    }

    // TODO デフォルト値の処理を追加 →　null を返す
    private fun messageContains(message: String): Specification<HTUData2>? = if(message == "") {
        null
    }else{
        Specification<HTUData2> {
            root, query, cb -> cb.equal(root.get<HTUData2>("message"), message)
        }
    }

}