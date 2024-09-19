package com.chipichipi.ProyectoOfipensiones.servicios;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chipichipi.ProyectoOfipensiones.modelo.Institucion;
import com.chipichipi.ProyectoOfipensiones.repositorios.InstitucionRepository;

@Service
public class InstitucionServicio {

    @Autowired
    private InstitucionRepository institucionRepository;

    @Transactional
    public Collection<Institucion> getInstituciones() {
        return institucionRepository.darInstituciones();
    }
    
}
