package com.example.Service_impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Service.Customer_Service;
import com.example.entity.Customer;
import com.example.exception.ResourcesNotFoundException;
import com.example.repository.Customer_Repository;

@Service
public class Customer_Service_impl implements Customer_Service {

	@Autowired
	private Customer_Repository customer_repository;
	
	@Override
	public Customer registration(Customer customer) {	
		return customer_repository.save(customer) ;
	}

	@Override
	public List<Customer> allcustomers() {
		return customer_repository.findAll();
	}

	@Override
	public Customer getcustomer(int id) {
		return customer_repository.findById(id).orElseThrow(()->
		new ResourcesNotFoundException("customer","id",id));			
	}

	@Override
	public Customer updatedetails(Customer customer, int id) {
	Customer existingdetails=customer_repository.findById(id).orElseThrow(()->
		new ResourcesNotFoundException("customer","id",id));
	  existingdetails.setName(customer.getName());
	  existingdetails.setAge(customer.getAge());
	  existingdetails.setAddress(customer.getAddress());
	  customer_repository.save(existingdetails);
	return existingdetails;
	}

	@Override
	public void deleteDetails(int id) {
		customer_repository.findById(id).orElseThrow(()->
		new ResourcesNotFoundException("customer","id",id));
		customer_repository.deleteById(id);
		}

	@Override
	public Optional<Customer> findbyname(String name) {
		return customer_repository.searchbyname(name);
		
	}

	@Override
	public List<Customer> findbyage(int age) {
		
		return customer_repository.searchbyage(age);
	}

}
