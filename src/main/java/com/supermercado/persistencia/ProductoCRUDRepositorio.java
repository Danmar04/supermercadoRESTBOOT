package com.supermercado.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermercado.modelo.Producto;

public interface ProductoCRUDRepositorio extends JpaRepository<Producto, Long> {

}
