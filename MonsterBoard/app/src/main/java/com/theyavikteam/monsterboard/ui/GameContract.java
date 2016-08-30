package com.theyavikteam.monsterboard.ui;

import android.content.Context;

import com.theyavikteam.monsterboard.model.vo.CellVO;
import com.theyavikteam.monsterboard.model.domain.PlayerDomain;

public interface GameContract {

    interface View{
        void showTurnToast(PlayerDomain playerVO);
        void setCell(CellVO cell, PlayerDomain player);
        void showFailToast(PlayerDomain player);
        void setTurnMessage(String message);
    }

    interface Presenter{
        void initializePresenter(Context context, View view);
        void onClickCell(CellVO cell);
        void onClickChange(String playerSymbol);
    }
}
