package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // para indicar que es la clase POJO
@Table(name = "clientes") // nuestraa tabla se llama clientes, las tablas em mysql estan en plural
public class Cliente implements Serializable {// convertir objeto en bytes para almacenarlo o trasmitirlo  o peticiones en la sesion http 

	@Id //llave primaria 
	@GeneratedValue(strategy = GenerationType.IDENTITY)// cual es la estrategia en que genera la llave, se genera en automatico el id
	private Long id;

	@NotEmpty // validacion no vacio
	private String nombre;
	
	@NotEmpty // que sea requerido
	private String apellido;
	
	@NotEmpty
	@Email // validacion email
	private String email;

	@NotNull // valida que sea distinto de null -> porque es un objeto
	@Column(name = "create_at")// nombre de la columba en la tabla de mysql
	@Temporal(TemporalType.DATE) // indica el formato en que se va guardar la fecha de java en la tabla de bbdd
	@DateTimeFormat(pattern="yyyy-MM-dd") // depende del formato o el patron que le demos a fecha, para qu eno de error
	private Date createAt;

	
	//getter&setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

}
