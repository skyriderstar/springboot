package com.kx.springboot.service.impl;

import com.kx.springboot.dao.UserDAO;
import com.kx.springboot.domain.User;
import com.kx.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author kx
 * @date 2019/12/26 11:23
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> listUsers() {
		// doSomething
		return userDAO.listUsers();
	}

	@Override
	public User getUserById(Long id) {
		return userDAO.getUserById(id);
	}

	@Override
	public Long saveUser(User user) {
		return userDAO.saveUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	public void removeUser(Long id) {
		userDAO.removeUser(id);
	}
}
