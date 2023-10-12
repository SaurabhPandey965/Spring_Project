package com.example.user.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {
	
	
	//@KafkaListener(topics = "users", groupId = "group_id")
	public void consumeMessage(String message) {
		 log.info("message consumed :"+ message);
		
	}

}
