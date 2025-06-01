package com.view;

import com.model.player.Jugador;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import javax.swing.JPanel;

public class PanelPantallaJuego extends JPanel {
    private Jugador jugador;

    public PanelPantallaJuego() {
        this.setLayout(null);
        this.setBackground(java.awt.Color.WHITE);
        setPreferredSize(new Dimension(600 * 2, 800 * 5));
        setFocusable(true); // Permite que el panel reciba foco
        requestFocusInWindow(); // Solicita el foco cuando se muestra
    }

    // Setter para el jugador
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    // Método para agregar un KeyListener fácilmente
    public void agregarKeyListener(KeyAdapter keyAdapter) {
        this.addKeyListener(keyAdapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (jugador != null) {
            Rectangle r = jugador.obtenerHitbox();
            g.fillRect(r.x, r.y, r.width, r.height);
            g.drawString("J", r.x + 5, r.y + 15); // Dibuja la letra J sobre el bloque
        }
    }
}