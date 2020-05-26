package com.limonnana.backend02.repository;

import com.limonnana.backend02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Transactional
    @Modifying
    @Query(value = "UPDATE the_user u set name =:name , email =:email, phone =:phone where u.user_id = :id",
          nativeQuery = true)
    void updateUser(@Param("name") String name, @Param("email") String email, @Param("phone") String phone,  @Param("id") Long id);

    User findByEmail(String email);
}
