package fr.iut63.towerdefense.views.map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.iut63.towerdefense.model.gamelogic.map.Map;
import fr.iut63.towerdefense.views.ActivityGame;

public class DrawMap {

    private final int TILE_HEIGHT ;
    private final int TILE_WIDTH;
    private final int screenWidth;
    private final int screenHeight;

    private Map map;
    private int mapH;
    private int mapW;
    private int[][] tabMap;

    private final ActivityGame activityGame;
    private final List<Bitmap> tiles;



    public DrawMap(ActivityGame context, int sWidth, int sHeight, Map map) {
        this.activityGame = context;
        this.screenWidth = sWidth;
        this.screenHeight = sHeight;
        this.map = map;
        tabMap = map.getMap();
        mapH = tabMap.length;
        mapW = tabMap[0].length;

        TILE_WIDTH = screenWidth / mapW ;
        TILE_HEIGHT = screenHeight / mapH;

        this.tiles = loadTileSet();
    }

    private List<Bitmap> loadTileSet() {
        ArrayList<Bitmap> tiles = new ArrayList<>();

        try {
            for (String path : activityGame.getAssets().list("tiles/")) {
                InputStream tileIS = activityGame.getAssets().open("tiles/"+path);
                Bitmap bitmap = BitmapFactory.decodeStream(tileIS);
                tiles.add(Bitmap.createScaledBitmap(bitmap, TILE_WIDTH, TILE_HEIGHT, true));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tiles;
    }

    public void drawMap() {
        for (int i = 0; i < mapH; i++) {
            for (int j = 0; j < mapW; j++) {
                ImageView tileIMG = new ImageView(activityGame);
                tileIMG.setImageBitmap(tiles.get(tabMap[i][j]));


                tileIMG.setX(j * TILE_WIDTH);
                tileIMG.setY(i * TILE_HEIGHT);

                activityGame.getConstraintLayout().addView(tileIMG);
            }
        }
    }
}
