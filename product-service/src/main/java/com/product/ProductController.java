package com.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping("product")
	public void saveProduct(@Valid @RequestBody ProductVO product) {
		service.saveProduct(product);
	}
	
	@GetMapping("product/{id}")
	public ProductVO getProductById(@PathVariable int id) {
		return service.getProduct(id);
	}
	
	@GetMapping("product/id/{id}")
	public List<ProductVO> findProductById(@PathVariable String id) {
		return service.findByProductId(id);
	}
	
	@GetMapping("product/name/{name}")
	public List<ProductVO> findProductByName(@PathVariable String name) {
		return service.findByProductName(name);
	}
}
