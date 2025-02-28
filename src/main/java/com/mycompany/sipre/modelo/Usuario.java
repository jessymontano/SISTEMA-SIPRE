/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sipre.modelo;

import java.time.LocalDate;

/**
 *
 * @author jessica
 */
public class Usuario {
    private String usuario;

    private String nombre;

    private String apellido;

    private String email;
    private String contrasena;

    private String rol;
    
    public Usuario(String usuario, String nombre, String apellido, String email, String contrasena, String rol) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.rol = rol;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public boolean verificarContrasena(String contrasenaIngresada) {
        return this.contrasena.equals(contrasenaIngresada);
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getContrasena() {
        return contrasena;
    }
    
    public String getRol() {
        return rol;
    }
}
