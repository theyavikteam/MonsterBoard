package com.theyavikteam.monsterboard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.theyavikteam.monsterboard.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @Bind(R.id.game_logo)
    View gameLogo;
    @Bind(R.id.iv_tyt_logo)
    View tytLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initializeTimer();
    }

    public void initializeTimer() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToGame();
            }
        }, 2000);
    }

    public void navigateToGame() {
        tytLogo.setVisibility(View.GONE);
        gameLogo.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }


}
