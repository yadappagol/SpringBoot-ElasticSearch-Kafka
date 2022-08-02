package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonKafkaProducer {

	@Autowired
	private KafkaTemplate<String, Company> kafkaTemplate;

	public void sendMessage(Company company) {

		log.info(String.format("Message sent -> %s", company.toString()));

		Message<Company> message = MessageBuilder.withPayload(company).setHeader(KafkaHeaders.TOPIC, "JsonDemo-kafka")
				.build();

		kafkaTemplate.send(message);
	}
}
