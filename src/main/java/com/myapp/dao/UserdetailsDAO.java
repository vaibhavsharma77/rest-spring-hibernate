package com.myapp.dao;

import java.util.List;

import com.myapp.model.UserDetails;

public interface UserdetailsDAO {
	public void save(UserDetails userDetails);

	public List<UserDetails> getAllUsers();

	public UserDetails getUsers(int id);

	public List<UserDetails> updateUser(UserDetails userDetails);

	public void deleteUsers(int id);
}
