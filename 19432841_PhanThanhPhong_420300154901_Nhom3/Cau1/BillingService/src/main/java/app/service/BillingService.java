package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.dto.BillingDto;
import app.entity.Billing;
@Service
public interface BillingService {
	BillingDto getOneBill(String id);
	List<Billing> getAllBill();
	Billing addBill(Billing bill);
}
