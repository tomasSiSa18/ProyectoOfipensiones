package com.chipichipi.ProyectoOfipensiones.controladores; 


import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chipichipi.ProyectoOfipensiones.modelo.Factura;
import com.chipichipi.ProyectoOfipensiones.servicios.UsuariosSerivicio;

@Controller
@RequestMapping("/facturas")
public class ControladorFacturacion {

   
    @Autowired 
    private UsuariosSerivicio usuariosSerivicio;


    @GetMapping("/{rol}/{id}")
    public String mostrarFacturasPorRol(
            @PathVariable("rol") String rol, 
            @PathVariable("id") String id, 
            Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            String role = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/role");
            String ids = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/id");


            
            if(role.equals(rol) && ids.equals(id)  && usuariosSerivicio.MicroservicioValidadUsuario(id)){
                int ID = Integer.parseInt(id);
                
                if(rol.equals("ResponsableEconomico")){
                    
                   // model.addAttribute("facturas", facturaServicio.darFacturasResponsableEconomico(ID));
                   
                }else if(rol.equals("GestorContable")){
                    //model.addAttribute("facturas", facturaServicio.darFacturasGestorContable(ID));
        
                }else if(rol.equals("AdministradorOfipensiones")){
                    //model.addAttribute("facturas", facturaServicio.darFacturasAdministrador());
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

        if (principal != null) {
            String role = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/role");
            String ids = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/id");
            
            if(role.equals(rol) && ids.equals(id)){
        
                if(rol.equals("AdministradorOfipensiones")  && usuariosSerivicio.MicroservicioValidadUsuario(id)){

                    // List<Factura> facturas = (List<Factura>) facturaServicio.darFacturasAdministrador();
                    //model.addAttribute("facturas", facturas);
                    //model.addAttribute("factura", new Factura());  
                    //model.addAttribute("rol", rol);
                    //model.addAttribute("id", id);
                    return "descuentoForm";


                }else{
                    return "noAutorizado";
                }
            

        }
        else{
            return "noAutorizado";
        }
            
    }
    return "noAutorizado";
}


@PostMapping("/{rol}/{id}/aplicarDescuento")
    public String aplicarDescuento(@PathVariable("rol") String rol,
                                   @PathVariable("id") String id,
                                   @RequestParam("facturaafectada") int idFactura,
                                   @ModelAttribute("factura") Factura factura,
                                   @AuthenticationPrincipal OidcUser principal) {
        
        if (principal != null) {
            String role = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/role");
            String ids = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/id");
                                        
            if(role.equals(rol) && ids.equals(id)  && usuariosSerivicio.MicroservicioValidadUsuario(id)){
                //facturaServicio.aplicarDescuento(idFactura, factura.getValor());
                return "redirect:/home";
            }else{
                return "noAutorizado";
            }

        }else{
            return "noAutorizado";
        }

        

        
       
    }








}
