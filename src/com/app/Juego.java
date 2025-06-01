package com.app;

import com.graphic.factory.*;
import com.model.nivel.Nivel;
import com.model.nivel.mode.ModoDeJuego;
import com.model.player.*;
import com.view.PanelPantallaJuego;
import com.view.VentanaJuego;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Juego {
	protected Ranking ranking;
	protected DominioDeAplicacion domain;
	protected ModoDeJuego gamemode;
	protected Nivel nivel;
	protected JFrame ventanaJuego;

	public Juego() {
		ventanaJuego = new VentanaJuego();
		PanelPantallaJuego panelJuego = new PanelPantallaJuego();
		JScrollPane scrollPane = new JScrollPane(panelJuego);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		Nivel nivel = new Nivel(new DominioDeAplicacion(), panelJuego);
		ventanaJuego.setContentPane(scrollPane);
		ventanaJuego.revalidate();
		ventanaJuego.repaint();
		ventanaJuego.setVisible(true);           // Asegúrate de que la ventana esté visible
    	panelJuego.requestFocusInWindow();
	}

	public static void main(String[] args) {
		Juego juego = new Juego();
	}

	public void showRanking() {

	}

	public void pausar() {

	}

	public void setDomain(DominioDeAplicacion domain) {
		this.domain = domain;
	}

	public void setGameMode(ModoDeJuego gamemode) {
		this.gamemode = gamemode;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public ModoDeJuego getGameMode() {
		return this.gamemode;
	}

	public DominioDeAplicacion getDomain() {
		return domain;
	}

}
