package com.example.Service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Customer;

public interface Customer_Service {
	
	Customer registration(Customer customer);
	List<Customer> allcustomers();
	Customer getcustomer(int id);
	Customer updatedetails(Customer customer,int id);
	void deleteDetails(int id);
    Optional<Customer> findbyname(String name);
    List<Customer> findbyage(int age);
	
}
