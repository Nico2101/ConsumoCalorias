package com.usuario.ladc.web.consumoCalorias.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="usuario") 
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "correo")
    private String correo;
    @Column(name = "clave")
    private String clave;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "max_calorias")
    private Integer maxCalorias;
    @Column(name = "peso")
    private Integer peso;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy= "usuario")
    private Set<Alimento> alimentos = new HashSet<Alimento>(0);
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy= "usuario")
    private Set<Consumo> consumos = new HashSet<Consumo>(0);
    
    public int calcularEdad(){
    	//Obtener la edad del usuario dada la fecha de nacimiento
    	return 0;
    }
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getMaxCalorias() {
		return maxCalorias;
	}

	public void setMaxCalorias(Integer maxCalorias) {
		this.maxCalorias = maxCalorias;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Set<Alimento> getAlimentos() {
		return alimentos;
	}
	
	public void setAlimentos(Set<Alimento> alimentos) {
		this.alimentos = alimentos;
	}
	
	public Set<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(Set<Consumo> consumos) {
		this.consumos = consumos;
	}
	
}
