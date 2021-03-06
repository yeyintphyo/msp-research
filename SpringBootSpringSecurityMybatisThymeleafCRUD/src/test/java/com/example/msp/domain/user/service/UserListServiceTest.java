package com.example.msp.domain.user.service;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.msp.TestAbstract;
import com.example.msp.domain.user.dto.UsersListDto;

public class UserListServiceTest extends TestAbstract {

	@Autowired
	private UserListService userListService;

	@Test
	public void shouldReturnUsersList() throws Exception {		
		List<UsersListDto> usersListDto = userListService.getUsersList();
		assertThat(usersListDto, notNullValue());		
		assertThat(usersListDto.size(), anyOf(greaterThan(-1), is(not(0))));
	}
}
