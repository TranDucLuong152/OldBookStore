package com.oldbookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.oldbookstore.entity.Book;

@CrossOrigin("http://localhost:4200")
public interface BookRepository extends JpaRepository<Book, Long> {
	 Page<Book> findByCategoryCategoryId(@Param("categoryId") Long categoryId, Pageable pageable);

	 Page<Book> findByTitleContaining(String title, Pageable pageable);

}
