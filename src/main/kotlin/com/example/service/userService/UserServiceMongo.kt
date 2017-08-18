package com.example.service.userService

/**
 * Created by version1 on 2017/02/11.
 */

import com.example.model.userModel.User
import com.example.repository.userRepository.UserRepositoryMongo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
//import samples.model.User
//import samples.repository.UserRepositoryMongo

/**
 * DBからのデータ取得と加工を行う.
 */
@Service
open class UserServiceMongo {

    @Autowired
    private val userRepository: UserRepositoryMongo? = null

    /**
     * 全ユーザリストの取得(cRud)
     * @return ユーザリスト
     */
    fun findAllUser(): MutableList<User> = userRepository?.run{ findAll() } as MutableList<User>

    /**
     * 全ユーザリストの保存(Crud)
     * @return ユーザ
     */
    fun saveUser(user: User): User? = userRepository?.run{ save(user) }

    /**
     * 全ユーザリストの削除(cruD)
     * @return ユーザ
     */
    fun deleteAlluser() = userRepository?.run{ deleteAll()}
}

// open class UserService @Autowired constructor(private val userRepository: UserRepository) {
