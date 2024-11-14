package com.chipichipi.ProyectoOfipensiones.servicios;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chipichipi.ProyectoOfipensiones.modelo.Factura;
import com.chipichipi.ProyectoOfipensiones.repositorios.FacturasRepository;

@Service
public class FacturaServicio {

    @Autowired
    private FacturasRepository facturasRepository;

    @Transactional
    public Collection<Factura> darFacturas() {
        return facturasRepository.darFacturas();
    }
    
    @Transactional
    public Collection<Factura> darFacturasEstudiante(int idEstudiante){
        return facturasRepository.darFacturasEstudiante(idEstudiante);
    }

    @Transactional
    public void aplicarDescuento(int id_factura, int amount) {

        facturasRepository.aplicarDescuento(id_factura, amount*-1);

    }
    
}
