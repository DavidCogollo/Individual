package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comunidades")
public class Comunidad implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idComunidad")
	private long idComunidad;
	
	private String nombre;

	public long getIdComunidad() {
		return idComunidad;
	}

	public void setIdComunidad(long id) {
		this.idComunidad = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombreComunidad(String nombreComunidad) {
		this.nombre = nombre;
	}
	
	

}
