package fr.iut63.towerdefense.UI.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import fr.iut63.towerdefense.R;
import fr.iut63.towerdefense.UI.util.adaptater.ArrayToView;
import fr.iut63.towerdefense.UI.util.data.Stub;
import fr.iut63.towerdefense.UI.util.save.FileLoader;
import fr.iut63.towerdefense.UI.util.save.FileSaver;
import fr.iut63.towerdefense.UI.util.save.ILoad;
import fr.iut63.towerdefense.UI.util.save.ISave;
import fr.iut63.towerdefense.model.gamelogic.GameState;

public class ScoreActivity extends AppCompatActivity {

    public static final String PATHToScores = "scores";
    private ISave save = new FileSaver();
    private ILoad loader;
    private final Stub modele = new Stub();
    private ArrayList<GameState> scores = null;

    private RecyclerView scoresRecyclerView;
    private TextView textViewHUD;
    private ArrayList<GameState> scoresView = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        Log.d("Create","onCreateScores()");

        loader = new FileLoader();
        try {
            scores = (ArrayList<GameState>) loader.load(openFileInput(PATHToScores));
        } catch (FileNotFoundException e) {
            scores = (ArrayList<GameState>) modele.load(null);
        }

        scoresRecyclerView = findViewById(R.id.scoresRecyclerView);
        scoresRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        textViewHUD = findViewById(R.id.textViewHUD);

        scoresView.addAll(scores);

        scoresRecyclerView.setAdapter(new ArrayToView(scoresView));

    }


    @Override
    protected void onStop() {
        try {
            save.save(openFileOutput(PATHToScores, MODE_PRIVATE), scores);
        } catch (FileNotFoundException e) {
            Log.e(getPackageName(), "Save failed");
        }
        super.onStop();
        Log.d("Stop","onStop()");
    }
}
