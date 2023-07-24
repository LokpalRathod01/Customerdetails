package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Customer;

@Repository
public interface Customer_Repository extends JpaRepository<Customer,Integer>{
	@Query(value="select * from Customer where name=?",nativeQuery=true)
	public Optional<Customer> searchbyname(String name);
	
	@Query(value="select * from Customer where age>?",nativeQuery=true)
	public List<Customer> searchbyage(int age);
	

}
