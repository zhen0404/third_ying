package com.service;

import java.util.Set;

import com.bean.User;

public interface UserService {
	public User getUserByUserName(String userName);
	public Set<String> getRolesByUserName(String userName);
	public Set<String> getPersByUserName(String userName);
}
