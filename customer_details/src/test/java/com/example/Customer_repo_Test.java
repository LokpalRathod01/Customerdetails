package com.example;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.entity.Customer;
import com.example.repository.Customer_Repository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Customer_repo_Test {

	
	@Autowired
	private Customer_Repository customer_repository;
	
	@Test
	@Order(1)
	@Rollback(value=false)
	public void registration() {
		Customer customer=new Customer ();
		

		customer.setName("vijay");
		customer.setAge(30);
	
		
		customer_repository.save(customer);
		Assertions.assertThat(customer.getId()).isGreaterThan(0);

		}
	
	@Test
	@Order(2)
	@Rollback(value=false)
	public void allcustomers() {

		List<Customer> customer=customer_repository.findAll();
		
	    Assertions.assertThat(customer.size()).isGreaterThan(0);
		
	}
	
	@Test
	@Order(3)
	@Rollback(value=false)
	public void getcustomer() {
		
		Customer customer = customer_repository.findById( 1).get(); 
		Assertions.assertThat(customer.getId()).isEqualTo(1);
	}
	
	@Test
	@Order(4)
	@Rollback(value=false)
	public void updatecustomer() {
		Customer customer=customer_repository.findById(1).get();
		customer.setName("Rahul");
		customer.setAge(30);
		Customer updated=customer_repository.save(customer);
		
		Assertions.assertThat(updated.getName()).isEqualTo("Rahul");
		Assertions.assertThat(updated.getAge()).isEqualTo(30);
		
	}
	
	@Test
	@Order(5)
	@Rollback(value=false)
	public void deletecustomer() {
	
		Customer customer=customer_repository.findById(1).get();
		customer_repository.delete(customer);
		
		Customer newcustomer=null;
		
		Optional<Customer> optionalcustomer=customer_repository.findById(1);
		
		if(optionalcustomer.isPresent()) {
			newcustomer=optionalcustomer.get();
		}
		
		Assertions.assertThat(newcustomer).isNull();
	}
	

	
}
