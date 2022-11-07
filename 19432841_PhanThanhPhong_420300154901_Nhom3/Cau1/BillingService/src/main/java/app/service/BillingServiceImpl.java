package app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Billing;
import app.repository.BillingRepository;
@Service
@Transactional
public class BillingServiceImpl implements BillingService {
	@Autowired
	private BillingRepository repo;
	@Override
	public Billing getOneBill(String id) {
		
		return repo.findById(id).get();
	}

	@Override
	public List<Billing> getAllBill() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Billing addBill(Billing bill) {
		// TODO Auto-generated method stub
		return repo.save(bill);
	}

}
