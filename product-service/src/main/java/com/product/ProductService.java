package com.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public void saveProduct(ProductVO order) {
		productRepository.save(order);
		//restTemplate.getForEntity("http://EMAIL-SERVICE/email", String.class);
	}
	
	public List<ProductVO> getProducts() {
		return productRepository.findAll();
	}
	
	public ProductVO getProduct(int id) {
		return  productRepository.findById(id).get();
	}
	
	public List<ProductVO> findByProductId(String productId){
		return productRepository.findByProductIdContaining(productId);
	}
	
	public List<ProductVO> findByProductName(String productName){
		return productRepository.findByProductNameContaining(productName);
	}
}
