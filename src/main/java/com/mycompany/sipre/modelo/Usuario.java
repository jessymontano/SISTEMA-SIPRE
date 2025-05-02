/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sipre.modelo;


/**
 *
 * @author jessica
 */
public class Usuario {
    private int id;
    private String nombreUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String rol;
    
    public Usuario(int id, String nombreUsuario, String nombre, String apellido, String email, String contrasena, String rol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.rol = rol;
    }
    
    public Usuario() {
        
    }
    
    public int getId() {
        return id;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
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
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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
