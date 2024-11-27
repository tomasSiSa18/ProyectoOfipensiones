package com.chipichipi.ProyectoOfipensiones.controladores;

import org.springframework.web.bind.annotation.RequestMapping;

public class ControladorPrincipal {
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
}
