package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Company;

public interface CompanyService {

	Company addCompany(Company company);

	List<Company> getCompanyByName(String companyName);

	Iterable<Company> getAllCompanies();
	
	

}
