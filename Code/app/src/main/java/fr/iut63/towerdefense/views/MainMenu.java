package fr.iut63.towerdefense.views;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut63.towerdefense.R;
import fr.iut63.towerdefense.model.gamelogic.GameManager;
import fr.iut63.towerdefense.model.gamelogic.map.ImportMap;
import fr.iut63.towerdefense.model.gamelogic.map.Map;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        //GameManager game = new GameManager("Keturss", new ImportMap(1216, 608));
    }


}
