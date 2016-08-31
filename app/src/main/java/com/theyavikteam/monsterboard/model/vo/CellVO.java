package com.theyavikteam.monsterboard.model.vo;

import android.widget.TableRow;
import android.widget.TextView;

public class CellVO {

    private TextView textView;
    private TableRow tableRow;
    private int column;
    private int row;
    private int cellIndex;

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

    public int getCellIndex() {
        return cellIndex;
    }

    public void setCellIndex(int cellIndex) {
        this.cellIndex = cellIndex;
    }
}
