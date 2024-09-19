package com.chipichipi.ProyectoOfipensiones.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chipichipi.ProyectoOfipensiones.modelo.Institucion;
import com.chipichipi.ProyectoOfipensiones.servicios.InstitucionServicio;

@RestController
@RequestMapping("/instituciones")
public class ControladorInstituciones {

    @Autowired
    private InstitucionServicio institucionServicio;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Collection<Institucion> instituciones() {
        return institucionServicio.getInstituciones();
    }

    @PostMapping("/new")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Institucion crearInstitucion(Institucion institucion) {
        Institucion institucionNueva = institucionServicio.crearInstitucion(institucion);
        return institucionNueva;
    }
    
}
