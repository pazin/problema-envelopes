package com.example.server.business;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class DistribuicaoService {
	
	
	private Integer ultimoEnvelopeNoBanco = 100;

	public Integer processamentoDemorado(Integer ultimoEnvelope) {
		
		System.out.println(String.format("Request chegou -> ultimo envelope no client : %d", ultimoEnvelope));

		ThreadLocalRandom random = ThreadLocalRandom.current();
		
//		Integer incrementoRandom = random.nextInt(100);
		
		Integer resultado = ultimoEnvelope + ultimoEnvelopeNoBanco;
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return resultado;
	}

}
