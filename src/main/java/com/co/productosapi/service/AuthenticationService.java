package com.co.productosapi.service;

import com.co.productosapi.model.Response;
import com.co.productosapi.model.Usuarios;
import com.co.productosapi.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UsuariosRepository repository;

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
                response.setCodigo(2);
                response.setDescripcion("El usuario ya existe");
            } else {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                usuario.setClave(passwordEncoder.encode(usuario.getClave()));
                repository.save(usuario);
                response.setCodigo(1);
                response.setDescripcion("Usuario registrado exitosamente");
            }
        } else {
            response.setCodigo(3);
            response.setDescripcion("Datos incompletos");
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
