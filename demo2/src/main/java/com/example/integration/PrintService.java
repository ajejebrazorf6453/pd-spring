package com.example.integration;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class PrintService {

	public Message<String> print(Message<String> message) {
		System.out.println("PrintSevice.print()"+message);
		return MessageBuilder.withPayload("Retrun value").build();
	}

}
