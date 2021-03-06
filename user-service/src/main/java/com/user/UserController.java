package com.user;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("user")
	@ResponseStatus(code = HttpStatus.CREATED)
	void createUser(@Valid @RequestBody UserVO user) {
		service.saveUser(user);
		
	}
	
	@DeleteMapping("user/{id}")
	void deleteUser(@PathVariable int id) {
		service.deleteUser(id);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException(MethodArgumentNotValidException exp) {
		Map<String, String> exceptionMsg = new HashMap<>();
		exp.getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = ((FieldError) error).getDefaultMessage();
			exceptionMsg.put(fieldName, message);
		});
		return exceptionMsg;
	}
}
