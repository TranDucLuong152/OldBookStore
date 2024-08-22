package com.oldbookstore.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.oldbookstore.entity.Book;
import com.oldbookstore.repository.BookRepository;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("http://localhost:4200")
public class ProductController {

	@Autowired
	BookRepository bookRepository;
	private static final String UPLOAD_DIR = "E:/myProject/front-end/Old-BookStore/src/assets/img/books/";

	@PostMapping("/addProduct")
	public Book addProduct(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@PutMapping("/updateProduct")
	public Book updateProduct(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		bookRepository.deleteById(id);
	}

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		try {

			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			File dest = new File(UPLOAD_DIR + fileName);
			file.transferTo(dest);

			return ResponseEntity.ok(fileName);
		} catch (IOException e) {
			return ResponseEntity.status(500).body("Tải file lỗi: " + e.getMessage());
		}
	}
}
