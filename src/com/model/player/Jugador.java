package com.model.player;

import com.model.entities.BolaDeNieve;
import com.model.entities.Entidad;
import com.model.entities.poweup.PowerUp;
import com.view.PanelPantallaJuego;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Jugador extends Entidad {
    protected int vidas;
    protected float velocidad;
    protected Rectangle hitBox;
    protected int puntos;
    protected EnumDirecciones direccion;
    protected ArrayList<PowerUp> powerUps;
    protected boolean saltando;
    protected boolean invulnerable;

    protected volatile boolean pausar;

    public Jugador(int x, int y) {
        super(x, y);
        this.vidas = 3;
        this.velocidad = 0.0f;
        this.puntos = 0;
        this.hitBox = new Rectangle(x, y, 20, 20);
        this.direccion = EnumDirecciones.NONE;
        this.powerUps = new ArrayList<>();
        this.saltando = false;
        this.invulnerable = false;
        this.pausar = true; // El jugador se mueve hasta que se presione espacio
    }

    public void saltar() {
        if (!saltando) {
            velocidad = -10;
            saltando = true;
        }
    }

    public void girar(EnumDirecciones nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    public void detenerse() {
        velocidad = 0;
    }

    public boolean estaSaltando() {
        return saltando;
    }

    public boolean estaDetenido() {
        return velocidad == 0;
    }

    public void quitarVida() {
        if (!invulnerable) {
            vidas--;
            invulnerable = true;
        }
    }

    public int obtenerVidas() {
        return vidas;
    }

    public void agregarPuntaje(int puntaje) {
        puntos += puntaje;
    }

    public int obtenerPuntos() {
        return puntos;
    }

    public boolean sinVidas() {
        return vidas == 0;
    }

    public Rectangle obtenerHitbox() {
        return hitBox;
    }

    public void agregarPowerUp(PowerUp powerUp) {
        powerUps.add(powerUp);
    }

    public void aceptar(Entidad entidad) {
        // entidad.interactuar(this); TODO implementar lógica de interacción
    }

    public BolaDeNieve lanzarBolaDeNieve() {
        throw new RuntimeException(); // Implementar lógica para lanzar una bola de nieve
        // return new BolaDeNieve(hitBox.x, hitBox.y, direccion);
    }

    public void actualizarPosicion() {
        hitBox.x += velocidad;
        hitBox.y += velocidad;
    }

    // Llama este método desde un KeyListener en tu panel de juego
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                if(pausar) {
                    pausar = false;
                } else {
                    pausar = true; 
                }
                break;
            case KeyEvent.VK_A:
                hitBox.x -= 10; // Mueve a la izquierda
                break;
            case KeyEvent.VK_D:
                hitBox.x += 10; // Mueve a la derecha
                break;
        }
    }

    // Llama este método en un hilo separado para mover al jugador automáticamente
    public void moverser(PanelPantallaJuego panel) {

        while (pausar) {
            hitBox.y += 1;
            if (panel != null) {
                panel.repaint();
            }
            try {
                Thread.sleep(50); // Espera 50 ms entre movimientos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}