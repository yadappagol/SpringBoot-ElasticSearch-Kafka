package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company addCompany(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public List<Company> getCompanyByName(String companyName) {
		return companyRepository.findByCompanyName(companyName);
	}

	@Override
	public Iterable<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

}
