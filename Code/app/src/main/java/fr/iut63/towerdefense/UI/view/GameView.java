package fr.iut63.towerdefense.UI.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import fr.iut63.towerdefense.R;
import fr.iut63.towerdefense.UI.activity.ActivityGame;
import fr.iut63.towerdefense.model.gamelogic.GameManager;
import fr.iut63.towerdefense.model.gamelogic.GameState;
import fr.iut63.towerdefense.model.gamelogic.map.Map;
import fr.iut63.towerdefense.model.gameloop.ILoopListener;

public class GameView extends View implements ILoopListener {
    public GameManager world;

    private final double layoutWidth;
    private final double layoutHeight;
    private Context context;

    private Map map;
    private final int mapH;
    private final int mapW;

    private final List<Bitmap> tiles;
    private ConstraintLayout gamePart;



    public GameView(Context context, GameManager world, double layoutWidth, double layoutHeight, ConstraintLayout gamePart) {
        super(context);
        this.layoutWidth = layoutWidth;
        this.layoutHeight = layoutHeight;
        this.world = world;
        this.context = context;
        this.gamePart = gamePart;
        this.map = world.getGameMap();

        this.mapH = map.getMap().length;
        this.mapW = map.getMap()[0].length;

        map.setTileLengthX((int) (layoutWidth / (mapW)));
        map.setTileLengthY((int) (layoutHeight / (mapH)));

        this.tiles = loadTileSet();
    }


    private List<Bitmap> loadTileSet() {
        ArrayList<Bitmap> tiles = new ArrayList<>();

        try {
            String[] paths = context.getAssets().list("tiles");
            for (String path : paths) {
                InputStream tileIS = context.getAssets().open("tiles/"+path);
                Bitmap bitmap = BitmapFactory.decodeStream(tileIS);
                tiles.add(Bitmap.createScaledBitmap(bitmap, map.getTileLengthX(), map.getTileLengthY(), true));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tiles;
    }

    @Override
    protected void onLayout(boolean b, int left, int top, int right, int bottom ) {

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return true;
    }


    protected void onDraw(Canvas c) {
        super.onDraw(c);

        for (int i = 0; i < mapH; i++) {
            for (int j = 0; j < mapW; j++) {
                ImageView tileIMG = new ImageView(context);
                tileIMG.setImageBitmap(tiles.get(map.getMap()[i][j]));

                tileIMG.setX(j * map.getTileLengthX());
                tileIMG.setY(i * map.getTileLengthY());

                gamePart.addView(tileIMG);
            }
        }
    }

    @Override
    public void update(int timer) {
        postInvalidate();
    }
}
