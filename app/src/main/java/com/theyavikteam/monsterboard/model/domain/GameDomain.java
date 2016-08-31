package com.theyavikteam.monsterboard.model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameDomain {
    private PlayerDomain playerO;
    private PlayerDomain playerX;
    private int turn;
    private boolean movementMade;
    private String lastPlayerSymbol;
    private List<CellDomain> cells;

    public GameDomain(PlayerDomain playerO, PlayerDomain playerX, int columnSize, int rowSize) {
        this.playerO = playerO;
        this.playerX = playerX;
        movementMade = false;
        turn = new Random().nextInt(1);
        this.cells = initializeCells(columnSize, rowSize);
    }

    private List<CellDomain> initializeCells(int columnSize, int rowSize) {
        List<CellDomain> cellDomains = new ArrayList<>();
        for (int i = 0; i < (columnSize * rowSize); i++) {
            cellDomains.add(new CellDomain(i, Double.valueOf(Math.floor(i / columnSize)).intValue() + 1, (i % rowSize) + 1));
        }
        return cellDomains;
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

    public void makeMove() {
        movementMade = true;
        lastPlayerSymbol = getCurrentPlayer().getPlayerSymbol();
    }

    public void updateScore() {
        PlayerDomain currentPlayer = getCurrentPlayer();
        int newScore = currentPlayer.getScore() + 1;
        currentPlayer.setScore(newScore);
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

    public boolean isGameFinished(){
        boolean isFinished = true;
        for (CellDomain cell: cells){
            if (!cell.hasPlayer()) {
                isFinished = false;
                break;
            }
        }
        return isFinished;
    }
}
