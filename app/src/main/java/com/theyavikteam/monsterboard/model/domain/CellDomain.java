package com.theyavikteam.monsterboard.model.domain;

public class CellDomain {

    private int viewPosition;
    private int column;
    private int row;
    private PlayerDomain player;

    public CellDomain(int viewPosition, int column, int row) {
        this.viewPosition = viewPosition;
        this.column = column;
        this.row = row;
    }

    public int getViewPosition() {
        return viewPosition;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public PlayerDomain getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDomain player) {
        this.player = player;
    }

    public boolean hasPlayer(){
        return player != null;
    }
}
