package com.co.productosapi.service;

import com.co.productosapi.model.Response;
import com.co.productosapi.model.Usuarios;
import com.co.productosapi.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepository repository;

    /**
     * Metodo encargado de consultar todos los usuarios
     * @return
     */
    public List<Usuarios> findUsuarios() {
        return repository.findAll();
    }

    /**
     * Metodo encargado de consultar un usuario especifico por su ID
     * @param id
     * @return
     */
    public Usuarios findUsuario(Integer id) {
        return repository.findById(id).get();
    }

    /**
     * Metodo encargado de insertar un nuevo usuario
     * @param usuario
     * @return
     */
    public Response insertUsuario(Usuarios usuario) {
        Response response = new Response();

        if (validateData(usuario)) {
            Optional<Usuarios> usuarioExistente = repository.findByUsuario(usuario.getUsuario());

            if (usuarioExistente.isPresent()) {
                response.setCodigo(4);
                response.setDescripcion("El usuario ya existe");
            } else {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                usuario.setClave(passwordEncoder.encode(usuario.getClave()));
                repository.save(usuario);
                response.setCodigo(1);
                response.setDescripcion("Usuario registrado");
            }
        } else {
            response.setCodigo(3);
            response.setDescripcion("Datos incompletos");
        }
        return response;
    }

    /**
     * Metodo encargado de editar un usuario
     * @param usuario
     * @return
     */
    public Response updateUsuario(Usuarios usuario) {
        Response response = new Response();

        try {
            if (validateData(usuario)) {
                repository.findById(usuario.getIdUsuario()).get();
                repository.save(usuario);
                response.setCodigo(1);
                response.setDescripcion("Usuario actualizado");
            } else {
                response.setCodigo(3);
                response.setDescripcion("Datos incompletos");
            }
        } catch (Exception ex) {
            response.setCodigo(2);
            response.setDescripcion("Usuario no encontrado");
        }
        return response;
    }

    /**
     * Metodo encargado de eliminar un usuario
     * @param id
     * @return
     */
    public Response deleteUsuario(Integer id) {
        Response response = new Response();

        try {
            repository.findById(id).get();
            repository.deleteById(id);
            response.setCodigo(1);
            response.setDescripcion("Usuario eliminado");
        } catch (Exception ex) {
            response.setCodigo(2);
            response.setDescripcion("Usuario no encontrado");
        }
        return response;
    }

    /**
     * Metodo encargado de validar la data ingresada
     * @param usuario
     * @return
     */
    private Boolean validateData(Usuarios usuario) {
        return !usuario.getTipoDocumentoIdentidad().isEmpty() && !usuario.getNumDocumentoIdentidad().isEmpty()
                && !usuario.getUsuario().isEmpty() && !usuario.getClave().isEmpty();
    }
}
