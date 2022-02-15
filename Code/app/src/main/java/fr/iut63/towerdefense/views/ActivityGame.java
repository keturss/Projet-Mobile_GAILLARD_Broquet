package fr.iut63.towerdefense.views;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

import fr.iut63.towerdefense.R;
import fr.iut63.towerdefense.model.Manager;
import fr.iut63.towerdefense.model.ScoreRanking;

public class ActivityGame extends AppCompatActivity {

    ScoreRanking scoreRanking = new ScoreRanking();
    Manager mgr ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mgr = new Manager(scoreRanking);
        setContentView(R.layout.activity_game);

        InputStream tileset = getResources().openRawResource(R.raw.tileset);

    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
