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
import com.chipichipi.ProyectoOfipensiones.servicios.UsuariosSerivicio;

@RestController
@RequestMapping("/instituciones")
public class ControladorInstituciones {

    @Autowired
    private InstitucionServicio institucionServicio;

    @Autowired
    private UsuariosSerivicio usuariosSerivicio;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Collection<Institucion> instituciones() {
        return institucionServicio.getInstituciones();
    }

    @PostMapping("/new")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Institucion crearInstitucion(@RequestBody Institucion institucion) {

        if(institucion.getNombre() == null) {
            try {
                throw new Exception("La institución no puede ser creada sin un nombre");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        
        if(institucion.getDireccion() == null) {
            try {
                throw new Exception("La institución no puede ser creada sin una direccion");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

        if(!usuariosSerivicio.existeUsuario(institucion.getGestorContable()) 
        || !usuariosSerivicio.existeUsuario(institucion.getGestorFinanciero()) 
        || !usuariosSerivicio.existeUsuario(institucion.getJefeAdministrativo()) 
        || !usuariosSerivicio.existeUsuario(institucion.getProovedorCobranza())) {

            try {
                throw new Exception("La institución no puede ser creada con un usuario que no aparece en el sistema por favor cree el usuario y vuelva a intentar.");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        }

        Institucion institucionNueva = institucionServicio.crearInstitucion(institucion);
        return institucionNueva;
    }
    
}
