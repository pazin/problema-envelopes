package com.example.client.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.client.ProcessadorClientService;

@Component
public class Connector {
	
	@Autowired
	private ProcessadorClientService processador;

	// de 15 em 15 segundos
	@Scheduled(cron="0/15 0/1 * 1/1 * ?")
	public void getEnvelopes() {
		System.out.println("Invocando o processar");
		processador.processar();
		System.out.println("Processar invocado");
	}
	
}
