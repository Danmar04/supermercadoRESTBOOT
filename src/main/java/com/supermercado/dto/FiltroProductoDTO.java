package com.supermercado.dto;

public class FiltroProductoDTO {
	
	private String nombre;
	private Integer cantidad;
	private Double precio;
	private Integer supermercado;
	private boolean disponible;
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getSupermercado() {
		return supermercado;
	}
	public void setSupermercado(Integer supermercado) {
		this.supermercado = supermercado;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
	

}
