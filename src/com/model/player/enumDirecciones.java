package com.model.player;

public enum EnumDirecciones {
    NONE(0.0, 0.0),
    DOWN(0.0, 1.0),
    UP(0.0, -1.0),
    LEFT(-1.0, 0.0),
    RIGHT(1.0, 0.0);

    private final double x;
    private final double y;

    EnumDirecciones(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
