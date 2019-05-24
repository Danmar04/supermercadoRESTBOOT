package com.supermercado.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermercado.modelo.Producto;
import com.supermercado.modelo.Supermercado;
import com.supermercado.persistencia.SupermercadoCRUDRepositorio;

@Service
public class GestorSupermercado {


	
	@Autowired
	private SupermercadoCRUDRepositorio supermercadoRepo;
	
	public void insertSupermercado(Supermercado supermercado) {
		//supermercadoDao.insertSISupermercado(supermercado);
		supermercadoRepo.save(supermercado);
	}
	
	public List<Supermercado> listarTodos(){
		
		return supermercadoRepo.findAll();
	}
	
	public void actualizarSupermercado(Supermercado supermercado) {
		
		//supermercadoDao.updateSupermercado(supermercado);
		supermercadoRepo.save(supermercado);
	}
	
	public void borrarSupermercado(Supermercado supermercado) {
			
			//supermercadoDao.deleteSupermercado(supermercado);
			supermercadoRepo.delete(supermercado);
		}
	
	public Supermercado obtenerSupermercado(int idSupermercado) {
		//return supermercadoDao.getSupermercado(idSupermercado);
		return supermercadoRepo.findOne((long) idSupermercado);
	}
	
	public void addProducto(Producto producto, Supermercado supermercado) {
		List<Producto> listaProducto = supermercado.getListaProductos();
		listaProducto.add(producto);
		supermercado.setListaProductos(listaProducto);
		
	}
}
