package samples.repository

/**
 * Created by AU on 2017/02/11.
 */


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import samples.model.User2

/**
 * usersテーブルのRepository.
 */
@Repository
interface UserRepository : JpaRepository<User2, Long> { }