package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * URL :http://localhost:8086/api/v1/customer/saveCustomers
	 */
	@PostMapping("/saveCustomers")
	public ResponseEntity<?> saveCustomer(@RequestBody List<Customer> customers) {
		if (customers != null) {
			customerService.addCustomers(customers);
			return new ResponseEntity<>("Customer Data Inserted Successfully.", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Cusstomer Data is Empty", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * URL :http://localhost:8086/api/v1/customer/addCustomer
	 */
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(Customer customer) {
		if (customer != null) {
			customerService.addCustomer(customer);
			return new ResponseEntity<>("Customer Data Inserted Successfully.", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Cusstomer Data is Empty", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * URL:http://localhost:8086/api/v1/customer/findAll
	 */
	@GetMapping("/findAll")
	public ResponseEntity<?> findAllCustomers() {
		Iterable<Customer> allCustomers = customerService.getAllCustomers();
		if (allCustomers != null) {
			return new ResponseEntity<>(allCustomers, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("Cusstomer Data is Empty", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * URL:http://localhost:8086/api/v1/customer/findByFirstName/firstName
	 */
	@GetMapping("/findByFirstName/{firstName}")
	public ResponseEntity<?> findByFirstName(@PathVariable String firstName) {
		List<Customer> customerByName = customerService.getCustomerByName(firstName);
		if (customerByName != null) {
			return new ResponseEntity<>(customerByName, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("Cusstomer Data is Empty", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * URL:http://localhost:8086/api/v1/customer/updateCustomer
	 */
	@PutMapping("/updateCustomer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
		if (customer != null) {
			customerService.updateCustomer(customer);
			return new ResponseEntity<>("Customer Data Updated Successfully.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cusstomer Data is Empty", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * URL:http://localhost:8086/api/v1/customer/deleteCustomerById/customerId
	 */
	@DeleteMapping("/deleteCustomerById/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable String customerId) {
		if (customerService.deleteCustomerById(customerId)) {
			return new ResponseEntity<>("Customer Data Deleted Successfully.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cusstomer Data is Empty", HttpStatus.NOT_FOUND);
		}
	}
	/**
	 * URL:http://localhost:8086/api/v1/customer/deleteAll
	 */
	@DeleteMapping("/deleteAll")
	public ResponseEntity<?> deleteCustomerById() {
		if (customerService.deleteAll()) {
			return new ResponseEntity<>("Customer Data Deleted Successfully.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cusstomer Data is Empty", HttpStatus.NOT_FOUND);
		}
	}

}
