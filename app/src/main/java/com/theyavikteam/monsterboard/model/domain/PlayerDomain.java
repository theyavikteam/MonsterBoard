package com.theyavikteam.monsterboard.model.domain;

public class PlayerDomain {

    private String playerSymbol;
    private int playerColor;
    private int score;

    public PlayerDomain(String playerSymbol, int playerColor) {
        this.playerSymbol = playerSymbol;
        this.playerColor = playerColor;
        this.score = 0;
    }

    public String getPlayerSymbol() {
        return playerSymbol;
    }

    public int getPlayerColor() {
        return playerColor;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
