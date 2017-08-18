package com.example.repository.userRepository

/**
 * Created by version1 on 2017/02/11.
 */


import com.example.model.userModel.User
//import samples.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * usersテーブルのRepository.
 */
@Repository
interface UserRepositoryMongo : MongoRepository<User, String> {
}