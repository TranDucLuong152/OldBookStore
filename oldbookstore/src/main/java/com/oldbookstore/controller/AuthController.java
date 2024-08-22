package com.oldbookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oldbookstore.entity.User;
import com.oldbookstore.service.SessionService;
@RestController
@RequestMapping("/api")
public class AuthController {

	@Autowired
	SessionService sessionService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User loginRequest) {	
		User user = authenticate(loginRequest);
		
		if (user != null) {
			sessionService.set("user", user);
			 User user1 = sessionService.get("user");
			System.out.println(user1.getUsername());
			return ResponseEntity.ok().body("Login Thành công");
		} else {
			return ResponseEntity.status(401).body("Thất bại");
		}
	}

	private User authenticate(User loginRequest) {
		return loginRequest;
	}
}
