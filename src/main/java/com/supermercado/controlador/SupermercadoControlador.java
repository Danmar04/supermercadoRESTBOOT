package com.supermercado.controlador;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.supermercado.delegado.SupermercadoDelegado;
import com.supermercado.dto.SupermercadoDTO;
import com.supermercado.modelo.Producto;
import com.supermercado.modelo.Supermercado;

@Controller
public class SupermercadoControlador {
	
	@Autowired
	private SupermercadoDelegado supermercadoDelegado;
	
	
//	@RequestMapping(value="/crearSupermercado")
//	public ModelAndView createSupermercado(@Valid @ModelAttribute(value="supermercado") Supermercado supermercado, BindingResult resultado ) {
//		if(resultado.hasErrors()){
//			List<ObjectError> errores=resultado.getAllErrors();
//			for (Iterator<ObjectError> iterator = errores.iterator(); iterator.hasNext();) {
//				ObjectError error = (ObjectError) iterator.next();
//				System.out.println(error.getCode());
//				System.out.println(error.getDefaultMessage());
//			}
//		}else {
//			
//			supermercadoDelegado.crearSuper(supermercado);;
//		}
//		ModelAndView model = new  ModelAndView("supermercados");
//		model.addObject("listadoSupermercados", listaTodos());
//		return model;
//	}
	
//	@RequestMapping(value="/borrarSupermercado")
//	public ModelAndView deleteSupermercado(@ModelAttribute(value="supermercado") Supermercado supermercado, @RequestParam(value="idSuper") int idSuper) {
//		supermercadoDelegado.borrarSupermercado(idSuper);
//		ModelAndView model = new  ModelAndView("supermercados");
//		model.addObject("listadoSupermercados", listaTodos());
//		return model;
//	}
//	
//	@RequestMapping("/actualizarSupermercado")
//	public ModelAndView updateSupermercado(@Valid @ModelAttribute(value="supermercado") Supermercado supermercado,
//			BindingResult resultado) {
//		if(resultado.hasErrors()){
//			List<ObjectError> errores=resultado.getAllErrors();
//			for (Iterator<ObjectError> iterator = errores.iterator(); iterator.hasNext();) {
//				ObjectError error = (ObjectError) iterator.next();
//				System.out.println(error.getCode());
//				System.out.println(error.getDefaultMessage());
//			}
//		}else {
//			
//			supermercadoDelegado.modificarSupermercado(supermercado);
//		}
//	
//		ModelAndView model = new  ModelAndView("supermercados");
//		model.addObject("listadoSupermercados", listaTodos());
//		return model;
//	}
	
	@RequestMapping("/verSupermercados")
	public ModelAndView readSupermercado(int idSupermercado) {
		return new ModelAndView("supermercados");
	}
	
	@RequestMapping("/mostrarSupermercados")
	public ModelAndView showAllSupermercados(@ModelAttribute(value="supermercado") SupermercadoDTO supermercado) {
		ModelAndView model = new  ModelAndView("supermercados");
		model.addObject("listadoSupermercados", listaTodos());
		return model;
	}
	
//	@RequestMapping("/seleccionarSupermercado")
//	public ModelAndView seleccionar(@ModelAttribute(value="supermercado") Supermercado supermercado, @RequestParam(value="idSuper") int idSuper, HttpServletRequest request){
//				
//		//Esto se puede mejorar
//		Supermercado c = supermercadoDelegado.leerSupermercado(idSuper);
//		supermercado.setIdSuper(c.getIdSuper());
//		supermercado.setNombre(c.getNombre());
//		supermercado.setDireccion(c.getDireccion());
//		ModelAndView model = new  ModelAndView("supermercados");
//		model.addObject("supermercado", supermercado);
//		
//		//FORWARD
//		return model;
//	}
//	
	
	@ModelAttribute(value = "listadoSupermercados")
	public List<SupermercadoDTO> listaTodos(){
		return supermercadoDelegado.listarSupermercados();
	}
//	
	
//	@RequestMapping("/verProductos")
//	public ModelAndView listarProductosSupermercado(@ModelAttribute(value="supermercado") Supermercado supermercado, @RequestParam(value="idSuper") int idSuper, HttpServletRequest request){
//		ModelAndView model = new  ModelAndView("supermercados");
//		model.addObject("listadoProductosSupermercado", listarProductos(supermercado));
//		
//		//FORWARD
//		return model;
//	}
//	@ModelAttribute(value = "listadoProductosSupermercado")
//	public List<Producto> listarProductos(Supermercado supermercado){
//		return supermercado.getListaProductos();
//	}
//	
//	@RequestMapping("/addProducto")
//	public ModelAndView addProduct(
//			@ModelAttribute(value="supermercado") Supermercado supermercado,
//			
//			@RequestParam(value="idSuper") int idSuper,
//			HttpServletRequest request){
//		
//		supermercadoDelegado.addProductoSupermercado(supermercado );
//		ModelAndView model = new  ModelAndView("supermercados");
//		model.addObject("listadoProductosSupermercado", listarProductos(supermercado));
//		
//		//FORWARD
//		return model;
//	}

}
