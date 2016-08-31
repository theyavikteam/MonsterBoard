package com.theyavikteam.monsterboard.model.vo;

import android.widget.TableRow;
import android.widget.TextView;

import com.theyavikteam.monsterboard.model.domain.PlayerDomain;

public class CellVO {

    private TextView textView;
    private TableRow tableRow;
    private PlayerDomain playerVO;
    private int column;
    private int row;

    public CellVO(TextView textView, TableRow tableRow, int column ,int row) {
        this.textView = textView;
        this.tableRow = tableRow;
        this.column = column;
        this.row = row;
    }

    public TextView getTextView() {
        return textView;
    }

    public TableRow getTableRow() {
        return tableRow;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setPlayerVO(PlayerDomain playerVO) {
        this.playerVO = playerVO;
    }

    public boolean hasPlayer(){
        return this.playerVO != null;
    }
}
