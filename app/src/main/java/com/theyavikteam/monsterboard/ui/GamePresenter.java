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
        updateScores(game);
    }

    @Override
    public void onClickCell(CellVO cell) {
        if (view != null) {
            PlayerDomain currentPlayer = game.getCurrentPlayer();
            if (cell.hasPlayer()) {
                failClickMessage(R.string.error_move_message, currentPlayer);
            } else {
                if (!game.isMovementMade() && !currentPlayer.getPlayerSymbol().equalsIgnoreCase(game.getLastPlayerSymbol())) {
                    game.makeMove();
                    game.updateScore();
                    updateScores(game);
                    changeTurnMessage(R.string.turn_play_message, game.getOtherPlayer());
                    view.setCell(cell, currentPlayer);
                } else {
                    view.showToast(formattedMessage(R.string.turn_why_message, game.getCurrentPlayer().getPlayerSymbol()));
                }
            }

        }
    }

    @Override
    public void onClickChange(String playerSymbol) {
        if (view != null) {
            if (game.getLastPlayerSymbol() != null && game.isMovementMade() && game.getOtherPlayer().getPlayerSymbol().equals(playerSymbol)) {
                game.changeTurn();
                changeTurnMessage(R.string.turn_move_message, game.getCurrentPlayer());
            }
        }
    }

    private void updateScores(GameDomain game){
        if (view != null){
            view.setPlayersScore(game.getPlayerO().getScore()+"", game.getPlayerX().getScore()+"");
        }
    }

    private void changeTurnMessage(int stringResource, PlayerDomain player) {
        if (view != null) {
            view.setTurnMessage(formattedMessage(stringResource, player.getPlayerSymbol()));
        }
    }

    private void failClickMessage(int stringResource, PlayerDomain playerDomain) {
        if (view != null) {
            view.showToast(formattedMessage(stringResource, playerDomain.getPlayerSymbol()));
        }
    }

    private String formattedMessage(int stringResource, String text) {
        return String.format(context.getString(stringResource), text);
    }
}
