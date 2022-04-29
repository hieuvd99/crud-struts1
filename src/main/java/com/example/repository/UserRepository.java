package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.User;
import com.example.utils.JDBCConnection;

public class UserRepository {

	private Connection connection;

	public UserRepository() {
		this.connection = JDBCConnection.getJDBCConnection();
	}

	//Get all user
	public List<User> getAllUser() throws SQLException, Exception {

		List<User> listUser = new ArrayList<User>();
		try {
			String sql = "SELECT * FROM public.user";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
				listUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}

	//Add user
	public int addUser(User user) throws Exception {
		int rowsInserted = 0;
		try {
			String sql = "INSERT INTO public.user ( username, phone, email) VALUES (?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getEmail());
			rowsInserted = ps.executeUpdate();
			return rowsInserted;
		} catch (Exception e) {
			e.printStackTrace();
			return rowsInserted;
		} 
	}
	
	//Get User by Id
	public User getUserById(int id) throws SQLException, Exception{
		User user = null;
		try {
			String sql = "SELECT id, username, phone, email FROM public.user where id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	//Edit user
	public int editUser(User user) throws Exception{
		int result = 0;
		try {
			String sql = "Update public.user SET username=?, phone=?, email=? where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2,  user.getPhone());
			ps.setString(3, user.getEmail());
			ps.setInt(4,  user.getId());
			result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
	}
	
	//Detele user
	public void deleteUser(int id) throws SQLException{
		try {
			String sql = "Delete From public.user where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
