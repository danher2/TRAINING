package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//IMPLEMENTACION SPRING SECURITY CON PERSITENCIA  UTILIZANDO JPA
// PRIMERO CREAR LAS CLASES ENTITY MAPEADAS PAPRA USUARIOS Y ROL

@Entity // es una entidad mapeanda a la bbdd entidad de persistencia , uniqueConstraints , indica el que el user_id y el authority son unicos
@Table(name = "authorities", uniqueConstraints= {@UniqueConstraint(columnNames= {"user_id", "authority"})}) // mapeamos a la tabla autorities
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremental
	private Long id;

	private String authority;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
