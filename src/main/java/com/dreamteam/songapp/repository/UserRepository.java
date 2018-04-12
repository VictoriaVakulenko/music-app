package com.dreamteam.songapp.repository;

import com.dreamteam.songapp.enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query("select u.password from User u where u.email =:email")
    String getUserPassword(@Param("email") String email);


}
