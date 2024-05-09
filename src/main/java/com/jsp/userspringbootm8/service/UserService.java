package com.jsp.userspringbootm8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.userspringbootm8.dao.UserDao;
import com.jsp.userspringbootm8.dto.User;
import com.jsp.userspringbootm8.util.ResponseStructure;
@Service
public class UserService {

	@Autowired
	private UserDao  dao;
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser=dao.saveUser(user);
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User Data Saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<User>> findUser(int id) {
		User dbUser=dao.findUser(id);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}else {
//			id is not oresent
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Sorry id is not present");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		User dbUser=dao.deleteUser(id);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Data deleted successfully");
			structure.setHttpStatus(HttpStatus.FORBIDDEN.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FORBIDDEN);
		}else {
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Sorry id is not present");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
		}
	}

}
