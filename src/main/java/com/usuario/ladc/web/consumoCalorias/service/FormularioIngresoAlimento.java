package com.usuario.ladc.web.consumoCalorias.service;

import java.sql.Date;

import javax.validation.constraints.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.NotEmpty;

import com.usuario.ladc.web.consumoCalorias.domain.Alimento;
import com.usuario.ladc.web.consumoCalorias.domain.Tipo;

public class FormularioIngresoAlimento {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    @NotEmpty(message="La fecha no ha sido especificada")
    private String fecha;
    
    @Min(value=0,message="La porción no ha sido especificada")
    private float porcion;
    
    @Min(value=0,message="El tipo no ha sido especificado")
    private int tipo;
    
    @Min(value=0,message="El alimento no ha sido especificado")
    private int alimento;
    
    public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha ) {
		this.fecha = fecha;
		logger.info("fecha set to " + fecha);
	}
	
	public float getPorcion() {
		return porcion;
	}

	public void setPorcion(float porcion) {
		this.porcion = porcion;
		logger.info("porcion set to " + porcion);
	}

	public int getAlimento() {
		return alimento;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setAlimento(int alimento) {
		this.alimento = alimento;
	}
	
	
}