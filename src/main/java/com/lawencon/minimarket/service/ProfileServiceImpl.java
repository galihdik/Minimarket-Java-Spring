
package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.dao.ProfilesDao;
import com.lawencon.minimarket.model.Profiles;

/**
 *
 * @author Galih Dika
 *
 */

public class ProfileServiceImpl implements ProfileService {
	private ProfilesDao profileDao;

	public ProfileServiceImpl(ProfilesDao profileDao) {
		this.profileDao = profileDao;
	}

	@Override
	public List<Profiles> getProfile() throws Exception {
		return profileDao.getListProfile();
	}

	@Override
	public void addData(Profiles prf) throws Exception {
		profileDao.insertData(prf);

	}

}
