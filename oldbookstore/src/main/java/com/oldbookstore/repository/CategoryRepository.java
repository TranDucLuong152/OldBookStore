package com.oldbookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.oldbookstore.entity.Category;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "booksCategory",path = "books-category")
public interface CategoryRepository extends JpaRepository<Category, Long> { }
