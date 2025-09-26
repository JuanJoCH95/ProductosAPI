package com.co.productosapi.service;

import com.co.productosapi.model.Producto;
import com.co.productosapi.model.Response;
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
    public List<Producto> findProductos() {
        return repository.findAll();
    }

    /**
     * Metodo encargado de consultar un producto especifico por su ID
     * @param id
     * @return
     */
    public Producto findProducto(Integer id) {
        return repository.findById(id).get();
    }

    /**
     * Metodo encargado de insertar un nuevo producto
     * @param producto
     */
    public Response insertProducto(Producto producto) {
        Response response = new Response();

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
    public Response updateProducto(Producto producto) {
        Response response = new Response();

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
    public Response deleteProducto(Integer id) {
        Response response = new Response();

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
    private Boolean validateData(Producto producto) {
        return !producto.getNombre().isEmpty() && producto.getPrecio() != 0;
    }
}
