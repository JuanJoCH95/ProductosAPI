package com.co.productosapi.service;

import com.co.productosapi.model.Proveedor;
import com.co.productosapi.model.Response;
import com.co.productosapi.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository repository;

    public List<Proveedor> findProveedores() {
        return repository.findAll();
    }

    public Proveedor findProveedor(Integer id) {
        return repository.findById(id).get();
    }

    public Response insertProveedor(Proveedor proveedor) {
        Response response = new Response();

        if (validateData(proveedor)) {
            repository.save(proveedor);
            response.setCodigo(1);
            response.setDescripcion("Proveedor registrado");
        } else {
            response.setCodigo(3);
            response.setDescripcion("Datos incompletos");
        }
        return response;
    }

    public Response updateProveedor(Proveedor proveedor) {
        Response response = new Response();

        try {
            if (validateData(proveedor)) {
                repository.findById(proveedor.getId()).get();
                repository.save(proveedor);
                response.setCodigo(1);
                response.setDescripcion("Proveedor actualizado");
            } else {
                response.setCodigo(3);
                response.setDescripcion("Datos incompletos");
            }
        } catch (Exception ex) {
            response.setCodigo(2);
            response.setDescripcion("Proveedor no encontrado");
        }
        return response;
    }

    public Response deleteProveedor(Integer id) {
        Response response = new Response();

        try {
            repository.findById(id).get();
            repository.deleteById(id);
            response.setCodigo(1);
            response.setDescripcion("Proveedor eliminado");
        } catch (Exception ex) {
            response.setCodigo(2);
            response.setDescripcion("Proveedor no encontrado");
        }
        return response;
    }

    private Boolean validateData(Proveedor proveedor) {
        return proveedor.getNombre() != null && !proveedor.getNombre().isEmpty()
                && proveedor.getCiudad() != null && !proveedor.getCiudad().isEmpty()
                && proveedor.getTelefono() != null && !proveedor.getTelefono().isEmpty()
                && proveedor.getEmail() != null && !proveedor.getEmail().isEmpty();
    }
}