package com.kx.springboot.service;


import com.kx.springboot.dao.UserDAO;
import com.kx.springboot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * 用户管理模块的 service 组件的单元测试类
 * @author kx
 * @date 2019/12/30 10:15
 */

/**
 * @RunWith 在执行单元测试的时候, 不是直接去执行里面的单元测试方法
 * 因为那些方法执行之前, 是需要做一些准备工作的, 它是需要先初始化一个spring容器的
 * 所以得找到这个 SpringRunner 这个类,来先准备好 spring 容器, 再执行各个测试方法
 */
@RunWith(SpringRunner.class)
/**
 * @SpringBootTest 从最顶层的包结构开始找, com.kx.springboot
 * 找到一个标注了 @SpringBootApplication 注解的一个类, 算是启动类
 * 然后会执行这个启动类的 main 方法, 就可以创建 spring 容器, 给后面的单元测试提供完整的环境
 */
@SpringBootTest
/**
 * @Transactional 让每个方法都是放在一个事务里面
 * 比如我们执行一些数据库相关的操作, 比如测试 mapper , 需要实际操作数据库的
 * 那么在测试查询操作的时候, 我们需要通过程序预先灌入一些数据, 再测试能否查询到这些数据
 * 接着测试完之后, 其实更应该让这个事务回滚, 就可以自动取消我们插入的那些数据了
 * 让单元测试方法执行的这些增删改的操作, 都是一次性的
 */
@Transactional
@Rollback(true)
public class UserServiceImplTest {

	/**
	 * 用户管理模块的 service 组件
	 */
	@Autowired
	private UserService userService;

	/**
	 * @MockBean
	 * UserDao 就不会用我们自己定义的那个 userDAO 了
	 * 这里会由 springboot 整合 mockito 框架, 然后创建一个实现了 UserDAO 接口的匿名实现类
	 * 然后将这个模拟出来实现了 UserDAO 接口的类的实例 bean, 放入 spring 容器中
	 * 替代我们自己的那个 UserDAO
	 */
	@MockBean
	private UserDAO userDAO;

	/**
	 * 测试用例: 查询所有用户信息
	 @Override public List<User> listUser() {
	 return userDAO.listUser();
	 }
	 */
	@Test
	public void testListUsers() {
		// 准备好 mock userDAO 的返回数据
		List<User> users = new ArrayList<User>();

		User user = new User();
		user.setId(1L);
		user.setName("test");
		user.setAge(18);

		users.add(user);

		// 对 userDAO 进行 mock 逻辑设置
		when(userDAO.listUsers()).thenReturn(users);

		// 测试 UserService 的 listUsers 方法
		List<User> resultUsers = userService.listUsers();

		System.out.println("users:" + users);
		System.out.println("resultUsers:" + resultUsers);

		// 对测试结果进行断言
		assertEquals(users, resultUsers);

	}

	/**
	 * 测试用例: 根据 ID 查询一个用户
	 */
	@Test
	public void testGetUserById() {
		Long userId = 1L;

		User user = new User();
		user.setId(userId);
		user.setName("test");
		user.setAge(20);

		when(userDAO.getUserById(userId)).thenReturn(user);
		User resultUser = userService.getUserById(userId);

		assertEquals(user, resultUser);
	}
}
