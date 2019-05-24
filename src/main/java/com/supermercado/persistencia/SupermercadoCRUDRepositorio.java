package com.supermercado.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermercado.modelo.Supermercado;

public interface SupermercadoCRUDRepositorio extends JpaRepository<Supermercado, Long> {

	
}
