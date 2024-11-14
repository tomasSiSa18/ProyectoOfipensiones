package com.chipichipi.ProyectoOfipensiones.controladores;


import java.util.Random;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chipichipi.ProyectoOfipensiones.servicios.FacturaServicio;

@Controller
@RequestMapping("/facturas")
public class ControladorFacturacion {

    @Autowired
    private FacturaServicio facturaServicio;


    @GetMapping("/{rol}/{id}")
    public String mostrarFacturasPorRol(
            @PathVariable("rol") String rol, 
            @PathVariable("id") String id, 
            Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            String role = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/role");
            String ids = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/id");


            
            if(role.equals(rol) && ids.equals(id)){
                int ID = Integer.parseInt(id);
                
                if(rol.equals("ResponsableEconomico")){
                    
                    model.addAttribute("facturas", facturaServicio.darFacturasResponsableEconomico(ID));
                   
                }else if(rol.equals("GestorContable")){
                    model.addAttribute("facturas", facturaServicio.darFacturasGestorContable(ID));
        
                }else if(rol.equals("AdministradorOfipensiones")){
                    model.addAttribute("facturas", facturaServicio.darFacturasAdministrador());
                }
                
                return "facturass"; 
            }

    @GetMapping("/aplicarDescuento/{id}")
    public String aplicarDescuentoFactura(@PathVariable("id") String id, Model model) {
        
        Random r = new Random();

        System.out.println(id);

        facturaServicio.aplicarDescuento(Integer.parseInt(id), 123);

        return "facturas"; 
    }

        

        }
        return "noAutorizado";

    }
}
