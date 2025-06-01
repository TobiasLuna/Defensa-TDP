package com.util;

import com.graphic.factory.DominioDeAplicacion;
import com.graphic.factory.EntidadFactory;
import com.model.entities.Entidad;
import com.model.player.Jugador;
import com.view.PanelPantallaJuego;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NivelParser {
    private EntidadFactory entidadFactory;
    private Jugador jugador;

    public NivelParser(DominioDeAplicacion dominioDeAplicacion, PanelPantallaJuego panelJuego) {
        this.entidadFactory = new EntidadFactory(dominioDeAplicacion, panelJuego);
    }

    public List<Entidad> parseNivel(String filePath) {
        List<Entidad> entidades = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {
            int i;
            int x = 0;
            int y = 0;
            while ((i = reader.read()) != -1) {
                if (i == '\n') {
                    x = 0;
                    y++;
                    continue;
                }
                x++;
                char byteFromMap = (char) i;
                if (byteFromMap != '-') {
                    Entidad entidad = entidadFactory.crearEntidad(byteFromMap, x * 2, y * 5);
                    entidades.add(entidad);
                    if (entidad instanceof Jugador && this.jugador == null) {
                        this.jugador = (Jugador) entidad;
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entidades;
    }
    public Jugador getJugador() {
        return jugador;
    }
}