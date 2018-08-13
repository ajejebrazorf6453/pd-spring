package com.example.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
//import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
//import org.springframework.messaging.support.GenericMessage;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class Demo2Application implements ApplicationRunner{
	
	@Autowired @Qualifier("inputChannel")
	private DirectChannel inputChannel;
	
	@Autowired
	private MessagingTemplate template;
	
	@Bean
	MessagingTemplate messagingTemplate() {
		return new MessagingTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Message<String> message = MessageBuilder.withPayload("Cià").setHeader("piro", "prrrrr").build();
		Message<?> x = template.sendAndReceive(inputChannel,message);
		System.out.println(x);
	}
}
