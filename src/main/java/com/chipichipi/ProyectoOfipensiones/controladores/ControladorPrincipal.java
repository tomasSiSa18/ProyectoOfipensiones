package com.chipichipi.ProyectoOfipensiones.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ControladorPrincipal {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/health-check")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public String healthCheck() {
        return "Ok";
    }
    
    
}
