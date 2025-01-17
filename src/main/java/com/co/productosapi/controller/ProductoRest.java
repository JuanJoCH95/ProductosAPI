package com.co.productosapi.controller;

import com.co.productosapi.dto.ProductoDTO;
import com.co.productosapi.dto.ResponseDTO;
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
    public List<ProductoDTO> listarProductos() {
        return services.findProductos();
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> crearProducto(@RequestBody ProductoDTO producto) {
        ResponseDTO response = new ResponseDTO();
        response = services.insertProducto(producto);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
}
