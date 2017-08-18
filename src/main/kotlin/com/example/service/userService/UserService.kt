package com.example.service.userService

/**
 * Created by version1 on 2017/02/11.
 */

import com.example.model.userModel.User2
import com.example.repository.userRepository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
//import samples.model.User2
//import samples.repository.UserRepository

/**
 * DBからのデータ取得と加工を行う.
 */
@Service
open class UserService {

    @Autowired
    private val userRepository: UserRepository? = null

    /**
     * 全ユーザリストの取得(cRud)
     * @return ユーザリスト
     */
    fun findAllUser(): MutableList<User2> = userRepository?.run{ findAll() } as MutableList<User2>

    /**
     * 全ユーザリストの保存(Crud)
     * @return ユーザ
     */
    fun saveUser(user2: User2): User2? = userRepository?.run{ save(user2) }
}

// open class UserService @Autowired constructor(private val userRepository: UserRepository) {