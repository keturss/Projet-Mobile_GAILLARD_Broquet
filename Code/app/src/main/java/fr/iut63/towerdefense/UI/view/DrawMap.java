package fr.iut63.towerdefense.UI.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.iut63.towerdefense.model.gamelogic.map.Map;
import fr.iut63.towerdefense.UI.activity.ActivityGame;

public class DrawMap {

    private Map map;
    private final int mapH;
    private final int mapW;

    private final ActivityGame activityGame;
    private final List<Bitmap> tiles;



    public DrawMap(ActivityGame context, Map mapTile) {
        activityGame = context;
        map = mapTile;

        int screenWidth = map.getResolutionWidth();
        int screenHeight = map.getResolutionHeight();

        mapH = map.getMap().length;
        mapW = map.getMap()[0].length;

        map.setTileLengthX(screenWidth / (mapW));
        map.setTileLengthY(screenHeight / (mapH));

        this.tiles = loadTileSet();
    }

    private List<Bitmap> loadTileSet() {
        ArrayList<Bitmap> tiles = new ArrayList<>();

        try {
            String[] paths = activityGame.getAssets().list("tiles");
            for (String path : paths) {
                InputStream tileIS = activityGame.getAssets().open("tiles/"+path);
                Bitmap bitmap = BitmapFactory.decodeStream(tileIS);
                tiles.add(Bitmap.createScaledBitmap(bitmap, map.getTileLengthX(), map.getTileLengthY(), true));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tiles;
    }

    public void draw() {
        for (int i = 0; i < mapH; i++) {
            for (int j = 0; j < mapW; j++) {
                ImageView tileIMG = new ImageView(activityGame);
                tileIMG.setImageBitmap(tiles.get(map.getMap()[i][j]));

                tileIMG.setX(j * map.getTileLengthX());
                tileIMG.setY(i * map.getTileLengthY());

                activityGame.getGamePart().addView(tileIMG);
            }
        }
    }

}
