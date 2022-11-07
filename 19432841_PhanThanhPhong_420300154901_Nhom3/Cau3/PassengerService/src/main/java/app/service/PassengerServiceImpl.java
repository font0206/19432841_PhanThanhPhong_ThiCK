package app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import app.entity.Passenger;
import app.repository.PassengerRepository;
@Service
@Transactional
public class PassengerServiceImpl implements PassengerService{
	private static final String REDIS_CACHE_VALUE = "passenger";
	@Autowired
	private PassengerRepository repo;
	 @Autowired
	    private RedisTemplate template;
	@Override
	public Passenger getOnePass(String id) {
		Passenger pass = null;
		pass = (Passenger) template.opsForHash().get(REDIS_CACHE_VALUE, id);
		if(pass != null)
			return pass;
		System.out.println("get passenger from db...");
		pass = repo.findById(id).get();
		if(pass.getId()!= null)
			template.opsForHash().put(REDIS_CACHE_VALUE, pass.getId(), pass);
		return pass;
	}

	@Override
	public List<Passenger> getAll() {
		List<Passenger> ls =(List<Passenger>) template.opsForHash().values(REDIS_CACHE_VALUE);
		if(ls.size() > 0)
			return ls;
		ls = repo.findAll();
		if(ls.size() > 0) {
			Map<String, Passenger> map = new HashMap<>();
			for(Passenger p : ls) {
				map.put(p.getId(), p);
			}
			if(map.size() > 0)
				template.opsForHash().putAll(REDIS_CACHE_VALUE, map);
		}
			
		
		
		System.out.println("get list passenger from db");
		return repo.findAll();
	}

	@Override
	public Passenger addPass(Passenger pass) {
		template.opsForHash().put(REDIS_CACHE_VALUE, pass.getId(), pass);
		return repo.save(pass);
	}

}
