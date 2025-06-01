package com.model.entities;

import com.graphic.observer.ObserverGrafico;

public interface Observable {
    public void publish();

    public void subscribe(ObserverGrafico observer);
}
