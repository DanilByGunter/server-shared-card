package com.grocery_card.grocery_card;

import com.grocery_card.grocery_card.model.user.User;
import com.grocery_card.grocery_card.model.user.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ServerApplicationTests {
	@Autowired
	private UserDao userDao;


	void addUserTest() {
		User user = new User();
		user.setName("sdfsdfek");
		user.setPhoto(new byte[] {87, 79, 87, 46, 46, 46, 12, 2, 0, 1});
		userDao.save(user);
	}

	@Test
	void getAllUser(){
		List<User> users = userDao.getAllUsers();
		System.out.println(users);
	}
}
