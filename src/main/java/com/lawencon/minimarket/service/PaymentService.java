package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.Payments;

/**
 *
 * @author Galih Dika
 *
 */

public interface PaymentService {
	public void addData(String payment) throws Exception;

	public List<Payments> getPayment() throws Exception;

	public void addDataa(Payments py) throws Exception;
}
