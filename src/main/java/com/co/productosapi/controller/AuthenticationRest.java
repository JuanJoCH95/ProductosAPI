package com.co.productosapi.controller;

import com.co.productosapi.model.Response;
import com.co.productosapi.model.Usuarios;
import com.co.productosapi.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/auth")
public class AuthenticationRest {

    @Autowired
    private AuthenticationService services;

    @GetMapping("/login")
    public String login() {
        return "Login Exitoso";
    }

    @PostMapping("/register")
    public ResponseEntity<Response> registro(@RequestBody Usuarios usuario) {
        Response response = new Response();
        response = services.insertUsuario(usuario);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
}
