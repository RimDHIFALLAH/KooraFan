package com.koora.koorafan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.koora.koorafan.dao.TeamDao;
import com.koora.koorafan.database.AppDatabase;
import com.koora.koorafan.model.Team;
import com.koora.koorafan.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        if (SharedPreferencesUtil.readStringToShared(SplashScreen.this, "db-init").isEmpty()) {
            insertDataToDb();
        }

        new Handler().postDelayed(() -> {
            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            if (!SharedPreferencesUtil.readStringToShared(SplashScreen.this, getString(R.string.remember_user)).isEmpty()) {
                i = new Intent(SplashScreen.this, SecondActivity.class);
            }
            startActivity(i);
            finish();
        }, 3000);
    }

    private void insertDataToDb() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("juventus", "juventus.png"));
        teams.add(new Team("liverpool","liverpool.png"));
        teams.add(new Team( "manchester united","manchester_united.png"));
        teams.add(new Team("real madrid", "real_madrid.png"));
        teams.add(new Team("roma", "roma.png"));
        teams.add(new Team( "chelsea", "chelsea.png"));
        teams.add(new Team("barcelona", "barcelona.png"));
        TeamDao teamDao = AppDatabase.getInstance(getApplicationContext()).teamDao();
        teamDao.insertAllTeams(teams);
        SharedPreferencesUtil.writeStringToShared(getApplicationContext(), "db-init", "done");
    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }
}