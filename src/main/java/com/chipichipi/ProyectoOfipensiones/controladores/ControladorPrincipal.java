package com.chipichipi.ProyectoOfipensiones.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.chipichipi.ProyectoOfipensiones.modelo.Usuario;
import com.chipichipi.ProyectoOfipensiones.servicios.UsuariosSerivicio;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.chipichipi.ProyectoOfipensiones.config.AppConfig;

@Controller
public class ControladorPrincipal {
    @Autowired
    UsuariosSerivicio usuariosSerivicio;
    @Autowired RestTemplate restTemplate;

    @RequestMapping("/")
public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
    
    return "index"; 
}

@RequestMapping("/home")
public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
    if (principal != null) {
        String rol = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/role");
        String id = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/id");

        model.addAttribute("rol", rol);
        model.addAttribute("id", id);
        String microservicioUrl = "http://localhost:8081/api/usuarios/" + id;
        Usuario usuario = restTemplate.getForObject(microservicioUrl, Usuario.class);
        System.out.println(usuario.getId());
        System.out.println(usuario.getNombre());
        return "home";
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
