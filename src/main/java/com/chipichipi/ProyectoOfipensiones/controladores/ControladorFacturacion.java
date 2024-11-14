package com.chipichipi.ProyectoOfipensiones.controladores;

import java.util.Collection;
import java.util.Random;

import org.springframework.ui.Model;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chipichipi.ProyectoOfipensiones.modelo.Factura;
import com.chipichipi.ProyectoOfipensiones.servicios.FacturaServicio;
import com.chipichipi.ProyectoOfipensiones.servicios.UsuariosSerivicio;

@RestController
@RequestMapping("/facturas")
public class ControladorFacturacion {

    @Autowired
    private FacturaServicio facturaServicio;
    
    @Autowired
    private UsuariosSerivicio usuariosSerivicio;

    @GetMapping("/all")
    public Collection<Factura> facturas() {
        return facturaServicio.darFacturas();
    }

    @GetMapping("/estudiante")
    public Collection<Factura> facturasEstudiante(@RequestParam("idEstudiante") int idEstudiante){
        return facturaServicio.darFacturasEstudiante(idEstudiante);
    }

     @GetMapping("/{id}")
    public String mostrarFacturas(@PathVariable("id") String id, Model model) {
        ObjectId objectId = new ObjectId(id);
        Collection<Factura> facturasResponsable = usuariosSerivicio.darFacturasResponsableEconomico(objectId);
        model.addAttribute("facturas", facturasResponsable);

        return "facturas"; 
    }

    @GetMapping("/aplicarDescuento/{id}")
    public String aplicarDescuentoFactura(@PathVariable("id") String id, Model model) {
        
        Random r = new Random();

        System.out.println(id);

        facturaServicio.aplicarDescuento(Integer.parseInt(id), 123);

        return "facturas"; 
    }

    
}
