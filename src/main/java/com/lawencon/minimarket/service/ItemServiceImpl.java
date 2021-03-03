package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.dao.ItemDao;
import com.lawencon.minimarket.model.Items;

/**
 *
 * @author Galih Dika
 *
 */

public class ItemServiceImpl implements ItemService {
	private ItemDao daoItem;

	public ItemServiceImpl(ItemDao daoItem) {
		this.daoItem = daoItem;
	}

	@Override
	public Items getItemByCode(String code) throws Exception {
		System.out.println(code);
		return daoItem.getItemByCode(code);
	}

	@Override
	public List<Items> getItem() throws Exception {
		return daoItem.getListItem();
	}

	@Override
	public void insertData(Items item) throws Exception {
		daoItem.insertData(item);
	}

}