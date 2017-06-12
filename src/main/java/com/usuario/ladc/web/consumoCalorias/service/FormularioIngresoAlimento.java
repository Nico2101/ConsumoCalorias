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
    private Date fecha;
    
    @NotEmpty(message="La porción no ha sido especificada")
    private float porcion;
    
    @NotEmpty(message="El tipo no ha sido especificado")
    private Tipo tipo;
    
    @NotEmpty(message="El alimento no ha sido especificado")
    private Alimento alimento;
    
    public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha ) {
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

	public Alimento getAlimento() {
		return alimento;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	

}
