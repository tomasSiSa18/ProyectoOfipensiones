package com.chipichipi.ProyectoOfipensiones.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.chipichipi.ProyectoOfipensiones.servicios.UsuariosSerivicio;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

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



        if(usuariosSerivicio.MicroservicioValidadUsuario(id)){
            model.addAttribute("rol", rol);
            model.addAttribute("id", id);
           
            return "home";
        }else{
            return "noAutorizado";
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


    @GetMapping("reportes/{rol}/{id}/{fecha_inicio}/{fecha_fin}")
@ResponseBody
public Object obtenerReporte(
    @PathVariable("rol") String rol,
    @PathVariable("id") String id,
    @PathVariable("fecha_inicio") String fechaInicio,
    @PathVariable("fecha_fin") String fechaFin,
    @AuthenticationPrincipal OidcUser principal) {

    if (principal != null) {
        String role = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/role");
        String ids = (String) principal.getClaims().get("dev-to20bjeck8hvwovg.us.auth0.com/id");

        if (role.equals(rol) && ids.equals(id)) {
            if (rol.equals("AdministradorOfipensiones") && usuariosSerivicio.MicroservicioValidadUsuario(id)) {
                // Construir la URL del microservicio
                String url = String.format(
                    "http://34.172.233.174:8080/Ofipensiones/api/reportes/generar_reporte/?fecha_inicio=%s&fecha_fin=%s",
                    fechaInicio, fechaFin);

                // Consumir el microservicio
                Object response = restTemplate.getForObject(url, Object.class);

                // Devolver el JSON del microservicio
                return response;
            } else {
                // Respuesta si no está autorizado
                return new ResponseEntity<>("No autorizado", HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>("Credenciales no válidas", HttpStatus.FORBIDDEN);
        }
    }
    return new ResponseEntity<>("No autenticado", HttpStatus.UNAUTHORIZED);
}




}



