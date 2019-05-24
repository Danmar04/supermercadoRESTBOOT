package com.supermercado.dto;

public class ProductoDTO {
	
	private long idProducto;
	private String nombre;
	private double precio;
	private int cantidad;
	private boolean disponible;
	private Integer supermercadoDTO;
	
	
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getSupermercadoDTO() {
		return supermercadoDTO;
	}
	public void setSupermercadoDTO(Integer supermercadoDTO) {
		this.supermercadoDTO = supermercadoDTO;
	}
	
	
	

}
