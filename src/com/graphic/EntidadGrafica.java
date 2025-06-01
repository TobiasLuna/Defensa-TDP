package com.graphic;

import com.graphic.observer.ObserverGrafico;
import javax.swing.JLabel;

public class EntidadGrafica extends JLabel implements ObserverGrafico {
    private static final long serialVersionUID = 1L;

    public EntidadGrafica(int x, int y, int ancho, int alto, String icono) { // TODO CAMBIAR ICONO POR SPRITE O SET DE
                                                                             // SPRITES
        super(icono);
        setBounds(x, y, ancho, alto);
    }

    public void update(double x, double y) {
        setLocation((int) x, (int) y);
    }

}
