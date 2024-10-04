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
    
}
