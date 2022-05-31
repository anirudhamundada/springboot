package com.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public void saveUser(UserVO user) {
		userRepository.save(user);
		restTemplate.postForEntity("http://EMAIL-SERVICE/email", "anirudha.mundada@gmail.com", String.class);
	}
	
	public List<UserVO> getUsers() {
		return userRepository.findAll();
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
}
