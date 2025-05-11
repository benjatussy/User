package com.usuario_gateway.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario_gateway.model.Usuario;
import com.usuario_gateway.repository.UserRepository;

@Service
public class User_service {

    @Autowired
    private UserRepository userRepository;

    // Obtener todos los usuarios
    public List<Usuario> getAll() {
        return userRepository.findAll();
    }

    // Obtener un usuario por su ID
    public Usuario getById(Integer id) {
        Optional<Usuario> user = userRepository.findById(id);
        return user.orElse(null);  // Si no se encuentra el usuario, devuelve null
    }

    // Agregar un nuevo usuario
    public Usuario add(Usuario user) {
        return userRepository.save(user);  // Guardar el nuevo usuario
    }

    // Actualizar un usuario existente
    public Usuario update(Integer id, Usuario user) {
        Optional<Usuario> existingUser = userRepository.findById(id);  // Buscar el usuario por ID
        if (existingUser.isPresent()) {
            // Si el usuario existe, actualizar los datos y guardar
            user.setId(id);
            return userRepository.save(user);
        } else {
            // Si el usuario no existe, devolver null
            return null;
        }
    }

    // Eliminar un usuario
    public Usuario delete(Integer id) {
        Optional<Usuario> user = userRepository.findById(id);  // Buscar el usuario por ID
        if (user.isPresent()) {
            userRepository.deleteById(id);  // Eliminar el usuario
            return user.get();  // Devolver el usuario eliminado
        } else {
            // Si el usuario no existe, devolver null
            return null;
        }
    }
}
