package app.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import app.dto.BillingDto;
import app.dto.PassengerDto;
import app.entity.Billing;
import app.repository.BillingRepository;
@Service
@Transactional
public class BillingServiceImpl implements BillingService {
	@Autowired
	private BillingRepository repo;
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public BillingDto getOneBill(String id) {
		HttpHeaders headers = new HttpHeaders();
		
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
	      Billing bill = repo.findById(id).get();
	      String passengerId = bill.getPassengerId();
	      PassengerDto passDto = restTemplate.exchange("http://localhost:4001/passengers"
	    		  .concat("/")
	    		  .concat(passengerId),
	    		  	HttpMethod.GET, 
					 entity, 
					 PassengerDto.class
					).getBody();
	      BillingDto billDto = BillingDto.builder()
	    		  .id(bill.getId())
	    		  .name(bill.getName())
	    		  .price(bill.getPrice())
	    		  .passenger(passDto)
	    		  .build();
		return billDto;
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
