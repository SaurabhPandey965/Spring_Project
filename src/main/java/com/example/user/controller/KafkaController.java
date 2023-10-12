package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.kafka.KafkaProducer;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/kafka")
public class KafkaController {
	
	private final KafkaProducer kafkaProducer;
	@Autowired
	KafkaController(KafkaProducer Producer){
	  this.kafkaProducer = Producer;	
	}
	/*
	 * @Autowired private KafkaProducer kafkaProducer;
	 */
	
	@PostMapping("/publishMsg")
	ResponseEntity<Void> pushMsg(@RequestParam String mesaage){
		log.info("kafka api calaling....."+ mesaage);
		this.kafkaProducer.publishMessage(mesaage);
		return ResponseEntity.ok().build();
	}
	   
	
	

}
