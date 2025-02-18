/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sipre;

import com.mycompany.sipre.vista.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author jessica
 */
public class Main {
    public static void main(String[] args) {
        //SwingUtilities.invokeLater(() -> new MainJFrame().setVisible(true));
        MainJFrame frame = new MainJFrame();
        DialogoLogin login = new DialogoLogin(frame);
        
        login.setVisible(true);
    }
}
