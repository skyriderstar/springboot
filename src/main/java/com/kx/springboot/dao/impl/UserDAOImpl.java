package com.kx.springboot.dao.impl;

import com.kx.springboot.dao.UserDAO;
import com.kx.springboot.domain.User;
import com.kx.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户管理模块的DAO组件实现类
 * @author kx
 * @date 2019/12/26 11:06
 */
@Repository
public class UserDAOImpl implements UserDAO {

	/**
	 * 用户管理模块的mapper组件
	 */
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> listUsers() {
		return userMapper.listUsers();
	}

	@Override
	public User getUserById(Long id) {
		return userMapper.getUserById(id);
	}

	@Override
	public Long saveUser(User user) {
		userMapper.saveUser(user);
		return user.getId();
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public void removeUser(Long id) {
		userMapper.removeUser(id);
	}
}
