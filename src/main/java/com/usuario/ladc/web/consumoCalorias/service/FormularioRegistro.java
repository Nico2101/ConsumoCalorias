package com.usuario.ladc.web.consumoCalorias.service;

import javax.validation.constraints.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.NotEmpty;

public class FormularioRegistro {
	@NotEmpty(message="El correo no ha sido especificado")
    private String correo;
    
    @NotEmpty(message="La clave no ha sido especificada")
    private String clave;
    
    @NotEmpty(message="El nombre no ha sido especificado")
    private String nombre;
    
    @NotEmpty(message="El apellido no ha sido especificado")
    private String apellido;
    
    @Min(value=1,message="El peso no han sido especificada")
    private Integer peso; 
    
    @Min(value=1,message="Las Calorias no han sido especificada")
    private Integer maxCalorias; 
   

    
    public String getCorreo() {
		return correo;
	}
    public String getNombre() {
  		return nombre;
  	}
    public String getApellido() {
  		return apellido;
  	}
    public Integer getPeso() {
  		return peso;
  	}
    public Integer getMaxCalorias() {
  		return maxCalorias;
  	}

	public String getClave() {
		return clave;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	public void setMaxCalorias(Integer maxCalorias) {
		this.maxCalorias = maxCalorias;
	}

	

}
