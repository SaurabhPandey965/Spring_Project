package com.example.user.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	   public void  publishMessage(String message) {
		   log.info("kafka publishing message "+ message);
		  this.kafkaTemplate.send("user", message);
		   
		   
	   }

}
