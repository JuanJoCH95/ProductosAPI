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
            response.setCodigo(3);
            response.setDescripcion("Datos incompletos");
        }
        return response;
    }

    /**
     * Metodo encargado de editar un producto
     * @param producto
     * @return
     */
    public ResponseDTO updateProducto(ProductoDTO producto) {
        ResponseDTO response = new ResponseDTO();

        try {
            if(validateData(producto)) {
                repository.findById(producto.getIdProducto()).get();
                repository.save(producto);
                response.setCodigo(1);
                response.setDescripcion("Producto actualizado");
            } else {
                response.setCodigo(3);
                response.setDescripcion("Datos incompletos");
            }
        } catch (Exception ex) {
            response.setCodigo(2);
            response.setDescripcion("Producto no encontrado");
        }
        return response;
    }

    /**
     * Metodo encargado de eliminar un producto
     * @param id
     * @return
     */
    public ResponseDTO deleteProducto(Integer id) {
        ResponseDTO response = new ResponseDTO();

        try {
            repository.findById(id).get();
            repository.deleteById(id);
            response.setCodigo(1);
            response.setDescripcion("Producto eliminado");
        } catch (Exception ex) {
            response.setCodigo(2);
            response.setDescripcion("Producto no encontrado");
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
