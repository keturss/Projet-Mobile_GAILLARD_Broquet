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


        Button buttonQuit = (Button) findViewById(R.id.menu_buttonQuit);
        buttonQuit.setOnClickListener(this::onClickQuit);

        Button buttonParameters = (Button) findViewById(R.id.menu_buttonParam);
        buttonParameters.setOnClickListener(this::onClickParam);

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
    public void onClickQuit(View view) {
        finish();
    }

    /**
     * Méthode appelée lors du click sur le bouton paramètres
     * Envoie sur la vur des paramètres
     * @param view Bouton clické
     */
    private void onClickParam(View view) {
        Intent intent = new Intent(this, ParametersMenu.class);
        startActivity(intent);
    }
}
