package com.example.demo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.model.Company;

public interface CompanyRepository extends ElasticsearchRepository<Company, Integer> {

	List<Company> findByCompanyName(String companyName);

}
