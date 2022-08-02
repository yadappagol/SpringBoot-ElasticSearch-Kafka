package com.example.demo.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class JsonKafkaConsumerController {

	@Autowired
	private CompanyService companyService;

	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public Company saveCompany(Company company) {
		log.info(String.format("Json message recieved -> %s", company.toString()));
		Company save = companyService.addCompany(company);
		log.info(String.format("Json message Saved Into ElasticSearch -> %s", company.toString()));
		return save;
	}

	@GetMapping("/getAllCompanies")
	public Iterable<Company> getAllCompany() {
		Iterable<Company> findAll = companyService.getAllCompanies();
		log.info(String.format("Details Fetched Successfully -> %s", findAll.toString()));
		return findAll;
	}

	@GetMapping("/companyByName/{companyName}")
	public List<Company> getCompanyByName(@PathVariable String companyName) {
		List<Company> companyByName = companyService.getCompanyByName(companyName);
		log.info(String.format("Details Fetched Successfully -> %s", companyByName.toString()));
		return companyByName;
	}

}
