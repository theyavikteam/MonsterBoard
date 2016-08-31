package com.theyavikteam.monsterboard.ui;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.theyavikteam.monsterboard.R;
import com.theyavikteam.monsterboard.model.vo.CellVO;
import com.theyavikteam.monsterboard.model.domain.PlayerDomain;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements GameContract.View{

    @Bind(R.id.tv_1_1)
    TextView tv11;
    @Bind(R.id.tv_1_2)
    TextView tv12;
    @Bind(R.id.tv_1_3)
    TextView tv13;
    @Bind(R.id.tv_1_4)
    TextView tv14;
    @Bind(R.id.tv_1_5)
    TextView tv15;
    @Bind(R.id.tv_1_6)
    TextView tv16;

    @Bind(R.id.tv_2_1)
    TextView tv21;
    @Bind(R.id.tv_2_2)
    TextView tv22;
    @Bind(R.id.tv_2_3)
    TextView tv23;
    @Bind(R.id.tv_2_4)
    TextView tv24;
    @Bind(R.id.tv_2_5)
    TextView tv25;
    @Bind(R.id.tv_2_6)
    TextView tv26;

    @Bind(R.id.tv_3_1)
    TextView tv31;
    @Bind(R.id.tv_3_2)
    TextView tv32;
    @Bind(R.id.tv_3_3)
    TextView tv33;
    @Bind(R.id.tv_3_4)
    TextView tv34;
    @Bind(R.id.tv_3_5)
    TextView tv35;
    @Bind(R.id.tv_3_6)
    TextView tv36;

    @Bind(R.id.tv_4_1)
    TextView tv41;
    @Bind(R.id.tv_4_2)
    TextView tv42;
    @Bind(R.id.tv_4_3)
    TextView tv43;
    @Bind(R.id.tv_4_4)
    TextView tv44;
    @Bind(R.id.tv_4_5)
    TextView tv45;
    @Bind(R.id.tv_4_6)
    TextView tv46;

    @Bind(R.id.tv_5_1)
    TextView tv51;
    @Bind(R.id.tv_5_2)
    TextView tv52;
    @Bind(R.id.tv_5_3)
    TextView tv53;
    @Bind(R.id.tv_5_4)
    TextView tv54;
    @Bind(R.id.tv_5_5)
    TextView tv55;
    @Bind(R.id.tv_5_6)
    TextView tv56;

    @Bind(R.id.tv_6_1)
    TextView tv61;
    @Bind(R.id.tv_6_2)
    TextView tv62;
    @Bind(R.id.tv_6_3)
    TextView tv63;
    @Bind(R.id.tv_6_4)
    TextView tv64;
    @Bind(R.id.tv_6_5)
    TextView tv65;
    @Bind(R.id.tv_6_6)
    TextView tv66;

    @Bind(R.id.tv_7_1)
    TextView tv71;
    @Bind(R.id.tv_7_2)
    TextView tv72;
    @Bind(R.id.tv_7_3)
    TextView tv73;
    @Bind(R.id.tv_7_4)
    TextView tv74;
    @Bind(R.id.tv_7_5)
    TextView tv75;
    @Bind(R.id.tv_7_6)
    TextView tv76;

    @Bind(R.id.tv_8_1)
    TextView tv81;
    @Bind(R.id.tv_8_2)
    TextView tv82;
    @Bind(R.id.tv_8_3)
    TextView tv83;
    @Bind(R.id.tv_8_4)
    TextView tv84;
    @Bind(R.id.tv_8_5)
    TextView tv85;
    @Bind(R.id.tv_8_6)
    TextView tv86;


    @Bind(R.id.tr_1_1)
    TableRow tr11;
    @Bind(R.id.tr_1_2)
    TableRow tr12;
    @Bind(R.id.tr_1_3)
    TableRow tr13;
    @Bind(R.id.tr_1_4)
    TableRow tr14;
    @Bind(R.id.tr_1_5)
    TableRow tr15;
    @Bind(R.id.tr_1_6)
    TableRow tr16;

    @Bind(R.id.tr_2_1)
    TableRow tr21;
    @Bind(R.id.tr_2_2)
    TableRow tr22;
    @Bind(R.id.tr_2_3)
    TableRow tr23;
    @Bind(R.id.tr_2_4)
    TableRow tr24;
    @Bind(R.id.tr_2_5)
    TableRow tr25;
    @Bind(R.id.tr_2_6)
    TableRow tr26;

    @Bind(R.id.tr_3_1)
    TableRow tr31;
    @Bind(R.id.tr_3_2)
    TableRow tr32;
    @Bind(R.id.tr_3_3)
    TableRow tr33;
    @Bind(R.id.tr_3_4)
    TableRow tr34;
    @Bind(R.id.tr_3_5)
    TableRow tr35;
    @Bind(R.id.tr_3_6)
    TableRow tr36;

    @Bind(R.id.tr_4_1)
    TableRow tr41;
    @Bind(R.id.tr_4_2)
    TableRow tr42;
    @Bind(R.id.tr_4_3)
    TableRow tr43;
    @Bind(R.id.tr_4_4)
    TableRow tr44;
    @Bind(R.id.tr_4_5)
    TableRow tr45;
    @Bind(R.id.tr_4_6)
    TableRow tr46;

    @Bind(R.id.tr_5_1)
    TableRow tr51;
    @Bind(R.id.tr_5_2)
    TableRow tr52;
    @Bind(R.id.tr_5_3)
    TableRow tr53;
    @Bind(R.id.tr_5_4)
    TableRow tr54;
    @Bind(R.id.tr_5_5)
    TableRow tr55;
    @Bind(R.id.tr_5_6)
    TableRow tr56;

    @Bind(R.id.tr_6_1)
    TableRow tr61;
    @Bind(R.id.tr_6_2)
    TableRow tr62;
    @Bind(R.id.tr_6_3)
    TableRow tr63;
    @Bind(R.id.tr_6_4)
    TableRow tr64;
    @Bind(R.id.tr_6_5)
    TableRow tr65;
    @Bind(R.id.tr_6_6)
    TableRow tr66;

    @Bind(R.id.tr_7_1)
    TableRow tr71;
    @Bind(R.id.tr_7_2)
    TableRow tr72;
    @Bind(R.id.tr_7_3)
    TableRow tr73;
    @Bind(R.id.tr_7_4)
    TableRow tr74;
    @Bind(R.id.tr_7_5)
    TableRow tr75;
    @Bind(R.id.tr_7_6)
    TableRow tr76;

    @Bind(R.id.tr_8_1)
    TableRow tr81;
    @Bind(R.id.tr_8_2)
    TableRow tr82;
    @Bind(R.id.tr_8_3)
    TableRow tr83;
    @Bind(R.id.tr_8_4)
    TableRow tr84;
    @Bind(R.id.tr_8_5)
    TableRow tr85;
    @Bind(R.id.tr_8_6)
    TableRow tr86;


    @Bind(R.id.tv_player_turn)
    TextView tvPlayerTurn;

    @Bind(R.id.tv_player_O)
    TextView tvPlayerO;
    @Bind(R.id.tv_player_O_score)
    TextView tvPlayerOScore;

    @Bind(R.id.tv_player_X)
    TextView tvPlayerX;
    @Bind(R.id.tv_player_X_score)
    TextView tvPlayerXScore;

    GameContract.Presenter gamePresenter;

    List<CellVO> cells;


    Toast messageToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initializeGame();
    }

    private void initializeGame() {
        gamePresenter = new GamePresenter();
        gamePresenter.initializePresenter(this, this);
        initializeCells();
        initializeCellClickListeners(cells);
    }

    private List<CellVO> initializeCells(){
        cells = new ArrayList<>();
        cells.add(new CellVO(tv11, tr11));
        cells.add(new CellVO(tv12, tr12));
        cells.add(new CellVO(tv13, tr13));
        cells.add(new CellVO(tv14, tr14));
        cells.add(new CellVO(tv15, tr15));
        cells.add(new CellVO(tv16, tr16));

        cells.add(new CellVO(tv21, tr21));
        cells.add(new CellVO(tv22, tr22));
        cells.add(new CellVO(tv23, tr23));
        cells.add(new CellVO(tv24, tr24));
        cells.add(new CellVO(tv25, tr25));
        cells.add(new CellVO(tv26, tr26));

        cells.add(new CellVO(tv31, tr31));
        cells.add(new CellVO(tv32, tr32));
        cells.add(new CellVO(tv33, tr33));
        cells.add(new CellVO(tv34, tr34));
        cells.add(new CellVO(tv35, tr35));
        cells.add(new CellVO(tv36, tr36));

        cells.add(new CellVO(tv41, tr41));
        cells.add(new CellVO(tv42, tr42));
        cells.add(new CellVO(tv43, tr43));
        cells.add(new CellVO(tv44, tr44));
        cells.add(new CellVO(tv45, tr45));
        cells.add(new CellVO(tv46, tr46));

        cells.add(new CellVO(tv51, tr51));
        cells.add(new CellVO(tv52, tr52));
        cells.add(new CellVO(tv53, tr53));
        cells.add(new CellVO(tv54, tr54));
        cells.add(new CellVO(tv55, tr55));
        cells.add(new CellVO(tv56, tr56));

        cells.add(new CellVO(tv61, tr61));
        cells.add(new CellVO(tv62, tr62));
        cells.add(new CellVO(tv63, tr63));
        cells.add(new CellVO(tv64, tr64));
        cells.add(new CellVO(tv65, tr65));
        cells.add(new CellVO(tv66, tr66));

        cells.add(new CellVO(tv71, tr71));
        cells.add(new CellVO(tv72, tr72));
        cells.add(new CellVO(tv73, tr73));
        cells.add(new CellVO(tv74, tr74));
        cells.add(new CellVO(tv75, tr75));
        cells.add(new CellVO(tv76, tr76));

        cells.add(new CellVO(tv81, tr81));
        cells.add(new CellVO(tv82, tr82));
        cells.add(new CellVO(tv83, tr83));
        cells.add(new CellVO(tv84, tr84));
        cells.add(new CellVO(tv85, tr85));
        cells.add(new CellVO(tv86, tr86));
        return cells;
    }

    private void initializeCellClickListeners(List<CellVO> cells){
        for (int i = 0; i< cells.size(); i++){
            setOnClickListener(cells.get(i));
        }
    }

    private void setOnClickListener(final CellVO cell){
        if (cell != null){
            cell.getTableRow().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gamePresenter.onClickCell(cell);
                }
            });
        }
    }

    @OnClick({R.id.tv_player_O, R.id.tv_player_X})
    public void onClickPlayer(TextView playerTextView){
        gamePresenter.onClickChange(playerTextView.getText().toString());
    }

    @Override
    public void setCell(CellVO cell, PlayerDomain player) {
        int cellIndex = cells.indexOf(cell);
        if (cellIndex != -1){
            CellVO oldCell = cells.get(cellIndex);
            oldCell.getTableRow().setBackgroundColor(getResources().getColor(player.getPlayerColor()));
            oldCell.getTextView().setText(player.getPlayerSymbol());
            oldCell.setPlayerVO(player);
            cells.set(cellIndex, oldCell);
        }
    }

    @Override
    public void showToast(String message){
        if (messageToast != null){
            messageToast.cancel();
        }
        messageToast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        messageToast.show();
    }

    @Override
    public void setTurnMessage(String message) {
        tvPlayerTurn.setText(message);
    }

    @Override
    public void setPlayersScore(String newOScore, String newXScore) {
        tvPlayerOScore.setText(newOScore);
        tvPlayerXScore.setText(newXScore);
    }
}
