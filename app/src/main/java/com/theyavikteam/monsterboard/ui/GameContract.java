package com.theyavikteam.monsterboard.ui;

import android.content.Context;

import com.theyavikteam.monsterboard.model.domain.PlayerDomain;

public interface GameContract {

    interface View{
        void setCell(int cellIndex, PlayerDomain player);
        void showToast(String message);
        void setTurnMessage(String message);
        void setPlayersScore(String newOScore, String newXScore);
        void finishGame(String result, String playerOScore, String playerXScore);
    }

    interface Presenter{
        void initializePresenter(Context context, View view);
        void restartGame();
        void onClickCell(int cellIndex);
        void onClickChange(String playerSymbol);
    }
}
