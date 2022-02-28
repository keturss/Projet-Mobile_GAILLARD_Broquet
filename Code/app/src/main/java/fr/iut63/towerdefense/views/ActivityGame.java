package fr.iut63.towerdefense.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import fr.iut63.towerdefense.R;
import fr.iut63.towerdefense.model.Manager;
import fr.iut63.towerdefense.model.ScoreRanking;
import fr.iut63.towerdefense.model.gamelogic.map.GenerationMap;
import fr.iut63.towerdefense.model.gamelogic.map.Map;

public class ActivityGame extends AppCompatActivity {


    ConstraintLayout constraintLayout;
    private Bitmap mapBitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int height = displayMetrics.heightPixels;
        final int width = displayMetrics.widthPixels;

        Map map = new GenerationMap(width,height);

        ImageView i = new ImageView(this);
        i.setImageResource(R.raw.tileset);

        i.setAdjustViewBounds(true);
        i.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        constraintLayout.addView(i);
        setContentView(constraintLayout);

/*
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        mapBitmap = Bitmap.createBitmap(
                20*64,
                13*64,
                config
        );

        Canvas mapCanvas = new Canvas(mapBitmap);

        draw(mapCanvas);
*/

    }

    public Rect getGameRect() {
        return new Rect(
                (int) (10 - 64/2),
                (int) (10 - 64/2),
                (int) (10 + 64/2),
                (int) (10 + 64/2)
        );
    }


    public void draw(Canvas canvas) {
        canvas.drawBitmap(
                mapBitmap,
                getGameRect(),
                new Rect(0, 0, 64, 64),
                null
        );
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

