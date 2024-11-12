package com.chipichipi.ProyectoOfipensiones.servicios;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chipichipi.ProyectoOfipensiones.modelo.Factura;
import com.chipichipi.ProyectoOfipensiones.modelo.Usuario;
import com.chipichipi.ProyectoOfipensiones.repositorios.FacturasRepository;
import com.chipichipi.ProyectoOfipensiones.repositorios.UsuariosRepository;

@Service
public class FacturaServicio {

    @Autowired
    private FacturasRepository facturasRepository;
    @Autowired
    private UsuariosRepository usuarioRepository;

    @Transactional
    public Collection<Factura> darFacturasResponsableEconomico(int id){
        return facturasRepository.darFacturasResponsableEconomico(id);
    }


    @Transactional
    public Collection<Factura> darFacturasGestorContable(int id){
        
        System.out.println(usuarioRepository.findById(id));
        Usuario gestor = usuarioRepository.darUsuarioPorId(id);


        Integer institucion = gestor.getInstitucionasociada();
        return facturasRepository.darFacturasGestorContable(institucion);

    }

    @Transactional
    public Collection<Factura> darFacturasAdministrador() {
        return facturasRepository.darFacturas();
    }



    
}
