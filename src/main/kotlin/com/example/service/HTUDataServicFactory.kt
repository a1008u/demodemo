package com.example.service

import com.example.form.HTUDataForm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
//import samples.form.HTUDataForm

@Service
class HTUDataServiceFactory {

    @Autowired
    private val HTUDataServiceRepository : HTUDataServiceRepository? = null

    internal var HTUDataService: HTUDataService? = null

    fun isolate(HTUDataForm: HTUDataForm) : HTUDataService? {

        HTUDataService= when{
            "JPQL" == HTUDataForm.jpa ->HTUDataServiceRepository
            else -> HTUDataServiceRepository
        }

        return HTUDataService
    }
}