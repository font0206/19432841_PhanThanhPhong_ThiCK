package app.service;

import java.util.List;

import app.entity.Billing;

public interface BillingService {
	Billing getOneBill(String id);
	List<Billing> getAllBill();
	Billing addBill(Billing bill);
}
