package com.co.productosapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String tipoDocumentoIdentidad;
    private String numDocumentoIdentidad;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String email;
    private String usuario;
    private String clave;

    public Usuarios(Integer idUsuario, String tipoDocumentoIdentidad, String numDocumentoIdentidad, String nombres, String apellidos, String telefono, String direccion, String email, String usuario, String clave) {
        this.idUsuario = idUsuario;
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
        this.numDocumentoIdentidad = numDocumentoIdentidad;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Usuarios() {
        super();
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoDocumentoIdentidad() {
        return tipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad) {
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
    }

    public String getNumDocumentoIdentidad() {
        return numDocumentoIdentidad;
    }

    public void setNumDocumentoIdentidad(String numDocumentoIdentidad) {
        this.numDocumentoIdentidad = numDocumentoIdentidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
