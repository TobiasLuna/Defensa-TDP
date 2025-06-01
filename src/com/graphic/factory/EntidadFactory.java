package com.graphic.factory;

import com.graphic.EntidadGrafica;
import com.model.entities.BanderaCuadros;
import com.model.entities.BanderaNegra;
import com.model.entities.Entidad;
import com.model.entities.animal.Gato;
import com.model.entities.animal.Lobo;
import com.model.entities.animal.Perro;
import com.model.entities.obstacle.PosteDeTelesillas;
import com.model.entities.obstacle.Roca;
import com.model.entities.obstacle.mogul.MIntermedio;
import com.model.entities.obstacle.mogul.MLeve;
import com.model.entities.obstacle.mogul.MSevero;
import com.model.entities.obstacle.skier.EAdiestrado;
import com.model.entities.obstacle.skier.ETorpe;
import com.model.entities.platform.PlataformaDorada;
import com.model.entities.platform.PlataformaMulticolor;
import com.model.entities.poweup.BanderaAmarilla;
import com.model.entities.poweup.BanderaRoja;
import com.model.entities.poweup.BanderaVerde;
import com.model.entities.tree.PinoAlto;
import com.model.entities.tree.PinoBajo;
import com.model.entities.tree.PinoMuerto;
import com.model.player.Jugador;
import com.view.PanelPantallaJuego;

public class EntidadFactory {
    private DominioDeAplicacion dominioDeAplicacion; // TODO USAR
    private PanelPantallaJuego panelJuego;

    public EntidadFactory(DominioDeAplicacion dominioDeAplicacion, PanelPantallaJuego panelJuego) {
        this.dominioDeAplicacion = dominioDeAplicacion;
        this.panelJuego = panelJuego;
    }

    public Entidad crearEntidad(char tipo, int x, int y) {
        Entidad entidad;
        switch (tipo) {
            case 'J':
                entidad = new Jugador(x, y);
                break;
            case 'D':
                entidad = new Perro(x, y);
                break;
            case 'C':
                entidad = new Gato(x, y);
                break;
            case 'W':
                entidad = new Lobo(x, y);
                break;
            case 'p':
                entidad = new PinoBajo(x, y);
                break;
            case 'P':
                entidad = new PinoAlto(x, y);
                break;
            case 'X':
                entidad = new PinoMuerto(x, y);
                break;
            case 'G':
                entidad = new BanderaVerde(x, y);
                break;
            case 'Y':
                entidad = new BanderaAmarilla(x, y);
                break;
            case 'R':
                entidad = new BanderaRoja(x, y);
                break;
            case 'O':
                entidad = new Roca(x, y);
                break;
            case 'n':
                entidad = new MLeve(x, y);
                break;
            case 'M':
                entidad = new MSevero(x, y);
                break;
            case 'm':
                entidad = new MIntermedio(x, y);
                break;
            case 'T':
                entidad = new PosteDeTelesillas(x, y);
                break;
            case 'e':
                entidad = new ETorpe(x, y);
                break;
            case 'E':
                entidad = new EAdiestrado(x, y);
                break;
            case 'v':
                entidad = new PlataformaMulticolor(x, y);
                break;
            case 'V':
                entidad = new PlataformaDorada(x, y);
                break;
            case '2':
                entidad = new BanderaNegra(x, y);
                break;
            case '4':
                entidad = new BanderaCuadros(x, y);
                break;
            default:
                throw new IllegalArgumentException("Símbolo desconocido: " + tipo);
        }
        String tipoStr = String.valueOf(tipo);
        if (tipo == 'J') {
            tipoStr = "😎";
        }
        EntidadGrafica entidadGrafica = new EntidadGrafica(x, y, 50, 50, tipoStr);
        entidad.subscribe(entidadGrafica);
        panelJuego.add(entidadGrafica);
        return entidad;

    }
}