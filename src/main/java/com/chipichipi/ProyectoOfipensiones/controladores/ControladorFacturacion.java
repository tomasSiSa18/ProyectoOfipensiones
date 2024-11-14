package com.chipichipi.ProyectoOfipensiones.controladores; 

import java.util.Collection;
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

        }
        return "noAutorizado";

    }

    @GetMapping("/{rol}/{id}/aplicarDescuento")
    public String aplicarDescuentoFactura( @PathVariable("rol") String rol, 
    @PathVariable("id") String id, 
    Model model, @AuthenticationPrincipal OidcUser principal) {
    System.out.println("asefjlafjlkasjdf");

        if (principal != null) {
            String role = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/role");
            String ids = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/id");


            
            if(role.equals(rol) && ids.equals(id)){
        
            model.addAttribute("facturas", facturaServicio.darFacturasAdministrador());
            return "decuentoForm";
            
        }
            
    }
    return "noAutorizado";
}
}
