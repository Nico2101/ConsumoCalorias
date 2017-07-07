package com.usuario.ladc.web.consumoCalorias.service;

import org.hibernate.validator.constraints.NotEmpty;

public class HtmlInforme {
	
	@NotEmpty(message="")
	private String contenido;

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	
}
