package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Billing;
@Service
public interface BillingService {
	Billing getOneBill(String id);
	List<Billing> getAllBill();
	Billing addBill(Billing bill);
}
