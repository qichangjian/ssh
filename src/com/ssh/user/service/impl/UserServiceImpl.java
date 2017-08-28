package com.ssh.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.user.dao.UserDao;
import com.ssh.user.model.User;
import com.ssh.user.service.UserService;


//用户信息操作业务逻辑接口实现
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	public boolean isExitUser(String userName) {
		return userDao.isExitByName(userName);
	}

	public void save(User user) {
		userDao.addUser(user);
	}

	public List<User> getUsers() {
		List<User> users = userDao.selectUser();
		return users;
	}

	public void del(int userId) {
		userDao.delUser(userId);

	}

	public void update(User user) {
		userDao.updateUser(user);

	}

	public User getUserById(int userId) {
		return userDao.getUserByUserId(userId);
	}

	public boolean isExitByNameAndPass(User user) {
		return userDao.isExitByNameAndPass(user);
	}

}
