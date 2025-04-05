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

    private String nombre;

    private String apellido;

    private String email;
    private String contrasena;

    private String rol;
    
    public Usuario( String nombre, String apellido, String email, String contrasena, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.rol = rol;
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
    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
}
