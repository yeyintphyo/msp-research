package com.example.msp.domain.user.mapper;

import static com.example.msp.TestMapperUtil.newUsers;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.msp.TestAbstract;
import com.example.msp.database.entity.Users;
import com.example.msp.database.mapper.UsersMapper;

public class UserInsertMapperTest extends TestAbstract {

	@Autowired
	private UsersMapper userMapper;

	@Test
	public void shouldInsert() {
		Users user = newUsers();
		int count = this.userMapper.insertSelective(user);
		assertThat(count, is(1));
		assertThat(user.getId(), notNullValue());
	}

	@Test(expected = Exception.class)
	public void databaseError() {
		Users user = new Users();
		user.setId(1);
		this.userMapper.insertSelective(user);
	}
}
