package com.example.controller

/**
 * Created by version1 on 2017/02/11.
 */
import com.example.model.userModel.User2
import com.example.service.userService.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
//import samples.model.User2
//import samples.service.UserService


@Controller
class UserController {

    @Autowired
    private val userService: UserService? = null

    @RequestMapping("/2")
    fun root(): ModelAndView{

        userService?.run{ saveUser(User2(1, "John", 26, 1)) } ?: "nullやて"
        userService?.run{ saveUser(User2(2, "Bob", 40, 1)) } ?: "nullやて"
        userService?.run{ saveUser(User2(3, "Michael", 20, 1)) } ?: "nullやて"
        userService?.run{ saveUser(User2(4, "Mary", 30, 0)) } ?: "nullやて"

        println("---------make---------")
        return ModelAndView("redirect:/users2")
    }

    @RequestMapping("/users2")
    fun users(): ModelAndView = ModelAndView("/user")
            .apply{addObject("users",userService?.run{ findAllUser()} ?: "nullやて")}
}


// class UserController @Autowired constructor(private val userService: UserService