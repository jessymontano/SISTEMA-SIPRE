/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sipre;

import com.mycompany.sipre.controlador.UsuarioController;
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
            UsuarioController usuarioController = new UsuarioController();
            DialogoLogin dialogoLogin = new DialogoLogin(null, usuarioController);
            dialogoLogin.setVisible(true);
            
            if (dialogoLogin.isAutenticado()) {
                switch (dialogoLogin.getRol()) {
                    case "administrador":
                        AdminJFrame frameAdmin = new AdminJFrame(dialogoLogin.getUsuarioAutenticado());
                        frameAdmin.setVisible(true);
                        break;
                    case "registrador":
                        MainJFrame frameRegistrador = new MainJFrame(dialogoLogin.getUsuarioAutenticado());
                        frameRegistrador.setVisible(true);
                        break;
                    case "consultador":
                        ConsultorJFrame frameConsultador = new ConsultorJFrame(dialogoLogin.getUsuarioAutenticado());
                        frameConsultador.setVisible(true);
                        break;
                }
                
            } else {
                System.exit(0);
            }
        }); 
    }
}
