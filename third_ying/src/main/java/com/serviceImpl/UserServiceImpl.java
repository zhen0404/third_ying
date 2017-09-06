package com.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.dao.UserDao;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUserByUserName(String userName) {
		User user=userDao.getUserByUserName(userName);
		return user;
	}

	public Set<String> getRolesByUserName(String userName) {
		Set<String> list=userDao.getRolesByUserName(userName);
		return list;
	}

	public Set<String> getPersByUserName(String userName) {
		Set<String> list=userDao.getPersByUserName(userName);
		return list;
	}

}
