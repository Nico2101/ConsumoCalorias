package com.usuario.ladc.web.consumoCalorias.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="consumo")
public class Consumo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "porcion")
	private float porcion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_alimento")
	private Alimento alimento;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo")
	private Tipo tipo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public float getPorcion() {
		return porcion;
	}
	
	public void setPorcion(float porcion) {
		this.porcion = porcion;
	}
	
	public Alimento getAlimento() {
		return alimento;
	}
	
	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
}
