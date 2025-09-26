package com.co.productosapi.controller;

import com.co.productosapi.model.Producto;
import com.co.productosapi.model.Response;
import com.co.productosapi.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/productos")
public class ProductoRest {

    @Autowired
    private ProductoService services;

    @GetMapping("/all")
    public List<Producto> listarProductos() {
        return services.findProductos();
    }

    @GetMapping("/find/{id}")
    public Producto buscarProducto(@PathVariable Integer id) {
        return services.findProducto(id);
    }

    @PostMapping("/new")
    public ResponseEntity<Response> crearProducto(@RequestBody Producto producto) {
        Response response = new Response();
        response = services.insertProducto(producto);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<Response> editarProducto(@RequestBody Producto producto) {
        Response response = new Response();
        response = services.updateProducto(producto);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> eliminarProducto(@PathVariable Integer id) {
        Response response = new Response();
        response = services.deleteProducto(id);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
}
