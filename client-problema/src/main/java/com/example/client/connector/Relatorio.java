package com.example.client.connector;

import java.time.LocalDateTime;

public class Relatorio {
	
	private LocalDateTime dataHora;
	
	private Integer ultimoEnvelopeEnviado;

	private Integer ultimoEnvelopeRetornado;
	
	public Relatorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Relatorio(LocalDateTime dataHora, Integer ultimoEnvelopeEnviado,
			Integer ultimoEnvelopeRetornado) {
		super();
		this.dataHora = dataHora;
		this.ultimoEnvelopeEnviado = ultimoEnvelopeEnviado;
		this.ultimoEnvelopeRetornado = ultimoEnvelopeRetornado;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getUltimoEnvelopeEnviado() {
		return ultimoEnvelopeEnviado;
	}

	public void setUltimoEnvelopeEnviado(Integer ultimoEnvelopeEnviado) {
		this.ultimoEnvelopeEnviado = ultimoEnvelopeEnviado;
	}

	public Integer getUltimoEnvelopeRetornado() {
		return ultimoEnvelopeRetornado;
	}

	public void setUltimoEnvelopeRetornado(Integer ultimoEnvelopeRetornado) {
		this.ultimoEnvelopeRetornado = ultimoEnvelopeRetornado;
	}
	
}
