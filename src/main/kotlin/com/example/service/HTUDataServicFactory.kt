package com.example.service

import org.springframework.beans.factory.annotation.Autowired
import samples.service.*
import com.example.form.HTUDataForm

public class HTUDataServiceFactory {

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