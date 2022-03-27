package fr.iut63.towerdefense.UI.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import fr.iut63.towerdefense.R;
import fr.iut63.towerdefense.UI.fragment.MasterScoreFragment;
import fr.iut63.towerdefense.UI.util.data.Stub;
import fr.iut63.towerdefense.UI.util.save.FileLoader;
import fr.iut63.towerdefense.UI.util.save.FileSaver;
import fr.iut63.towerdefense.UI.util.save.ILoad;
import fr.iut63.towerdefense.UI.util.save.ISave;
import fr.iut63.towerdefense.model.gamelogic.GameState;

/**
 * Activité Score
 */
public class ScoreActivity extends AppCompatActivity {

    public static final String PATHToScores = "scores";
    private final ISave save = new FileSaver();
    private ILoad loader;
    private Stub modele;
    private ArrayList<GameState> scores = null;

    private RecyclerView scoresRecyclerView;
    private TextView textViewHUD;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        loader = new FileLoader();
        try {
            scores = (ArrayList<GameState>) loader.load(openFileInput(PATHToScores));
        } catch (FileNotFoundException e) {
            Log.d("ERREURLOAD", String.valueOf(e));
        }

        if (scores == null) {
            modele = new Stub();
            scores = modele.load(null);
        }

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.container_de_fragment, MasterScoreFragment.class, null)
                .commit();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.container_de_fragment, MasterScoreFragment.class, null)
                    .commit();
        }

        /*
        scoresRecyclerView = findViewById(R.id.scoresRecyclerView);
        scoresRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        textViewHUD = findViewById(R.id.textViewHUD);

        scoresView.addAll(scores);

        scoresRecyclerView.setAdapter(new ArrayToView(scoresView));
        */

    }

    public ArrayList<GameState> getScores() {
        return scores;
    }

    /**
     * Persistence Scores onStop app
     */
    @Override
    protected void onStop() {
        try {
            save.save(openFileOutput(PATHToScores, MODE_PRIVATE), scores);
        } catch (FileNotFoundException e) {
            Log.e(getPackageName(), "Save failed");
        }
        super.onStop();
        Log.d("Stop", "onStop()");
    }
}
