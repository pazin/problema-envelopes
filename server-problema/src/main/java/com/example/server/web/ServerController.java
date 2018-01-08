package com.example.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.business.DistribuicaoService;

@RestController
public class ServerController {

	@Autowired
	private DistribuicaoService service;
	
	@GetMapping(value="/getenvelopes/{ultimo}")
	public Integer getEnvelopes(@PathVariable Integer ultimo) {
		
		Integer resultado = service.processamentoDemorado(ultimo);
		
		return resultado;
	}
	
}
