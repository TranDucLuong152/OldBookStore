package com.oldbookstore.controller;

import com.oldbookstore.entity.Book;
import com.oldbookstore.entity.User;
import com.oldbookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

	@PutMapping("/updateUser")
	public User updateProduct(@RequestBody User user) {
		return userRepository.save(user);
	}
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
    }
}
