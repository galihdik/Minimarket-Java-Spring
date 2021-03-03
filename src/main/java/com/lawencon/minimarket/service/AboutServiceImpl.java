
package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.dao.AboutDao;
import com.lawencon.minimarket.model.About;

/**
 *
 * @author Galih Dika
 *
 */

public class AboutServiceImpl implements AboutService {
	private AboutDao aboutDao;

	public AboutServiceImpl(AboutDao aboutDao) {
		this.aboutDao = aboutDao;
	}

	@Override
	public List<About> getAbout() throws Exception {
		return aboutDao.getListAbout();
	}

	@Override
	public void addData(About about) throws Exception {
		aboutDao.insertData(about);
	}

}
