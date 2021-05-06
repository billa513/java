package com.example.service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service.bean.User;
//@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	Optional<User> findByAddress(String address);

}
