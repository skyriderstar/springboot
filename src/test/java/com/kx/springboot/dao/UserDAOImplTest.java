package com.kx.springboot.dao;

/**
 * @author kx
 * @date 2019/12/30 15:08
 */

import com.kx.springboot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * DAO 组件的单元测试类
 * 单元测试尽量不要依赖外部, 但是到 DAO层的时候, 跟 Redis MySQL 打交道
 * 还是要依靠开发环境的基础设施, 来进行单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class UserDAOImplTest {

	/**
	 * 用户管理模块的 DAO 组件
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * 测试用例 : 查询所有用户信息
	 */
	@Test
	public void testListUsers() {
		// 准备好 mock userMapper 的返回数据
		User user = new User();
		user.setName("test");
		user.setAge(20);
		userDAO.saveUser(user);

		List<User> userList = new ArrayList<User>();
		userList.add(user);

		// 测试 UserService 的 listUsers() 方法
		List<User> resultUsers = userDAO.listUsers();

		System.out.println("userList: " + userList);
		System.out.println("resultUsers: " + resultUsers);

		// 对测试结果进行断言
		assertEquals(userList.size(), resultUsers.size());
	}


	/**
	 * 测试用例 : 根据 ID 查询一个用户
	 */
	@Test
	public void testGetUserById() {
		User user = new User();
		user.setName("test");
		user.setAge(28);
		userDAO.saveUser(user);


		Long userId = user.getId();


		User resultUser = userDAO.getUserById(userId);

		assertEquals(user.toString(), resultUser.toString());

	}

	/**
	 * 测试用例 : 新增用户
	 */
	@Test
	public void testSaveUser() {
		User user = new User();
		user.setName("test");
		user.setAge(28);

		Long resultUserId = userDAO.saveUser(user);

		System.out.println(resultUserId);

		assertThat(resultUserId, is(greaterThan(16L)));

	}

	/**
	 * 测试用例 : 修改用户
	 */
	@Test
	public void testUpdateUser() {

	    Integer newAge = 28;

		User user = new User();
		user.setName("test");
		user.setAge(20);

		Long userId = userDAO.saveUser(user);
		user.setAge(newAge);

		userDAO.updateUser(user);
		User updateUser = userDAO.getUserById(userId);

		assertEquals(newAge, updateUser.getAge());
	}


	/**
	 * 测试用例 : 删除用户
	 */
	@Test
	public void testRemoveUser() {

		User user = new User();
		user.setName("test");
		user.setAge(28);

		Long userId = userDAO.saveUser(user);
		User sqlUser = userDAO.getUserById(userId);
		assertNotNull(sqlUser);

		userDAO.removeUser(userId);
		User deleteUser = userDAO.getUserById(userId);
		assertNull(deleteUser);

	}

}
