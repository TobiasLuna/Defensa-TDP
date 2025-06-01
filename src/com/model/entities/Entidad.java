package com.model.entities;

import com.event.interaction.ResultadoInteraccion;
import com.graphic.observer.ObserverGrafico;
import com.model.player.Jugador;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public abstract class Entidad implements Observable {
    protected Rectangle hitBox;
    protected boolean alive;
    private List<ObserverGrafico> subscribed;

    public Entidad(float x, float y) {
        this.hitBox = new Rectangle((int) x, (int) y, 20, 20); // TODO usar float para ancho y alto
        this.alive = true;
        this.subscribed = new ArrayList<>();
    }

    public List<ResultadoInteraccion> interact(Jugador jugador) {
        return new ArrayList<>(); // TODO COMPLETAR
    }

    public void publish() {
        for (ObserverGrafico observer : subscribed) {
            observer.update(this.hitBox.getX(), this.hitBox.getY());
        }
    }

    public void subscribe(ObserverGrafico observer) {
        subscribed.add(observer);
    }

}