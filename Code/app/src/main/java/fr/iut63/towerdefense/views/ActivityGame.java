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
        //gameManager.getLoop().start();
        drawMap.drawMap();
    }



    @Override
    public boolean onTouchEvent(MotionEvent e) {

        float x = e.getX();
        float y = e.getY();

        Log.d("CoordX", String.valueOf(x/gameManager.getGameMap().getTileLengthX()));
        Log.d("CoordY", String.valueOf(y/gameManager.getGameMap().getTileLengthY()));
        Log.d("Loop",String.valueOf(gameManager.getLoop().isRunning()));

        if (gameManager.getLoop().isRunning()) {
            IBuyer buyer = new BuyerTower(gameManager.getGame(), gameManager.getGameMap());
            boolean test = buyer.buy(e.getX(), e.getY());
            Log.d("Construct", String.valueOf(test));
            if(test){
                drawMap.drawMap();
            }
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

