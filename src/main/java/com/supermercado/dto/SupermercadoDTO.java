package com.supermercado.dto;

import java.util.List;


import com.supermercado.modelo.Producto;

public class SupermercadoDTO {

	private long idSupermercado;

	private String nombre;

	private String direccion;
	
	private List<Integer> listaProductos;

	public long getIdSupermercado() {
		return idSupermercado;
	}

	public void setIdSupermercado(long idSupermercado) {
		this.idSupermercado = idSupermercado;
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

	public List<Integer> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Integer> listaProductos) {
		this.listaProductos = listaProductos;
	}
}
