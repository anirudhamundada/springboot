package com.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductVO, Integer> {

	List<ProductVO> findByProductIdContaining(String productId);
	
	List<ProductVO> findByProductNameContaining(String productId);
	
}
