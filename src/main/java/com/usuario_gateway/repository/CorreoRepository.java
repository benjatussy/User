package com.usuario_gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usuario_gateway.model.Correo;

public interface CorreoRepository extends JpaRepository<Correo, Integer> {
    
}