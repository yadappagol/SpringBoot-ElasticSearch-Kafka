package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerService {

	Iterable<Customer> addCustomers(List<Customer> customers);
	
	boolean deleteAll();

	Iterable<Customer> getAllCustomers();

	Customer addCustomer(Customer customer);

	List<Customer> getCustomerByName(String customerName);

	Customer updateCustomer(Customer customer);

	boolean deleteCustomerById(String customerID);
}
