package com.supermercado.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.supermercado.modelo.Producto;
import com.supermercado.modelo.Supermercado;

public interface ProductoCRUDRepositorio extends JpaRepository<Producto, Long> {
	
	static List<Producto> findByCriteria(String nombre, Double precio, Integer cantidad, boolean disponible, Supermercado supermercado){
        return ProductoCRUDRepositorio.findAll(new Specification<Producto>() {
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

	static List<Producto> findAll(Specification<Producto> specification) {
		// TODO Auto-generated method stub
		return null;
	}
}
