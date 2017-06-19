package com.usuario.ladc.web.consumoCalorias.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

	public void setFecha(String fecha ) {
		this.fecha = fecha;
	}
    
    public String getFecha(){
    	return this.fecha;
    }
	
	public Float getPorcion() {
		return porcion;
	}

	public void setPorcion(Float porcion) {
		this.porcion = porcion;
		logger.info("porcion set to " + porcion);
	}

	public Integer getAlimento() {
		return alimento;
	}
	
	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
		logger.info("tipo set to " + tipo);
	}

	public void setAlimento(Integer alimento) {
		this.alimento = alimento;
		logger.info("alimento set to " + alimento);
	}
	
	
}