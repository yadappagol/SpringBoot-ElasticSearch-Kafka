package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Iterable<Customer> addCustomers(List<Customer> customers) {
		return customerRepository.saveAll(customers);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomerByName(String customerName) {
		return customerRepository.findByFirstname(customerName);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public boolean deleteCustomerById(String customerId) {
		customerRepository.deleteById(customerId);
		return true;
	}

	@Override
	public Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public boolean deleteAll() {
		customerRepository.deleteAll();
		return true;
	}

}
