package com.theyavikteam.monsterboard.model.domain;

public class PlayerDomain {

    private String playerSymbol;
    private int playerColor;

    public PlayerDomain(String playerSymbol, int playerColor) {
        this.playerSymbol = playerSymbol;
        this.playerColor = playerColor;
    }

    public String getPlayerSymbol() {
        return playerSymbol;
    }

    public int getPlayerColor() {
        return playerColor;
    }
}
