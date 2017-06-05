package com.usuario.ladc.web.consumoCalorias.service;

import javax.validation.constraints.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.NotEmpty;

public class FormularioLoggin {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    @NotEmpty(message="El usuario no ha sido especificado")
    private String correo;
    
    @NotEmpty(message="La clave no ha sido especificada")
    private String clave;
    
    public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
		logger.info("correo set to " + correo);
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
		logger.info("clave set to " + clave);
	}

}
