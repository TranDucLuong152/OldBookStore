package com.oldbookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.oldbookstore.entity.User;
@CrossOrigin("http://localhost:4200")
public interface UserRepository extends JpaRepository<User, String> {
}
