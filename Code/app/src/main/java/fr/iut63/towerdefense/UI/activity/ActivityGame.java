package fr.iut63.towerdefense.UI.activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import fr.iut63.towerdefense.R;
import fr.iut63.towerdefense.UI.view.GameView;
import fr.iut63.towerdefense.model.gamelogic.GameManager;
import fr.iut63.towerdefense.model.gamelogic.action.IBuyer;
import fr.iut63.towerdefense.model.gamelogic.action.tower.BuyerTower;
import fr.iut63.towerdefense.model.gamelogic.map.GenerationMap;
import fr.iut63.towerdefense.UI.view.DrawMap;
import fr.iut63.towerdefense.model.gameloop.Loop;

public class ActivityGame extends AppCompatActivity {


    private LinearLayout linearLayout;
    private ConstraintLayout gamePart;
    private DrawMap drawMap;
    private GameView gameview;

    private AlertDialog dialog;

    private Loop loop;

    private GameManager gameManager;
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


        gameview = new GameView(this, gameManager, width, height);

        loop = gameManager.getLoop();
        loop.setView(gameview);
        linearLayout.addView(gameview);

        //gamePart = findViewById(R.id.gamePart);


        AlertDialog.Builder builderGiveUpDialog = new AlertDialog.Builder(this);
        builderGiveUpDialog.setTitle(R.string.give_up)
                            .setMessage(R.string.give_up_ask)
                            .setCancelable(false)
                            .setPositiveButton(R.string.ok, (dialog, id) -> super.onBackPressed())
                            .setNegativeButton(R.string.cancel, (dialog, id) -> dialog.cancel());

        dialog = builderGiveUpDialog.create();
        ((TextView) findViewById(R.id.life_number)).setText(String.valueOf(gameManager.getGame().getLives()));
    }


    @Override
    public void onBackPressed() {
        dialog.show();
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


    public ConstraintLayout getGamePart() {
        return gamePart;
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

