package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tom on 2018/1/26.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
