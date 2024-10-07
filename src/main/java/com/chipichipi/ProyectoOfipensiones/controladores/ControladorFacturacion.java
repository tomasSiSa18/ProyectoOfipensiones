package com.chipichipi.ProyectoOfipensiones.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chipichipi.ProyectoOfipensiones.modelo.Factura;
import com.chipichipi.ProyectoOfipensiones.servicios.FacturaServicio;

@RestController
@RequestMapping("/facturas")
public class ControladorFacturacion {

    @Autowired
    private FacturaServicio facturaServicio;

    @GetMapping("/all")
    public Collection<Factura> facturas() {
        return facturaServicio.darFacturas();
    }

    @GetMapping("/estudiante")
    public Collection<Factura> facturasEstudiante(@RequestParam("idEstudiante") int idEstudiante){
        return facturaServicio.darFacturasEstudiante(idEstudiante);
    }
    
}
