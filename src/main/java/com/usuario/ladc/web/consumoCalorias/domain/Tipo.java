package com.usuario.ladc.web.consumoCalorias.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="tipo")
public class Tipo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
    @IndexColumn(name="id_tipo")
	private List<Consumo> consumos;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Consumo> getConsumos() {
		return consumos;
	}
	
	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}
	
}
