package fr.iut63.towerdefense.views;

import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import fr.iut63.towerdefense.R;
import fr.iut63.towerdefense.model.gamelogic.map.GenerationMap;
import fr.iut63.towerdefense.model.gamelogic.map.Map;
import fr.iut63.towerdefense.views.map.DrawMap;

public class ActivityGame extends AppCompatActivity {


    private ConstraintLayout constraintLayout;

    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        final DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int height = displayMetrics.heightPixels;
        final int width = displayMetrics.widthPixels;

        Map map = new GenerationMap(width, height);

        constraintLayout = findViewById(R.id.gamePart);

        DrawMap drawMap = new DrawMap(this, width, height, map);
        drawMap.drawMap();

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

