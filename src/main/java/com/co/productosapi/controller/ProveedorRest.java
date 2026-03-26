package com.co.productosapi.controller;

import com.co.productosapi.model.Proveedor;
import com.co.productosapi.model.Response;
import com.co.productosapi.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/proveedores")
public class ProveedorRest {

    @Autowired
    private ProveedorService services;

    @GetMapping("/all")
    public List<Proveedor> listarProveedores() {
        return services.findProveedores();
    }

    @GetMapping("/find/{id}")
    public Proveedor buscarProveedor(@PathVariable Integer id) {
        return services.findProveedor(id);
    }

    @PostMapping("/new")
    public ResponseEntity<Response> crearProveedor(@RequestBody Proveedor proveedor) {
        Response response = new Response();
        response = services.insertProveedor(proveedor);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<Response> editarProveedor(@RequestBody Proveedor proveedor) {
        Response response = new Response();
        response = services.updateProveedor(proveedor);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> eliminarProveedor(@PathVariable Integer id) {
        Response response = new Response();
        response = services.deleteProveedor(id);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
}