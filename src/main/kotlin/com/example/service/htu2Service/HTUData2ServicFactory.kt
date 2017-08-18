package com.example.service

import com.example.form.HTUData2Form
import com.example.service.htu2Service.HTUData2ServiceCriteriaAPI
import com.example.service.htu2Service.HTUData2ServiceJPQL
import com.example.service.htu2Service.HTUData2ServiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HTUData2ServiceFactory {

    @Autowired
    private val HTUData2ServiceRepository : HTUData2ServiceRepository? = null

    @Autowired
    private val HTUData2ServiceCriteriaAPI: HTUData2ServiceCriteriaAPI? = null

    @Autowired
    private val HTUData2ServiceJPQL: HTUData2ServiceJPQL? = null

    internal var HTUData2Service: HTUData2Service? = null

    fun isolate(HTUData2Form: HTUData2Form) : HTUData2Service? {

        HTUData2Service= when{
            "JPQL" == HTUData2Form.jpa -> HTUData2ServiceJPQL
            "Criteria API" == HTUData2Form.jpa -> HTUData2ServiceCriteriaAPI
            else -> HTUData2ServiceRepository
        }

        return HTUData2Service
    }
}