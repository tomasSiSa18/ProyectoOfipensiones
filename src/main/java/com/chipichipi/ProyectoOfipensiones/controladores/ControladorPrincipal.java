package com.chipichipi.ProyectoOfipensiones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.data.mongodb.core.MongoTemplate;
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

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/health")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public String health() {

         try {
            // Execute a simple MongoDB operation to check health
            mongoTemplate.executeCommand("{ ping: 1 }");
            return "OK";

        } catch (Exception e) {

            sendEmailService.sendEmail("sierratomy@gmail.com", "La base de datos actual en el sistema no está con vida.", "ATENCION BASE DE DATOS");
            return "Naaaa";
        }

    }

    @RequestMapping("/mandarCorreo")
    public String mandarCorreo() {

        sendEmailService.sendEmail("sierratomy@gmail.com", "Test", "Test Email");

        return "index";

    }
    
    
}
