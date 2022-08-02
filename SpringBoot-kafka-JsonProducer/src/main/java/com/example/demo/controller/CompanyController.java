package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.kafka.JsonKafkaProducer;
import com.example.demo.model.Company;

@RestController
@RequestMapping("/api/v1/kafka")
public class CompanyController {

	@Autowired
	private JsonKafkaProducer jsonKafkaProducer;

	/**
	 * URL : http://localhost:8080/api/v1/kafka/publish
	 */
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody Company company) {
		jsonKafkaProducer.sendMessage(company);
		return ResponseEntity.ok("Json message sent to kafka topic");
	}
}
