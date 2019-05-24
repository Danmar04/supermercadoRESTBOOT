package com.supermercado.delegado;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermercado.dto.SupermercadoDTO;
import com.supermercado.modelo.Producto;
import com.supermercado.modelo.Supermercado;
import com.supermercado.negocio.GestorProducto;
import com.supermercado.negocio.GestorSupermercado;


@Component
public class SupermercadoDelegado {
	@Autowired
	private GestorSupermercado gestorSuper;
	
	@Autowired
	private GestorProducto gestorProducto;
	
	public void crearSuper(SupermercadoDTO supermercado) {
		gestorSuper.insertSupermercado(this.DTO2Supermercado(supermercado));
	}
	
	public List<SupermercadoDTO> listarSupermercados(){
		List<Supermercado> listaSuper = gestorSuper.listarTodos();
		List<SupermercadoDTO> listaSuperDTO = new ArrayList<SupermercadoDTO>();
		for(Supermercado p : listaSuper) {
			listaSuperDTO.add(this.supermercado2DTO(p));
		}
		return listaSuperDTO;
	}
	
	public void borrarSupermercado(int supermercado) {
		Supermercado prodBD = gestorSuper.obtenerSupermercado(supermercado);
		gestorSuper.borrarSupermercado(prodBD);
	}
	
	public void modificarSupermercado(SupermercadoDTO supermercado) {
		gestorSuper.actualizarSupermercado(this.DTO2Supermercado(supermercado));
	}

	public SupermercadoDTO leerSupermercado(int idsuper) {
		return this.supermercado2DTO(gestorSuper.obtenerSupermercado(idsuper));
	}
	
//	public void addProductoSupermercado(SupermercadoDTO supermercado, Producto producto) {
//		gestorSuper.addProducto(producto, supermercado);
//	}
	
	private SupermercadoDTO supermercado2DTO(Supermercado supermercado) {
		SupermercadoDTO superDTO = new SupermercadoDTO();
		superDTO.setDireccion(supermercado.getDireccion());
		superDTO.setIdSupermercado(supermercado.getIdSuper());
		List<Integer> listSupermercado = new ArrayList();
		for(Producto p : supermercado.getListaProductos()) {
			listSupermercado.add((int) p.getIdProducto());
		}
		superDTO.setListaProductos(listSupermercado);
		superDTO.setNombre(supermercado.getNombre());
		return superDTO;
	}
	
	private Supermercado DTO2Supermercado(SupermercadoDTO superDTO) {
		Supermercado supermercado = new Supermercado();
		supermercado.setDireccion(superDTO.getDireccion());
		supermercado.setIdSuper(superDTO.getIdSupermercado());
		List<Producto> listSupermercado = new ArrayList();
		for(Integer p : superDTO.getListaProductos()) {
			listSupermercado.add(gestorProducto.obtenerProducto(p));
		}
		supermercado.setListaProductos(listSupermercado);
		supermercado.setNombre(superDTO.getNombre());
		return supermercado;
	}
}
