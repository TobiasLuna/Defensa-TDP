package com.model.player;

public class RankingEntrada {
    private String name;
    private int score;
    private String gamemode;

    public RankingEntrada(String name, int score, String gamemode) {
        this.name = name;
        this.score = score;
        this.gamemode = gamemode;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getGameMode() {
        return gamemode;
    }
}