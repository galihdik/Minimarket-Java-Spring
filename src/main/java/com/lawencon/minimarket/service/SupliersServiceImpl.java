package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.dao.SupliersDao;
import com.lawencon.minimarket.model.Supliers;

/**
 *
 * @author Galih Dika
 *
 */

public class SupliersServiceImpl implements SupliersService {
	private SupliersDao supliersDao;

	public SupliersServiceImpl(SupliersDao supliersDao) {
		this.supliersDao = supliersDao;
	}

	@Override
	public List<Supliers> getSupliers() throws Exception {
		return supliersDao.getListSuplier();
	}

	@Override
	public void addData(Supliers sp) throws Exception {
		supliersDao.insertData(sp);
	}

}
