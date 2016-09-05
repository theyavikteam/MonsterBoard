package com.theyavikteam.monsterboard.model.domain;

import android.util.Log;

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
    private String winner;

    public GameDomain(PlayerDomain playerO, PlayerDomain playerX, int columnSize, int rowSize) {
        this.playerO = playerO;
        this.playerX = playerX;
        movementMade = false;
        turn = (new Random().nextInt(10)) % 2;
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
        newScore += getThreeInLineScore(currentPlayer, cellIndex);
        currentPlayer.setScore(newScore);
    }

    private int getThreeInLineScore(PlayerDomain currentPlayer, int cellIndex) {
        int score = 0;
        score += getVerticalScore(currentPlayer, cellIndex);
        score += getHorizontalScore(currentPlayer, cellIndex);
        score += getUpwardScore(currentPlayer, cellIndex);
        score += getFalling(currentPlayer, cellIndex);
        return score;
    }

    private int getVerticalScore(PlayerDomain currentPlayer, int cellIndex) {
        refreshAroundCells();
        findVerticalCellByCellIndex(currentPlayer, cellIndex);
        int score = 0;
        if (aroundCells.size() >= 2) {
            score = (aroundCells.size() + 1) * GameConstants.LINE_SCORE;
            Log.i("Vertical Score", "+"+score);
        }
        return score;
    }

    private void findVerticalCellByCellIndex(PlayerDomain currentPlayer, int cellIndex) {
        int countLimit = cellIndex % rowSize;
        for (int i = 1; i <= countLimit; i++) {
            if (cellIndex > 0 || cellIndex - i >= 0) {
                CellDomain findCell = cells.get(cellIndex - i);
                if (cellsHasSamePlayer(findCell, currentPlayer)) {
                    aroundCells.add(findCell);
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        for (int i = 1; i + countLimit < rowSize; i++) {
            if (cellIndex < cells.size() || cellIndex + i < cells.size()) {
                CellDomain findCell = cells.get(cellIndex + i);
                if (cellsHasSamePlayer(findCell, currentPlayer)) {
                    aroundCells.add(findCell);
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    private boolean cellsHasSamePlayer(CellDomain findCell, PlayerDomain currentPlayer){
        return findCell.hasPlayer() && findCell.getPlayer().getPlayerSymbol().equals(currentPlayer.getPlayerSymbol());
    }

    private int getHorizontalScore(PlayerDomain currentPlayer, int cellIndex) {
        refreshAroundCells();
        findHorizontalCellByCellIndex(currentPlayer, cellIndex);
        int score = 0;
        if (aroundCells.size() >= 2) {
            score = (aroundCells.size() + 1) * GameConstants.LINE_SCORE;
            Log.i("Horizontal Score", "+"+score);
        }
        return score;
    }

    private void findHorizontalCellByCellIndex(PlayerDomain currentPlayer, int cellIndex){
        for (int i = cellIndex - rowSize; i >= 0; i -= rowSize){
            CellDomain findCell = cells.get(i);
            if (cellsHasSamePlayer(findCell, currentPlayer)) {
                aroundCells.add(findCell);
            } else {
                break;
            }
        }
        for (int i = cellIndex + rowSize; i < cells.size(); i += rowSize){
            CellDomain findCell = cells.get(i);
            if (cellsHasSamePlayer(findCell, currentPlayer)) {
                aroundCells.add(findCell);
            } else {
                break;
            }
        }
    }

    private int getUpwardScore(PlayerDomain currentPlayer, int cellIndex) {
        refreshAroundCells();
        findUpwardCellByCellIndex(currentPlayer, cellIndex);
        int score = 0;
        if (aroundCells.size() >= 2) {
            score = (aroundCells.size() + 1) * GameConstants.LINE_SCORE;
            Log.i("Upward Score", "+"+score);
        }
        return score;
    }

    private void findUpwardCellByCellIndex(PlayerDomain currentPlayer, int cellIndex) {
        int countLimit = cellIndex % rowSize;
        int jump = rowSize - 1;
        for (int i = 1; i <= countLimit; i++){
            int nextIndex = cellIndex + (i * jump);
            if (nextIndex < cells.size()){
                CellDomain findCell = cells.get(nextIndex);
                if (cellsHasSamePlayer(findCell, currentPlayer)) {
                    aroundCells.add(findCell);
                } else {
                    break;
                }
            }else {
                break;
            }
        }
        int steps = rowSize - countLimit + 2;
        for (int i = 1; i <= steps; i ++){
            int nextIndex = cellIndex - (i * rowSize) + i;
            if (nextIndex > 0){
                CellDomain findCell = cells.get(nextIndex);
                if (cellsHasSamePlayer(findCell, currentPlayer)) {
                    aroundCells.add(findCell);
                } else {
                    break;
                }
            }else {
                break;
            }
        }
    }

    private int getFalling(PlayerDomain currentPlayer, int cellIndex) {
        refreshAroundCells();
        findFallingCellByCellIndex(currentPlayer, cellIndex);
        int score = 0;
        if (aroundCells.size() >= 2) {
            score = (aroundCells.size() + 1) * GameConstants.LINE_SCORE;
            Log.i("Falling Score", "+"+score);
        }
        return score;
    }

    private void findFallingCellByCellIndex(PlayerDomain currentPlayer, int cellIndex) {
        int countLimit = cellIndex % rowSize;
        int jump = rowSize + 1;
        for (int i = 1; i <= countLimit; i++){
            int nextIndex = cellIndex - (i * jump);
            if (nextIndex >= 0){
                CellDomain findCell = cells.get(nextIndex);
                if (cellsHasSamePlayer(findCell, currentPlayer)) {
                    aroundCells.add(findCell);
                } else {
                    break;
                }
            }else {
                break;
            }
        }
        int steps = rowSize - countLimit + 2;
        for (int i = 1; i <= steps; i ++){
            int nextIndex = cellIndex + (i * jump);
            if (nextIndex < cells.size()){
                CellDomain findCell = cells.get(nextIndex);
                if (cellsHasSamePlayer(findCell, currentPlayer)) {
                    aroundCells.add(findCell);
                } else {
                    break;
                }
            }else {
                break;
            }
        }
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

    private void refreshAroundCells() {
        aroundCells = new ArrayList<>();
    }

    public boolean isGameFinished() {
        boolean isFinished = true;
        for (CellDomain cell : cells) {
            if (!cell.hasPlayer()) {
                isFinished = false;
                break;
            }
        }
        if (isFinished) {
            winner = getWinnerName();
        }
        return isFinished;
    }


    public String getWinner() {
        return winner;
    }

    private String getWinnerName() {
        String winner;
        if (playerO.getScore() == playerX.getScore()) {
            winner = null;
        } else if (playerO.getScore() > playerX.getScore()) {
            winner = playerO.getPlayerSymbol();
        } else {
            winner = playerX.getPlayerSymbol();
        }
        return winner;
    }
}
