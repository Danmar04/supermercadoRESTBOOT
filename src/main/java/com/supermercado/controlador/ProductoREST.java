package com.supermercado.controlador;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.supermercado.delegado.ProductoDelegado;
import com.supermercado.delegado.SupermercadoDelegado;
import com.supermercado.dto.ProductoDTO;
import com.supermercado.dto.SupermercadoDTO;
import com.supermercado.modelo.Supermercado;

@RestController
public class ProductoREST {
	
	@Autowired
	private ProductoDelegado productoDelegado;

	@RequestMapping(value="{idSupermercado}/insertarProducto",
			method=RequestMethod.POST,
			consumes="application/json")
	public void insertar(@PathVariable("idSupermercado") Integer idSupermercado, @RequestBody ProductoDTO productoDTO){
		//System.out.println("ServicioSupermercado. Insertar:"+supermercadoDTO);
		productoDelegado.crearProducto(productoDTO, idSupermercado);
	}

	@RequestMapping(value="actualizarProducto",
			method=RequestMethod.PUT,
			consumes="application/json")
	public void modificar(@RequestBody ProductoDTO producto){
//		System.out.println("ServicioPeliculas. Modificar:"+supermercadoDTO);
		productoDelegado.modificarProducto(producto);
	}

	@RequestMapping(value="borrarProducto/{id}",
			method=RequestMethod.DELETE)
	public void borrar(@PathVariable("id") String idProducto){
		productoDelegado.borrarProducto(Integer.parseInt(idProducto));
	}

	@RequestMapping(value="verProducto/{id}",
			method=RequestMethod.GET,
			produces="application/json")	
	public ProductoDTO buscar(@PathVariable("id") String idProducto){
		ProductoDTO producto = productoDelegado.leerProducto(Integer.parseInt(idProducto));
		return producto;
	}

	@RequestMapping(value="listarProductos",
			method=RequestMethod.GET,
			produces="application/json")	
	public List<ProductoDTO> listar(){
//		System.out.println("LISTAR");
		List<ProductoDTO> listaProductos = productoDelegado.listarProductos();
		return listaProductos;
	}	
	
	@RequestMapping("/mostrarProductosAJAX")
	public ModelAndView mostrarListado(){
		ModelAndView mav = new ModelAndView("productosAJAX");
		return mav;
	}
	

}
