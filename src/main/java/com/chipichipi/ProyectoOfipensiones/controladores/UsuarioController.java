package com.chipichipi.ProyectoOfipensiones.controladores;

import com.chipichipi.ProyectoOfipensiones.servicios.UsuariosSerivicio;
import com.chipichipi.ProyectoOfipensiones.modelo.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuariosSerivicio usuarioService;

    public UsuarioController(UsuariosSerivicio usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public Collection<Usuario> obtenerUsuarios() {
        return usuarioService.darUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
        
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            Usuario usuarioVacio = new Usuario();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuarioVacio);
        }
    }
    


}
