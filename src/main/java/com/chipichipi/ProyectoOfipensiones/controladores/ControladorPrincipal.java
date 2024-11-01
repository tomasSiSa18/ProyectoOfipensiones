package com.chipichipi.ProyectoOfipensiones.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.qos.logback.core.model.Model;

@Controller
public class ControladorPrincipal {

    @RequestMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        return "index";
    }

    @RequestMapping("/login/oauth2/code/okta")
    public String login() {
        return "login";
    }

    @GetMapping("/health")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public String health() {
        return "OK";
    }
    
    
}
