package com.theyavikteam.monsterboard.ui;

import android.content.Context;

import com.theyavikteam.monsterboard.model.vo.CellVO;
import com.theyavikteam.monsterboard.model.domain.PlayerDomain;

public interface GameContract {

    interface View{
        void setCell(CellVO cell, PlayerDomain player);
        void showToast(String message);
        void setTurnMessage(String message);
        void setPlayersScore(String newOScore, String newXScore);
    }

    interface Presenter{
        void initializePresenter(Context context, View view);
        void onClickCell(CellVO cell);
        void onClickChange(String playerSymbol);
    }
}
