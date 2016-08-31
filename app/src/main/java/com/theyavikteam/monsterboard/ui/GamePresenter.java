package com.theyavikteam.monsterboard.ui;

import android.content.Context;

import com.theyavikteam.monsterboard.R;
import com.theyavikteam.monsterboard.model.domain.CellDomain;
import com.theyavikteam.monsterboard.model.domain.GameDomain;
import com.theyavikteam.monsterboard.model.domain.PlayerDomain;

public class GamePresenter implements GameContract.Presenter {

    private static final String PLAYER_O = "O";
    private static final String PLAYER_X = "X";
    private static final int BOARD_COLUMNS = 8;
    private static final int BOARD_ROWS = 6;

    private Context context;
    private GameContract.View view;
    private GameDomain game;

    @Override
    public void initializePresenter(Context context, GameContract.View view) {
        this.view = view;
        this.context = context;
        restartGame();
    }

    @Override
    public void restartGame() {
        game = new GameDomain(new PlayerDomain(PLAYER_O, R.color.playerO), new PlayerDomain(PLAYER_X, R.color.playerX), BOARD_COLUMNS, BOARD_ROWS);
        changeTurnMessage(R.string.turn_move_message, game.getCurrentPlayer());
        updateScores(game);
    }


    @Override
    public void onClickCell(int cellIndex) {
        if (view != null) {
            PlayerDomain currentPlayer = game.getCurrentPlayer();
            CellDomain clickedCell = game.getCells().get(cellIndex);
            if (clickedCell.hasPlayer()) {
                failClickMessage(R.string.error_move_message, currentPlayer);
            } else {
                if (!game.isMovementMade() && !currentPlayer.getPlayerSymbol().equalsIgnoreCase(game.getLastPlayerSymbol())) {
                    game.makeMove();
                    game.updateScore(cellIndex);
                    updateScores(game);
                    changeTurnMessage(R.string.turn_play_message, game.getOtherPlayer());
                    view.setCell(cellIndex, currentPlayer);
                    if (game.isGameFinished()){
                        if (game.getWinner() != null){
                            view.finishGame(formattedMessage(R.string.wins_message, game.getWinner()), game.getPlayerO().getScore()+"", game.getPlayerX().getScore()+"");
                        }else {
                            view.finishGame(context.getString(R.string.draw_message), game.getPlayerO().getScore()+"", game.getPlayerX().getScore()+"");
                        }
                    }
                } else {
                    view.showToast(formattedMessage(R.string.turn_why_message, game.getOtherPlayer().getPlayerSymbol()));
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
