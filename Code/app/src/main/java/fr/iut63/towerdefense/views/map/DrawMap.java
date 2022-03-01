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

    private final int TILE_SIZE = 64;

    private final int width;
    private final int height;

    private final ActivityGame activityGame;
    private final List<Bitmap> tiles;



    public DrawMap(ActivityGame context, int width, int height) {
        this.activityGame = context;
        this.width = width;
        this.height = height;

        this.tiles = loadTileSet();
    }

    private List<Bitmap> loadTileSet() {
        ArrayList<Bitmap> tiles = new ArrayList<>();

        try {
            for (String path : activityGame.getAssets().list("tiles/")) {
                InputStream tileIS = activityGame.getAssets().open("tiles/"+path);
                Bitmap test = BitmapFactory.decodeStream(tileIS);
                tiles.add(test);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tiles;
    }

    public void drawMap(Map map) {
        int[][] tabMap = map.getMap();
        int height = tabMap.length;
        int width = tabMap[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ImageView tileIMG = new ImageView(activityGame);
                tileIMG.setImageBitmap(tiles.get(tabMap[i][j]));

                tileIMG.setX(j * TILE_SIZE);
                tileIMG.setY(i * TILE_SIZE);

                System.out.println(tileIMG.getImageMatrix());

                activityGame.getConstraintLayout().addView(tileIMG);
            }
        }
    }
}
