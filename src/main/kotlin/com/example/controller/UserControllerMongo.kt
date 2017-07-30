package samples.controller

/**
 * Created by version1 on 2017/02/11.
 */

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import samples.model.User
import samples.service.UserServiceMongo


@Controller
class UserControllerMongo {

    @Autowired
    private val userService: UserServiceMongo? = null

    @RequestMapping("/")
    fun root(): ModelAndView{

        userService?.run{
            deleteAlluser()
            println("--------------delte実施--------------")
        } ?: "nullやて"

        userService?.run{ saveUser( User( "1" , "John" , "26" , "1")) } ?: "nullやて"
        userService?.run{ saveUser( User("2" , "Bob" , "40" , "1")) } ?: "nullやて"
        userService?.run{ saveUser( User( "3" , "Michael" , "20" , "1")) } ?: "nullやて"
        userService?.run{ saveUser( User(  "4" , "Mary" , "30" , "0")) } ?: "nullやて"

        return ModelAndView("redirect:/users")
    }

    @RequestMapping("/users")
    fun users(): ModelAndView = ModelAndView("/user")
            .apply{addObject("users",userService?.run{ findAllUser()} ?: "nullやて")}
}


// class UserController @Autowired constructor(private val userService: UserService) {