package com.example.client;

import java.time.LocalDateTime;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.client.connector.Relatorio;

@Service
public class ProcessadorClientService {

	private SortedMap<LocalDateTime, Relatorio> mapRelatorioPedidos;
	
	private AtomicInteger ultimoEnvelopeCompartilhado;
	
	@PostConstruct
	public void init() {
		mapRelatorioPedidos = new TreeMap<LocalDateTime, Relatorio>();
		ultimoEnvelopeCompartilhado = new AtomicInteger(5);
	}
	
	@Async
	public void processar() {
		
		// obtem o ultimo envelope
		Integer ultimo = ultimoEnvelopeCompartilhado.get();

		System.out.println(String.format("Disparando o getEnvelopes -> ultimoEnvelope %d | Thread : %s ", ultimo, Thread.currentThread().getName()));

		String url = "http://localhost:8080/getenvelopes/{ultimo}";
		
		// conecta
		RestTemplate template = new RestTemplate();
		Integer ultimoRecebido = template.getForObject(url, Integer.class, ultimo);
		
		// grava no mapa relatorio
		LocalDateTime agora = LocalDateTime.now();
		Relatorio rel = new Relatorio(agora, ultimo, ultimoRecebido);
		
		mapRelatorioPedidos.put(agora, rel);
		
		// atualiza o ultimo envelope aos poucos
		
		if ( ultimoRecebido == null || ultimoRecebido <= 0 || ultimoRecebido <= ultimo )
			System.out.println("Nada diferente no server");
		else {
			
			for (int i = ultimo; i <= ultimoRecebido; i++) {
				
				// quantidade de tempo em segundos para processar cada envelope
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// aqui é que começa a bagunça com várias threads podendo escrever qual é o "envelope atual"
				ultimoEnvelopeCompartilhado.set(i);
				System.out.println(String.format("Setando o envelope atual %d", i));
			}
		}
		
	}
}
