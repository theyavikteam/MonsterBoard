package com.theyavikteam.monsterboard.model.domain;

import com.theyavikteam.monsterboard.model.constants.GameConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameDomain {
    private PlayerDomain playerO;
    private PlayerDomain playerX;
    private int turn;
    private boolean movementMade;
    private String lastPlayerSymbol;
    private int columnSize;
    private int rowSize;
    private List<CellDomain> cells;
    private List<CellDomain> aroundCells;

    public GameDomain(PlayerDomain playerO, PlayerDomain playerX, int columnSize, int rowSize) {
        this.playerO = playerO;
        this.playerX = playerX;
        movementMade = false;
        turn = (new Random().nextInt(10))%2;
        this.columnSize = columnSize;
        this.rowSize = rowSize;
        this.cells = initializeCells();
    }

    private List<CellDomain> initializeCells() {
        List<CellDomain> cellDomains = new ArrayList<>();
        for (int i = 0; i < (columnSize * rowSize); i++) {
            cellDomains.add(new CellDomain(i, Double.valueOf(Math.floor(i / columnSize)).intValue() + 1, (i % rowSize) + 1));
        }
        return cellDomains;
    }

    public List<CellDomain> getCells() {
        return cells;
    }

    public PlayerDomain getPlayerO() {
        return playerO;
    }

    public PlayerDomain getPlayerX() {
        return playerX;
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

    public void makeMove() {
        movementMade = true;
        lastPlayerSymbol = getCurrentPlayer().getPlayerSymbol();
    }

    public void updateScore(int cellIndex) {
        PlayerDomain currentPlayer = getCurrentPlayer();
        int newScore = currentPlayer.getScore() + GameConstants.SIMPLE_SCORE;
        cells.get(cellIndex).setPlayer(currentPlayer);
        newScore += getLinealScore(currentPlayer, cellIndex);
        newScore += getDiagonalScore(currentPlayer, cellIndex);
        currentPlayer.setScore(newScore);
    }

    private int getLinealScore(PlayerDomain currentPlayer, int cellIndex) {
        return getScore(currentPlayer, cellIndex, GameConstants.OWN_LINEAL_CELL_SCORE, GameConstants.RIVAL_LINEAL_CELL_SCORE, true);
    }

    private List<CellDomain> getLinealCells(int cellIndex) {
        refreshAroundCells();
        addIfMajorThan(cellIndex - rowSize);
        addIfMajorThan(cellIndex - 1);
        addIfMinorThan(cellIndex + 1);
        addIfMinorThan(cellIndex + rowSize);
        return aroundCells;
    }


    private int getDiagonalScore(PlayerDomain currentPlayer, int cellIndex) {
        return getScore(currentPlayer, cellIndex, GameConstants.OWN_DIAGONAL_CELL_SCORE, GameConstants.RIVAL_DIAGONAL_CELL_SCORE, false);
    }

    private List<CellDomain> getDiagonalCells(int cellIndex) {
        refreshAroundCells();
        addIfMajorThan(cellIndex - rowSize - 1);
        addIfMajorThan(cellIndex - rowSize + 1);
        addIfMinorThan(cellIndex + rowSize - 1);
        addIfMinorThan(cellIndex + rowSize + 1);
        return aroundCells;
    }

    private int getScore(PlayerDomain currentPlayer, int cellIndex, int ownScore, int rivalScore, boolean lineal) {
        int score = 0;
        if (lineal) {
            getLinealCells(cellIndex);
        } else {
            getDiagonalCells(cellIndex);
        }
        for (CellDomain cellDomain : aroundCells) {
            if (cellDomain.hasPlayer()) {
                if (cellDomain.getPlayer().getPlayerSymbol().equals(currentPlayer.getPlayerSymbol())) {
                    score += ownScore;
                } else {
                    score += rivalScore;
                }
            }
        }
        return score;
    }

    private void refreshAroundCells() {
        aroundCells = new ArrayList<>();
    }

    private void addIfMajorThan(int index) {
        addIfThan(index, 0, true);
    }

    private void addIfMinorThan(int index) {
        addIfThan(index, cells.size(), false);
    }

    private void addIfThan(int index, int value, boolean major) {
        if (major) {
            if (index >= value) aroundCells.add(cells.get(index));
        } else {
            if (index < value) aroundCells.add(cells.get(index));
        }
    }

    public boolean isGameFinished() {
        boolean isFinished = true;
        for (CellDomain cell : cells) {
            if (!cell.hasPlayer()) {
                isFinished = false;
                break;
            }
        }
        return isFinished;
    }
}
