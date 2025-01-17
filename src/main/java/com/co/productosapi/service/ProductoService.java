package com.co.productosapi.service;

import com.co.productosapi.dto.ProductoDTO;
import com.co.productosapi.dto.ResponseDTO;
import com.co.productosapi.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    /**
     * Metodo encargado de consultar todos los productos
     * @return
     */
    public List<ProductoDTO> findProductos() {
        return repository.findAll();
    }

    /**
     * Metodo encargado de insertar un nuevo producto
     * @param producto
     */
    public ResponseDTO insertProducto(ProductoDTO producto) {
        ResponseDTO response = new ResponseDTO();

        if(validateData(producto)) {
            repository.save(producto);
            response.setCodigo(1);
            response.setDescripcion("Producto registrado");
        } else {
            response.setCodigo(4);
            response.setDescripcion("Datos incompletos");
        }
        return response;
    }

    /**
     * Metodo que revisa si los datos son validos
     * @param producto
     * @return
     */
    private Boolean validateData(ProductoDTO producto) {
        return !producto.getNombre().isEmpty() && producto.getPrecio() != 0;
    }
}
