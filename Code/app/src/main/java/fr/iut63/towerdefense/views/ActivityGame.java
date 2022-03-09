package fr.iut63.towerdefense.views;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import fr.iut63.towerdefense.R;
import fr.iut63.towerdefense.model.gamelogic.GameManager;
import fr.iut63.towerdefense.model.gamelogic.action.IBuyer;
import fr.iut63.towerdefense.model.gamelogic.action.tower.BuyerTower;
import fr.iut63.towerdefense.model.gamelogic.map.GenerationMap;
import fr.iut63.towerdefense.model.gamelogic.map.ImportMap;
import fr.iut63.towerdefense.model.gamelogic.map.Map;
import fr.iut63.towerdefense.views.map.DrawMap;

public class ActivityGame extends AppCompatActivity {


    private ConstraintLayout constraintLayout;
    private GameManager gameManager;
    DrawMap drawMap;

    private int height;
    private int width;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        final DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;

        gameManager = new GameManager("keturss", new GenerationMap(width, height));

        constraintLayout = findViewById(R.id.gamePart);

        drawMap = new DrawMap(this, gameManager.getGameMap());
        gameManager.start();
        drawMap.draw();
    }



    @Override
    public boolean onTouchEvent(MotionEvent e) {

        float x = e.getX();
        float y = e.getY();

        if (gameManager.getLoop().isRunning()) {
            IBuyer buyer = new BuyerTower(gameManager.getGame(), gameManager.getGameMap());
            if(buyer.buy(x,y))
                drawMap.draw();
        }

        return true;
    }


    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
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

