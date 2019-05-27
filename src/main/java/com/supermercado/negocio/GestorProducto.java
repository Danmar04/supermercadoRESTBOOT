package com.supermercado.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.supermercado.dto.FiltroProductoDTO;
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
	
	public List<Producto> filterProducto(String nombre, Integer cantidad, Double precio, boolean disponible, Integer supermercado){
		
	        return productoRepo.findAll(new Specification<Producto>() {
	            @Override
	            public javax.persistence.criteria.Predicate toPredicate(Root<Producto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
	                List<Predicate> predicates = new ArrayList<>();
	                if(nombre!=null) {
	                    predicates.add((Predicate) criteriaBuilder.and(criteriaBuilder.equal(root.get("nombre"), nombre)));
	                }
	                if(precio!=null) {
	                    predicates.add((Predicate) criteriaBuilder.and(criteriaBuilder.equal(root.get("precio"), precio)));
	                }
	                if(cantidad!=null) {
	                	 predicates.add((Predicate) criteriaBuilder.and(criteriaBuilder.equal(root.get("cantidad"), cantidad)));
	                }
	                if(supermercado!=null) {
	               	 predicates.add((Predicate) criteriaBuilder.and(criteriaBuilder.equal(root.get("supermercado"), supermercado)));
	               }
	                
	                //FALTA FILTRAR POR DISPONIBLE
	                
	                return criteriaBuilder.and((javax.persistence.criteria.Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
	            }
	        });
		
	}

}
