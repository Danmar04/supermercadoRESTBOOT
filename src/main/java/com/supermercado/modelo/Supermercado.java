package com.supermercado.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table (name="supermercados")
public class Supermercado {

	@Id // Obligatoria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_supermercado")
	private long idSuper;
//	@NotEmpty
	private String nombre;
//	@NotEmpty
	private String direccion;
	
	@OneToMany(mappedBy="supermercado")
	private List<Producto> listaProductos = new ArrayList<Producto>();
	
	
	public long getIdSuper() {
		return idSuper;
	}
	public void setIdSuper(long idSuper) {
		this.idSuper = idSuper;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
}
