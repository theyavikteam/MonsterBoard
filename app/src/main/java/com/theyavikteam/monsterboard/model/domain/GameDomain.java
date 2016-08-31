package com.theyavikteam.monsterboard.model.domain;

import java.util.Random;

public class GameDomain {
    private PlayerDomain playerO;
    private PlayerDomain playerX;
    private int turn;
    private boolean movementMade;
    private String lastPlayerSymbol;

    public GameDomain(PlayerDomain playerO, PlayerDomain playerX) {
        this.playerO = playerO;
        this.playerX = playerX;
        movementMade = false;
        turn = new Random().nextInt(1);
    }

    public PlayerDomain getPlayerO() {
        return playerO;
    }

    public PlayerDomain getPlayerX() {
        return playerX;
    }

    public int getTurn() {
        return turn;
    }

    public void makeMove(){
        movementMade = true;
        lastPlayerSymbol = getCurrentPlayer().getPlayerSymbol();
    }

    public String getLastPlayerSymbol() {
        return lastPlayerSymbol;
    }

    public void changeTurn() {
        if (this.turn == 0) {
            this.turn = 1;
        } else {
            this.turn = 0;
        }
        movementMade = false;
    }

    public boolean isMovementMade() {
        return movementMade;
    }

    public PlayerDomain getCurrentPlayer() {
        if (turn == 0) {
            return playerO;
        } else {
            return playerX;
        }
    }
    public PlayerDomain getOtherPlayer() {
        if (turn == 0) {
            return playerX;
        } else {
            return playerO;
        }
    }
}
