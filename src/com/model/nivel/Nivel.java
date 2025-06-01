package com.model.nivel;

import com.graphic.factory.DominioDeAplicacion;
import com.model.entities.BolaDeNieve;
import com.model.entities.Entidad;
import com.model.player.Jugador;
import com.service.DetectorColisiones;
import com.util.NivelParser;
import com.view.PanelPantallaJuego;
import java.util.List;

public class Nivel {
    private static final float METROS_PARA_YETI = 1000;
    protected List<Entidad> entidades;
    protected Jugador jugador;
    protected DominioDeAplicacion dominioDeAplicacion;
    protected DetectorColisiones detectorColisiones;
    protected List<BolaDeNieve> bolasDeNieve;

    public Nivel(DominioDeAplicacion dominioDeAplicacion, PanelPantallaJuego panelJuego) {
        NivelParser parser = new NivelParser(dominioDeAplicacion, panelJuego);
        parser.parseNivel("../src/assets/levels/level_1.txt"); 
        this.jugador = parser.getJugador(); 
        panelJuego.setJugador(jugador); 
        panelJuego.agregarKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                jugador.keyPressed(e); // Mueve el jugador según la tecla
                panelJuego.repaint(); // Redibuja el panel para mostrar el cambio
            }
        });
        if (jugador != null) {
            new Thread(() -> jugador.moverser(panelJuego)).start();
        }
    }
}