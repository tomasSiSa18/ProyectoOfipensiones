package com.chipichipi.ProyectoOfipensiones.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chipichipi.ProyectoOfipensiones.modelo.Usuario;
import com.chipichipi.ProyectoOfipensiones.repositorios.UsuarioRepository;


@Service
public class UsuariosSerivicio {


  
    @Autowired
    private UsuarioRepository usuarioRepository;

  
    public Optional<Usuario> buscarUsuarioPorId(int id) {
        return usuarioRepository.findById(id);
    }
    


    
}

