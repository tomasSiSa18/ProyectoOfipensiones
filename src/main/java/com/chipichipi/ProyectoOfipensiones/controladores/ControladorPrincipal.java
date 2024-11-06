package com.chipichipi.ProyectoOfipensiones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.chipichipi.ProyectoOfipensiones.servicios.SendEmailService;

@Controller
public class ControladorPrincipal {

    @Autowired
    private SendEmailService sendEmailService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/health")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public String health() {
        return "OK";
    }

    @RequestMapping("/mandarCorreo")
    public String mandarCorreo() {

        sendEmailService.sendEmail("sierratomy@gmail.com", "Test", "Test Email");

        return "index";

    }
    
    
}
