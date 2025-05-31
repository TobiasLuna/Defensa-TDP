package com.app;
import com.model.nivel.Nivel;
import com.model.nivel.mode.ModoDeJuego;
import com.model.player.*;
import com.graphic.factory.*;
public class Juego {
	protected Ranking ranking;
	protected DominioDeAplicacion domain;
	protected ModoDeJuego gamemode;
	protected Nivel nivel;
	
	public static void main(String[] args)
	{
		
	}
	public void showRanking()
	{
		
	}
	public void pausar()
	{
		
	}
	
	
	public void setDomain(DominioDeAplicacion domain)
	{
		this.domain = domain;
	}
	public void setGameMode(ModoDeJuego gamemode)
	{
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
