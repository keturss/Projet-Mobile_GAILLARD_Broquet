package fr.iut63.towerdefense.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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


        Button buttonQuit =findViewById(R.id.menu_buttonQuit);
        buttonQuit.setOnClickListener(this::onClickQuit);

        Button buttonParameters = findViewById(R.id.menu_buttonParam);
        buttonParameters.setOnClickListener(this::onClickParam);

        Button buttonPlay = findViewById(R.id.menu_buttonPlay);
        buttonPlay.setOnClickListener(this::onClickPlay);

        Log.d("testsLifecycle", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();


        Log.d("testsLifecycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("testsLifecycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("testsLifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("testsLifecycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("testsLifecycle", "onDestroy");
    }

    /**
     * Méthode appelée lors du click du bouton quitter
     * Quitte l'application
     * @param view Bouton clické
     */
    private void onClickQuit(View view) {
        finish();
    }

    /**
     * Méthode appelée lors du click sur le bouton paramètres
     * Envoie sur la vue des paramètres
     * @param view Bouton clické
     */
    private void onClickParam(View view) {
        Intent intent = new Intent(this, ParametersMenu.class);
        startActivity(intent);
    }

    /**
     * Méthode appelée lors du click sur le bouton jouer
     * Envoie sur la vue du jeu
     * @param view Bouton clické
     */
    private void onClickPlay(View view) {
        Intent intent = new Intent(this, ActivityGame.class);
        startActivity(intent);
    }
}
