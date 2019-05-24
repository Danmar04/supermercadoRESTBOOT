package com.supermercado.delegado;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.supermercado.dto.ProductoDTO;
import com.supermercado.dto.SupermercadoDTO;
import com.supermercado.modelo.Producto;
import com.supermercado.modelo.Supermercado;
import com.supermercado.negocio.GestorProducto;
import com.supermercado.negocio.GestorSupermercado;

@Component
public class ProductoDelegado {
	@Autowired
	private GestorProducto productoServ;
	
	@Autowired
	private GestorSupermercado gestorSupermercado;
	
	public void crearProducto(ProductoDTO productoDTO, Integer supermercado) {
		productoServ.insertProducto(this.DTO2Producto(productoDTO), supermercado);
	}
	
	public List<ProductoDTO> listarProductos(){
		List<Producto> listaProd = productoServ.listarTodos();
		List<ProductoDTO> listaProdDTO = new ArrayList<ProductoDTO>();
		for(Producto p : listaProd) {
			listaProdDTO.add(this.producto2DTO(p));
		}
		return listaProdDTO;
	}
	
	public void borrarProducto(int producto) {
		Producto prodBD = productoServ.obtenerProducto(producto);
		productoServ.borrarProducto(prodBD);
	}
	
	public void modificarProducto(ProductoDTO producto) {
		productoServ.actualizarProducto(this.DTO2Producto(producto));
	}

	public ProductoDTO leerProducto(int idProducto) {
		return this.producto2DTO(productoServ.obtenerProducto(idProducto));
	}
	
	private ProductoDTO producto2DTO(Producto producto) {
		ProductoDTO proDTO = new ProductoDTO();
		proDTO.setCantidad(producto.getCantidad());
		proDTO.setIdProducto(producto.getIdProducto());
		proDTO.setNombre(producto.getNombre());
		proDTO.setPrecio(producto.getPrecio());
		proDTO.setDisponible(producto.isDisponible());
		Supermercado supermercado = producto.getSupermercado();
		if(supermercado!=null) {
			proDTO.setSupermercadoDTO((int) supermercado.getIdSuper());			
		}
		return proDTO;
		
	}
	
	private Producto DTO2Producto(ProductoDTO proDTO) {
		Producto producto = new Producto();
		producto.setCantidad(proDTO.getCantidad());
		producto.setIdProducto(proDTO.getIdProducto());
		producto.setNombre(proDTO.getNombre());
		producto.setPrecio(proDTO.getPrecio());
		producto.setDisponible(proDTO.isDisponible());
		Supermercado supermercado = gestorSupermercado.obtenerSupermercado(proDTO.getSupermercadoDTO());
		if(supermercado!=null)
			producto.setSupermercado(supermercado);
		return producto;
		
	}

	
}
