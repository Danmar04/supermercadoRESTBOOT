package com.supermercado.controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.supermercado.delegado.ProductoDelegado;
import com.supermercado.modelo.Producto;

@Controller
public class ProductoControlador {
	
//	@Autowired  
//	private ProductoDelegado productoDelegate;

//	@RequestMapping("/crearProducto")
//	public ModelAndView createProducto( @ModelAttribute(value="producto") Producto producto, BindingResult resultado ) {
////		if(resultado.hasErrors()){
////			List<ObjectError> errores=resultado.getAllErrors();
////			for (Iterator<ObjectError> iterator = errores.iterator(); iterator.hasNext();) {
////				ObjectError error = (ObjectError) iterator.next();
////				System.out.println(error.getCode());
////				System.out.println(error.getDefaultMessage());
////			}
////		}else {
//			
//			productoDelegate.crearProducto(producto);
////		}
//		ModelAndView model = new  ModelAndView("productos");
//		model.addObject("listadoProductos", listaTodos());
//		return model;
//	}
//	
//	@RequestMapping(value="/borrarProducto")
//	public ModelAndView deleteProducto(@ModelAttribute(value="producto") Producto producto, @RequestParam(value="idProducto") int idProducto) {
//		productoDelegate.borrarProducto(idProducto);
//		ModelAndView model = new  ModelAndView("productos");
//		model.addObject("listadoProductos", listaTodos());
//		return model;
//	}
//	
//	@RequestMapping("/actualizarProducto")
//	public ModelAndView updateProducto(@ModelAttribute(value="producto") Producto producto,
//			BindingResult resultado) {
////		if(resultado.hasErrors()){
////			List<ObjectError> errores=resultado.getAllErrors();
////			for (Iterator<ObjectError> iterator = errores.iterator(); iterator.hasNext();) {
////				ObjectError error = (ObjectError) iterator.next();
////				System.out.println(error.getCode());
////				System.out.println(error.getDefaultMessage());
////			}
////		}else {
//			
//			productoDelegate.modificarProducto(producto);
////		}
//	
//		ModelAndView model = new  ModelAndView("productos");
//		model.addObject("listadoProductos", listaTodos());
//		return model;
//	}
//	
//	@RequestMapping("/verProducto")
//	public ModelAndView readProducto(int idProducto) {
//		return new ModelAndView("productos");
//	}
//	
//	@RequestMapping("/mostrarProductos")
//	public ModelAndView showAllProducto(@ModelAttribute(value="producto") Producto producto) {
//		ModelAndView model = new  ModelAndView("productos");
//		model.addObject("listadoProductos", listaTodos());
//		return model;
//	}
//	
//	@RequestMapping("/seleccionarProducto")
//	public ModelAndView seleccionar(@ModelAttribute(value="producto") Producto producto, @RequestParam(value="idProducto") int idProducto, HttpServletRequest request){
//				
//		//Esto se puede mejorar
//		Producto c = productoDelegate.leerProducto(idProducto);
//		producto.setCantidad(c.getCantidad());
//		producto.setDisponible(c.isDisponible());
//		producto.setIdProducto(c.getIdProducto());
//		producto.setPrecio(c.getPrecio());
//		producto.setNombre(c.getNombre());
//		ModelAndView model = new  ModelAndView("productos");
//		model.addObject("producto", producto);
//		
//		//FORWARD
//		return model;
//	}
//	
//	
//	@ModelAttribute(value = "listadoProductos")
//	public List<Producto> listaTodos(){
//		return productoDelegate.listarProductos();
//	}
//	
}
