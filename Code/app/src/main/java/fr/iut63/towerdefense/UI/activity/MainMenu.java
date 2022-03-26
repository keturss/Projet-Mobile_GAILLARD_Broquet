package fr.iut63.towerdefense.UI.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut63.towerdefense.R;

public class MainMenu extends AppCompatActivity {

    private AlertDialog dialogQuit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);


        Button buttonQuit =findViewById(R.id.menu_buttonQuit);
        buttonQuit.setOnClickListener(this::onClickQuit);

        Button buttonParameters = findViewById(R.id.menu_buttonParam);
        buttonParameters.setOnClickListener(this::onClickParam);

        Button buttonScores = findViewById(R.id.menu_buttonScore);
        buttonScores.setOnClickListener(this::onClickScore);

        Button buttonPlay = findViewById(R.id.menu_buttonPlay);
        buttonPlay.setOnClickListener(this::onClickPlay);

        AlertDialog.Builder builderGiveUpDialog = new AlertDialog.Builder(this);
        builderGiveUpDialog.setTitle(R.string.menu_buttonQuit)
                .setMessage(R.string.menu_quit_ask)
                .setPositiveButton(R.string.ok, (dialog, id) -> finish())
                .setNegativeButton(R.string.cancel, (dialog, id) -> dialog.cancel());

        dialogQuit = builderGiveUpDialog.create();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * Lance le dialogue de confirmation de fermeture de l'appli
     */
    public void quitGame(){
        dialogQuit.show();
    }

    /**
     * Méthode appelée lors du click du bouton quitter
     * Quitte l'application
     * @param view Bouton clické
     */
    private void onClickQuit(View view) {
        quitGame();
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

    private void onClickScore(View view) {
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }
}
