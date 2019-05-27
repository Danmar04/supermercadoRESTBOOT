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

	List<Producto> findAll(Specification<Producto> specification);

	
}

