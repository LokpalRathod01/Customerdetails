package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.Customer_Service;
import com.example.entity.Customer;

@RestController
@RequestMapping("/customer_portal")
public class Customer_Controller {
	
	@Autowired
	private Customer_Service customer_service;
	
	@PostMapping("/enter_details")
	public ResponseEntity<Customer> registration(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customer_service.registration(customer),HttpStatus.CREATED);
		}
	
	@GetMapping("/show_all")
	public List<Customer> allcustomers() {
		return customer_service.allcustomers();
		
	}
	
	@GetMapping("/enter_id/{id}")
	public ResponseEntity<Customer>  getcustomer(@PathVariable("id") int id) {
		return new ResponseEntity<Customer>(customer_service.getcustomer(id),HttpStatus.OK);
	}
	
	@GetMapping("/enter_name/{name}")
		public ResponseEntity <Optional<Customer> > findbyname(@PathVariable("name") String name) {
			return new ResponseEntity<Optional<Customer>> (customer_service.findbyname(name),HttpStatus.OK);
		
	}
	
	@GetMapping("/enter_age/{age}")
	public ResponseEntity <List<Customer> > findbyage(@PathVariable("age") int age) {
		return new ResponseEntity<List<Customer>> (customer_service.findbyage(age),HttpStatus.OK);
	
}
	
	
	@PutMapping("/enter_id/{id}")
	public ResponseEntity<Customer>  updatedetails(@RequestBody Customer customer,@PathVariable int id) {
		return new ResponseEntity<Customer>(customer_service.updatedetails(customer, id),HttpStatus.CREATED);
	}				
	
	@DeleteMapping("/enter_id/{id}")
	public ResponseEntity<String> deleteDetails(@PathVariable("id") int id) {
		customer_service.deleteDetails(id);
		return new  ResponseEntity<String>("customer details deleted succesfully",HttpStatus.ACCEPTED);
		
	}

}
