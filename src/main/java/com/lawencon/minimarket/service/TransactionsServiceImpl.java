package com.lawencon.minimarket.service;

import java.math.BigDecimal;
import java.util.List;

import com.lawencon.minimarket.dao.TransactionsDao;
import com.lawencon.minimarket.model.DetailTransactions;
import com.lawencon.minimarket.model.Items;
import com.lawencon.minimarket.model.Transactions;
import com.lawencon.minimarket.model.UserSessionCache;
import com.lawencon.minimarket.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public class TransactionsServiceImpl implements TransactionService {
	private TransactionsDao transactionDao;
	private DetailTransactionService detailTransactionService;
	private BigDecimal tamp = BigDecimal.ZERO;
	private BigDecimal tamp2 = BigDecimal.ZERO;
	private ItemService itemServ;
	private UserSessionCache usrCache;

	public TransactionsServiceImpl(TransactionsDao transactionDao, DetailTransactionService detailTransactionService,
			ItemService itemServ, UserSessionCache usrCache) {
		this.transactionDao = transactionDao;
		this.detailTransactionService = detailTransactionService;
		this.itemServ = itemServ;
		this.usrCache = usrCache;
	}

	@Override
	public List<Transactions> getTransaction() throws Exception {
		return transactionDao.getListTransactions();
	}

	@Override
	public void addData(List<DetailTransactions> trxDetail, Transactions transaction) throws Exception {
		for (DetailTransactions detailTransactions : trxDetail) {
			tamp.add(detailTransactions.getPrice());
			tamp.multiply(new BigDecimal(detailTransactions.getQty()));
			detailTransactions.setPrice(tamp);
		}
		Users activedUsr = usrCache.getActiveUser();
		transaction.setIdUsers(activedUsr);
		System.out.println("create trx");
		Transactions idTransaction = transactionDao.insertData(transaction);
		System.out.println("test");
		detailTransactionService.addData(trxDetail, idTransaction);
		transactionDao.updateData(transaction);
	}

	@Override
	public Items getItem(String code) throws Exception {
		return itemServ.getItemByCode(code);
	}
}
