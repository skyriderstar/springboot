package com.kx.springboot.mapper;

import com.kx.springboot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author kx
 * @date 2019/12/26 11:00
 */
@Mapper
public interface UserMapper {

	@Select("SELECT * FROM user")
	@Results({
		@Result(property = "id", column = "id", id = true),
		@Result(property = "name", column = "name"),
		@Result(property = "age", column = "age")
	})
	List<User> listUsers();

	@Select("SELECT * FROM user WHERE id = #{id}")
	@Results({
			@Result(property = "id", column = "id", id = true),
			@Result(property = "name", column = "name"),
			@Result(property = "age", column = "age")
	})
	User getUserById(@Param("id") Long id);

	@Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void saveUser(User user);

	@Update("UPDATE user SET name=#{name}, age=#{age} WHERE id=#{id}")
	void updateUser(User user);

	@Delete("DELETE FROM user WHERE id=#{id}")
	void removeUser(@Param("id") Long id);

}
