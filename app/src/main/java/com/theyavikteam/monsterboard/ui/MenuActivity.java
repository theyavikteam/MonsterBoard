package com.theyavikteam.monsterboard.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.theyavikteam.monsterboard.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity{

    public static void start(Context context) {
        Intent starter = new Intent(context, MenuActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.tv_classic_game)
    public void onClickClassicGame(){
        GameActivity.start(this);
    }

    @OnClick(R.id.tv_bt_game)
    public void onClickBTGame(){
        //TODO
        //BluetoothActivity.start(this);
    }
}
