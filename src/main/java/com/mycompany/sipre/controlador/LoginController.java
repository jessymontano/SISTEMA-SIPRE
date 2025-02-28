/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sipre.controlador;

import com.mycompany.sipre.modelo.Usuario;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jessica
 */
public class LoginController {
    //private Map<String, Usuario> usuarios;
    private UsuarioDAO usuarios;
    public LoginController() {
        //   usuarios = new HashMap<>();
        usuarios = new UsuarioDAO();
        //usuarios.put("prueba", new Usuario("prueba", "12345", "Jessica Montaño", "C. aaaaa Col. bbbbb #xyz C.P: #####", LocalDate.of(2003, 1, 13), "F", "prueba@ejemplo.com", "usuario"));
    }

    public boolean autenticar(String nombreUsuario, String contrasena) {
        return usuarios.autenticar(nombreUsuario, contrasena);
    }

    public Usuario getUsuario(String nombreUsuario) {
        return usuarios.getUsuario(nombreUsuario);
    }
}

