package com.usuario_gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usuario_gateway.model.Usermodel;

@Repository
public interface User_repository extends JpaRepository <Usermodel, Integer> {
}
