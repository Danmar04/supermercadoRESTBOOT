package com.supermercado.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermercado.modelo.Producto;
import com.supermercado.modelo.Supermercado;
import com.supermercado.persistencia.ProductoCRUDRepositorio;
import com.supermercado.persistencia.ProductoDAO;
import com.supermercado.persistencia.SupermercadoCRUDRepositorio;


@Service
public class GestorProducto {
	
	
	@Autowired
	private ProductoCRUDRepositorio productoRepo;
	
	@Autowired 
	private SupermercadoCRUDRepositorio supermercadoRepo;
	
	public void insertProducto(Producto producto, Integer idSupermercado) {
		
		long idSuper = idSupermercado;
		Supermercado supermercado = new Supermercado();
		supermercado = supermercadoRepo.findOne(idSuper);
		producto.setSupermercado(supermercado);
		productoRepo.save(producto);
	}
	
	public List<Producto> listarTodos(){
		
		return productoRepo.findAll();
	}
	
	public void actualizarProducto(Producto producto) {
		
		//productoDao.updateProducto(producto);
		productoRepo.save(producto);
	}
	
	public void borrarProducto(Producto producto) {
			
			//productoDao.deleteProducto(producto);
			productoRepo.delete(producto);
		}
	
	public Producto obtenerProducto(int idProducto) {
		//return productoDao.getProducto(idProducto);
		return productoRepo.findOne((long) idProducto);
	}

}
