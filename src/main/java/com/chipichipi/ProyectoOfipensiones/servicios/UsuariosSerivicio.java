package com.chipichipi.ProyectoOfipensiones.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.chipichipi.ProyectoOfipensiones.modelo.Usuario;



@Service
public class UsuariosSerivicio {

    @Autowired 
    private RestTemplate restTemplate;



    public boolean MicroservicioValidadUsuario(String id) {
        String microservicioUrl = "http://34.69.84.207:8000/ofipensiones/api/usuarios/" + id;
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

