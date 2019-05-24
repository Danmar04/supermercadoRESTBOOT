package com.supermercado.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.supermercado.modelo.Producto;

public class ProductoDAO {
	
	private List<Producto> listaProducto;
	
	long id;
	
	
	

//	@Autowired
//	private HibernateTemplate hibernateTemplate;
//	
//	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//		this.hibernateTemplate = hibernateTemplate;
//	}

	public ProductoDAO() {
		super();
		this.listaProducto = new ArrayList<Producto>();
		this.id = 0;
	}


	public List<Producto> getListaProducto() {
		return listaProducto;
	}


	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	//Constructor hadrcoded
	public ProductoDAO(List<Producto> listaProducto) {
		super();
		this.listaProducto = listaProducto;
	}


	public void insertSIProducto(Producto producto) {
		//hibernateTemplate.save(producto);
		long contador = this.getId();
		List<Producto> listPr = this.getListaProducto();
		producto.setIdProducto(contador);
		this.setId(contador+1);
		listPr.add(producto);
		this.setListaProducto(listPr);
	}
	
	
	public List<Producto> getAllProductos(){
		return this.getListaProducto();
		
	}
	
	public void updateProducto(Producto producto) {
		//hibernateTemplate.update(producto);
		List<Producto> listaProductos = new ArrayList<Producto>();
		for(Producto p : this.getListaProducto()) {
			if(p.getIdProducto()==producto.getIdProducto()) {
				listaProductos.add(producto);
			}
			else {				
				listaProductos.add(p);
			}
		}
		this.setListaProducto(listaProductos);
	}
	
	public void deleteProducto(Producto producto) {
		//hibernateTemplate.delete(producto);
		List<Producto> listaProductos = new ArrayList<Producto>();
		for(Producto p : this.getListaProducto()) {
			if(p.getIdProducto()!=producto.getIdProducto()) {
				listaProductos.add(p);
			}
		}
		
		this.setListaProducto(listaProductos);
	
	}
	
	public Producto getProducto(int producto) {
		//return  (Producto) hibernateTemplate.find("select p from Producto p WHERE p.idProducto = " + producto).get(0);
		Producto producRes = new Producto();
		for(Producto p : this.getListaProducto()) {
			if(p.getIdProducto()==producto) {
				producRes.setCantidad(p.getCantidad());
				producRes.setDisponible(true);
				producRes.setNombre(p.getNombre());
				producRes.setIdProducto(p.getIdProducto());
				producRes.setPrecio(p.getPrecio());
			}
		}
		
		return producRes;
	}
}
