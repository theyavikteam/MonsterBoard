package com.theyavikteam.monsterboard.model.vo;

import android.widget.TableRow;
import android.widget.TextView;

import com.theyavikteam.monsterboard.model.domain.PlayerDomain;

public class CellVO {

    private TextView textView;
    private TableRow tableRow;
    private PlayerDomain playerVO;

    public CellVO(TextView textView, TableRow tableRow) {
        this.textView = textView;
        this.tableRow = tableRow;
    }

    public TextView getTextView() {
        return textView;
    }

    public TableRow getTableRow() {
        return tableRow;
    }

    public void setPlayerVO(PlayerDomain playerVO) {
        this.playerVO = playerVO;
    }

    public boolean hasPlayer(){
        return this.playerVO != null;
    }
}
