package com.supermercado.controlador;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.supermercado.delegado.SupermercadoDelegado;
import com.supermercado.dto.SupermercadoDTO;

@RestController
public class SupermercadoREST {

	@Autowired
	private SupermercadoDelegado supermercadoDelegado;

	@Autowired 
	private SupermercadoControlador supermercadoMVC;

	@RequestMapping(value="insertarSupermercado",
			method=RequestMethod.POST,
			consumes="application/json")
	public void insertar(@RequestBody SupermercadoDTO supermercadoDTO){
		System.out.println("ServicioSupermercado. Insertar:"+supermercadoDTO);
		supermercadoDelegado.crearSuper(supermercadoDTO);
	}

	@RequestMapping(value="actualizarSupermercado",
			method=RequestMethod.PUT,
			consumes="application/json")
	public void modificar(@RequestBody SupermercadoDTO supermercadoDTO){
		System.out.println("ServicioPeliculas. Modificar:"+supermercadoDTO);
		supermercadoDelegado.modificarSupermercado(supermercadoDTO);
	}

	@RequestMapping(value="borrarSupermercado/{id}",
			method=RequestMethod.DELETE)
	public void borrar(@PathVariable("id") String idSupermercado){
		System.out.println("ServicioPeliculas. Borrar:"+idSupermercado);
		supermercadoDelegado.borrarSupermercado(Integer.parseInt(idSupermercado));
	}

	@RequestMapping(value="verSupermercado/{id}",
			method=RequestMethod.GET,
			produces="application/json")	
	public SupermercadoDTO buscar(@PathVariable("id") String idSupermercado){
		System.out.println("ServicioPeliculas. Buscar:"+idSupermercado);
		SupermercadoDTO supermercado = supermercadoDelegado.leerSupermercado(Integer.parseInt(idSupermercado));
		return supermercado;
	}

	@RequestMapping(value="listarSupermercados",
			method=RequestMethod.GET,
			produces="application/json")	
	public List<SupermercadoDTO> listar(){
		System.out.println("LISTAR");
		List<SupermercadoDTO> listaMercados = supermercadoDelegado.listarSupermercados();
		return listaMercados;
	}	
	
	@RequestMapping("/mostrarSupermercadosAJAX")
	public ModelAndView mostrarListado(){
		ModelAndView mav = new ModelAndView("supermercadosAJAX");
		return mav;
	}
}
