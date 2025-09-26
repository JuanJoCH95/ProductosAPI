package com.co.productosapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/auth")
public class AuthenticationRest {

    @GetMapping("/login")
    public String login() {
        return "Login Exitoso";
    }

    @PostMapping("/register")
    public String registro(@RequestBody String usuario) {
        return "Usuario: " + usuario + " registrado exitosamente";
    }
}
