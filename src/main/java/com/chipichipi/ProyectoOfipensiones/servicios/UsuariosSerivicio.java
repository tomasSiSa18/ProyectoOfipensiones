package com.chipichipi.ProyectoOfipensiones.servicios;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chipichipi.ProyectoOfipensiones.modelo.Estudiante;
import com.chipichipi.ProyectoOfipensiones.modelo.Factura;
import com.chipichipi.ProyectoOfipensiones.modelo.ResponsableEconomico;
import com.chipichipi.ProyectoOfipensiones.repositorios.UsuariosRepository;

import org.bson.types.ObjectId;

@Service
public class UsuariosSerivicio {


    @Autowired
    private FacturaServicio facturaServicio;
    @Autowired
    private UsuariosRepository usuarioRepository;


    public boolean existeUsuario(int id) {
        return true;
    }
    


    
}

