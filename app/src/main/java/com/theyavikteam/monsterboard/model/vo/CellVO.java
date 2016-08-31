package com.theyavikteam.monsterboard.model.vo;

import android.content.Context;
import android.widget.TableRow;
import android.widget.TextView;

import com.theyavikteam.monsterboard.R;

public class CellVO {

    private TextView textView;
    private TableRow tableRow;
    private int cellIndex;

    public CellVO(Context context, TextView textView, TableRow tableRow, int cellColor) {
        this.textView = textView;
        this.textView.setText("");
        this.tableRow = tableRow;
        this.tableRow.setBackgroundColor(context.getResources().getColor(cellColor));
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
