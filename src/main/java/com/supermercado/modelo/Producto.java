package com.supermercado.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name="productos")
public class Producto {
	
	public Producto(long id, String nombre, double precio, int cantidad){
		this.cantidad = cantidad;
		this.precio = precio;
		this.idProducto = id;
		this.nombre = nombre;
		this.disponible = true;
	}
	
	

	public Producto() {
		super();
	}



	@Id // Obligatoria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private long idProducto;
	
//	@NotEmpty
	private String nombre;
//	@Min(0)
	private double precio;
//	@Min(0)
	private int cantidad;
	
	private boolean disponible;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Supermercado supermercado;

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long id) {
		this.idProducto = id;
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

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Supermercado getSupermercado() {
		return supermercado;
	}

	public void setSupermercado(Supermercado supermercado) {
		this.supermercado = supermercado;
	}
	
	
}
