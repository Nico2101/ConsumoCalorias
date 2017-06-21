package com.usuario.ladc.web.consumoCalorias.service;

import java.sql.Date;

import javax.validation.constraints.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.NotEmpty;

import com.usuario.ladc.web.consumoCalorias.domain.Alimento;
import com.usuario.ladc.web.consumoCalorias.domain.Tipo;

public class FormularioIngresoNuevoAlimento {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Min(value=0,message="La categoría no ha sido especificada")
    private int categoria;
    
    @NotEmpty(message="El nombre no ha sido especificado")
    private String nombre;
    
    @Min(value=0,message="La cantidad no ha sido especificada")
    private float cantidad;
    
    @NotEmpty(message="La medida no ha sido especificado")
    private String medida;
    
    @Min(value=0,message="Las calorias no ha sido especificada")
    private int calorias;
    
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
    
    

}