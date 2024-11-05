package com.chipichipi.ProyectoOfipensiones.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.ui.Model;

@Controller
public class ControladorPrincipal {

    @RequestMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            String role = (String) principal.getClaims()
                .get("https://dev-to20bjeck8hvwovg.us.auth0.com/app_metadata.role");

            
            if ("Gestor Contable de Institucion".equals(role)) {
                return "home";
            } else {
                
                return "error"; 
            }
        }
        
        
        return "index";
    }

    @GetMapping("/health")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public String health() {
        return "OK";
    }
}


/*@RequestMapping("/")
public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
    if (principal != null) {
        // Asegúrate de acceder a "app_metadata" como un mapa y luego obtén el rol
        Map<String, Object> appMetadata = (Map<String, Object>) principal.getClaims().get("https://dev-to20bjeck8hvwovg.us.auth0.com/app_metadata");
        
        if (appMetadata != null) {
            String role = (String) appMetadata.get("role");
            
            if ("Gestor Contable de Institucion".equals(role)) {
                model.addAttribute("user", principal.getFullName());
                return "home";
            } else {
                return "error";
            }
        }
    }
    
    return "index";
}
 */