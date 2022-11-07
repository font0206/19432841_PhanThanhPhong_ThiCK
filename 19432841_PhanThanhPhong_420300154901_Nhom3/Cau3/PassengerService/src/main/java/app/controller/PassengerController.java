package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Passenger;
import app.service.PassengerService;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
	@Autowired
	private PassengerService service;
	
	@GetMapping()
	public List<Passenger> getAll(){
		return service.getAll();
	}
	@GetMapping("/{id}")
	public Passenger getOnePass(@PathVariable String id) {
		return service.getOnePass(id);
	}
	@PostMapping()
	public Passenger addPass(@RequestBody Passenger pass) {
		return service.addPass(pass);
	}
}
