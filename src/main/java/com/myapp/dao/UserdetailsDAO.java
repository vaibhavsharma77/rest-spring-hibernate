package com.myapp.dao;

import java.util.List;

import com.myapp.model.UserDetails;

public interface UserdetailsDAO {
public void save(UserDetails userDetails);
public List<UserDetails> getUsers();
}
