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
    private String contrasena;
    private String nombreCompleto;
    private String domicilio;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String correo;
    private String rol;
    
    public Usuario(String usuario, String contrasena, String nombreCompleto, String domicilio, LocalDate fechaNacimiento, String sexo, String correo, String rol) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.correo = correo;
        this.rol = rol;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public boolean verificarContrasena(String contrasenaIngresada) {
        return this.contrasena.equals(contrasenaIngresada);
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public String getDomicilio() {
        return domicilio;
    }
    
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public String getRol() {
        return rol;
    }
}
