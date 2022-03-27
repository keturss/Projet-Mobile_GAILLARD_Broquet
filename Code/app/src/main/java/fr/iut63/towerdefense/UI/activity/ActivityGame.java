package fr.iut63.towerdefense.UI.activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import fr.iut63.towerdefense.R;
import fr.iut63.towerdefense.model.gamelogic.GameManager;
import fr.iut63.towerdefense.model.gamelogic.action.IBuyer;
import fr.iut63.towerdefense.model.gamelogic.action.tower.BuyerTower;
import fr.iut63.towerdefense.model.gamelogic.map.GenerationMap;
import fr.iut63.towerdefense.UI.view.DrawMap;

public class ActivityGame extends AppCompatActivity {

    private ConstraintLayout gamePart;
    private GameManager gameManager;
    private DrawMap drawMap;

    private AlertDialog dialog;

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

        gamePart = findViewById(R.id.gamePart);

        drawMap = new DrawMap(this, gameManager.getGameMap());
        gameManager.start();
        drawMap.draw();

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

}

