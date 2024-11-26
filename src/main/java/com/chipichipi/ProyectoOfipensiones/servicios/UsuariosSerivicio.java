package com.chipichipi.ProyectoOfipensiones.servicios;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.chipichipi.ProyectoOfipensiones.modelo.Estudiante;
import com.chipichipi.ProyectoOfipensiones.modelo.Factura;
import com.chipichipi.ProyectoOfipensiones.modelo.ResponsableEconomico;
import com.chipichipi.ProyectoOfipensiones.modelo.Usuario;
import com.chipichipi.ProyectoOfipensiones.repositorios.UsuarioRepository;

import org.bson.types.ObjectId;


@Service
public class UsuariosSerivicio {


    @Autowired
    private FacturaServicio facturaServicio;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired 
    private RestTemplate restTemplate;

    @Transactional
    public Collection<Factura> darFacturasResponsableEconomico(ObjectId id) {
        Collection<Factura> facturasResponsable = new ArrayList<>();

        ResponsableEconomico responsableEconomico = usuarioRepository.findResponsableEconomico(id);

        
        if (responsableEconomico != null) {
            for (Estudiante estudiante : responsableEconomico.getEstudiantesACargo()) {
                Collection<Factura> facturas = facturaServicio.darFacturasEstudiante(estudiante.getId());

                facturasResponsable.addAll(facturas);
            }
        }

        return facturasResponsable;
    }


    public boolean MicroservicioValidadUsuario(String id) {
        String microservicioUrl = "http://localhost:8081/ofipensiones/api/usuarios/" + id;
        Usuario usuario = restTemplate.getForObject(microservicioUrl, Usuario.class);

        String idBD = String.valueOf(usuario.getId());
        

        if(idBD.equals(id)){
            return true;
        }else{
            return false;
        }
    }
    


    public boolean existeUsuario(int id) {
        return true;
    }
    


    
}

