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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="alimento")
public class Alimento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "calorias")
	private int calorias;
	@Column(name = "cantidad")
	private float cantidad;
	@Column(name = "medida")
	private String medida;
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
    @IndexColumn(name="id_alimento")
	private List<Consumo> consumos;
	
	public final static String GRAMOS = "gr";
	public final static String MILILITROS = "ml";
	
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
	
	public int getCalorias() {
		return calorias;
	}
	
	public void setCalorias(int calorias) {
		this.calorias = calorias;
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
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}
	
	
}
