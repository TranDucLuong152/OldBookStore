package com.oldbookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.oldbookstore.entity.OrderItem;
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "rental",path = "Retal")
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}