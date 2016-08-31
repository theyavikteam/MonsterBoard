package com.theyavikteam.monsterboard.ui;

import android.content.Context;

import com.theyavikteam.monsterboard.R;
import com.theyavikteam.monsterboard.model.domain.GameDomain;
import com.theyavikteam.monsterboard.model.vo.CellVO;
import com.theyavikteam.monsterboard.model.domain.PlayerDomain;

public class GamePresenter implements GameContract.Presenter {

    private static final String PLAYER_O = "O";
    private static final String PLAYER_X = "X";

    private Context context;
    private GameContract.View view;
    private GameDomain game;

    @Override
    public void initializePresenter(Context context, GameContract.View view) {
        this.view = view;
        this.context = context;
        game = new GameDomain(new PlayerDomain(PLAYER_O, R.color.playerO), new PlayerDomain(PLAYER_X, R.color.playerX));
        changeTurnMessage(R.string.turn_move_message, game.getCurrentPlayer());
    }

    @Override
    public void onClickCell(CellVO cell) {
        if (view != null) {
            PlayerDomain currentPlayer = game.getCurrentPlayer();
            if (!game.isMovementMade() && !currentPlayer.getPlayerSymbol().equalsIgnoreCase(game.getLastPlayerSymbol())) {
                game.makeMove();
                changeTurnMessage(R.string.turn_play_message, game.getOtherPlayer());
                view.setCell(cell, currentPlayer);
            } else {
                if (game.getTurn() == 0) {
                    view.showFailToast(game.getPlayerX());
                } else {
                    view.showFailToast(game.getPlayerO());
                }
            }
        }
    }

    @Override
    public void onClickChange(String playerSymbol) {
        if (view != null) {
            if (!game.isMovementMade() && game.getCurrentPlayer().getPlayerSymbol().equals(playerSymbol)) {
                view.showFailToast(game.getCurrentPlayer());
            } else {
                game.changeTurn();
                changeTurnMessage(R.string.turn_move_message, game.getCurrentPlayer());
            }
        }
    }

    private void changeTurnMessage(int stringResource, PlayerDomain player) {
        if (view != null) {
            String message = String.format(context.getString(stringResource), player.getPlayerSymbol());
            view.setTurnMessage(message);
        }
    }
}
