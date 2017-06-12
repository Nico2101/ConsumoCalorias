package com.usuario.ladc.web.consumoCalorias.service;

import javax.validation.constraints.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.NotEmpty;

import com.usuario.ladc.web.consumoCalorias.domain.Categoria;

public class FormularioIngresoNuevoAlimento {
	Categoria categoria;
	private String nombreAlimento;
	private double porcion;
	private String medida;
	private int calorias;
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	
	 public Categoria getCategoria() {
			return categoria;
		}

		public void setCateogria(Categoria categoria) {
			this.categoria = categoria;
			logger.info("categoria set to " + categoria);
		}

		public String getNombreAlimento() {
			return nombreAlimento;
		}

		public void setNombreAlimento(String nombreAlimento) {
			this.nombreAlimento = nombreAlimento;
			logger.info("nombreAlimento set to " + nombreAlimento);
		}
		
		public double getPorcion(){
			return porcion;
		}
		
		public void setPorcion(double porcion){
			this.porcion=porcion;
			logger.info("porcion set to " + nombreAlimento);
		}
		
		public String getMedida(){
			return medida;
		}
		
		public void setMedida(String medida){
			this.medida=medida;
			logger.info("medida set to " + medida);
		}
		
		public int getCalorias(){
			return calorias;
		}
		
		public void setCalorias(int calorias){
			this.calorias=calorias;
			logger.info("calorias set to " + calorias);
		}
}
