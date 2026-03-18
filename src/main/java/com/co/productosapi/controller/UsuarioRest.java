package com.co.productosapi.controller;

import com.co.productosapi.model.Response;
import com.co.productosapi.model.Usuarios;
import com.co.productosapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/usuarios")
public class UsuarioRest {

    @Autowired
    private UsuarioService services;

    @GetMapping("/all")
    public List<Usuarios> listarUsuarios() {
        return services.findUsuarios();
    }

    @GetMapping("/find/{id}")
    public Usuarios buscarUsuarios(@PathVariable Integer id) {
        return services.findUsuario(id);
    }

    @PostMapping("/new")
    public ResponseEntity<Response> crearUsuario(@RequestBody Usuarios usuario) {
        Response response = new Response();
        response = services.insertUsuario(usuario);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<Response> editarUsuario(@RequestBody Usuarios usuario) {
        Response response = new Response();
        response = services.updateUsuario(usuario);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> eliminarUsuario(@PathVariable Integer id) {
        Response response = new Response();
        response = services.deleteUsuario(id);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
}
