/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sipre;

import com.mycompany.sipre.controlador.LoginController;
import com.mycompany.sipre.vista.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author jessica
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            //crear dialogo de login
            LoginController loginController = new LoginController();
            DialogoLogin dialogoLogin = new DialogoLogin(null, loginController);
            dialogoLogin.setVisible(true);
            
            if (dialogoLogin.isAutenticado()) {
                //crear ventana principal si se inicia sesion correctamente
                MainJFrame frame = new MainJFrame(dialogoLogin.getUsuarioAutenticado());
                frame.setVisible(true);
            } else {
                System.exit(0);
            }
        }); 
    }
}
