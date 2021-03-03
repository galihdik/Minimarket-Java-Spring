package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.dao.UsersDao;
import com.lawencon.minimarket.model.UserSessionCache;
import com.lawencon.minimarket.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public class UsersServicesImpl implements UsersServices {
	private UsersDao usrDao;
	private UserSessionCache usrCache;

	public UsersServicesImpl(UsersDao usrDao, UserSessionCache usrCache) {
		this.usrDao = usrDao;
		this.usrCache = usrCache;
	}

	@Override
	public Users loginUsernamePassword(String username, String pswd) throws Exception {
		Users usr = usrDao.getUsersByUsernameAndPassword(username, pswd);
		usrCache.setActiveUser(usr);
		return usrDao.getUsersByUsernameAndPassword(username, pswd);
	}

	@Override
	public List<Users> getUser() throws Exception {
		return usrDao.getListUsers();
	}

	@Override
	public void addData(Users usr) throws Exception {
		usrDao.insertData(usr);
	}
}