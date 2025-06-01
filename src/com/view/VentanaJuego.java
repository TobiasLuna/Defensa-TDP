package com.view;

import javax.swing.JFrame;

public class VentanaJuego extends JFrame {
    public VentanaJuego() {
        this.setSize(800, 600);
        // this.setContentPane(new PanelPantallaPrincipal());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Esqui atómico");
        this.setVisible(true);
    }
}
