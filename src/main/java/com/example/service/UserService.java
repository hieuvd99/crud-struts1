package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.model.User;
import com.example.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepository;

	
	public UserService() {
		userRepository = new UserRepository();
	}


	public List<User> getListUser() throws SQLException, Exception{
		return userRepository.getAllUser();
	}
	
	public int addUser(User user) throws Exception{
		try{
			return userRepository.addUser(user);
		}catch(Exception ex){
			return -1;
		}
	}
	
	public User getByUserId(int id) throws SQLException, Exception{
		return userRepository.getUserById(id);
	}
	
	public int editUser(User user) throws SQLException{
		try{
			return userRepository.editUser(user);
		}catch(Exception ex){
			return -1;
		}
	}
	
	public void deleteUser(int id) throws SQLException{
		userRepository.deleteUser(id);
	}
}
