package fr.iut63.towerdefense.UI.util.adaptater;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.iut63.towerdefense.R;
import fr.iut63.towerdefense.model.gamelogic.GameState;

/**
 * Array GameState adapt for RecyclerView
 */
public class ArrayToView extends RecyclerView.Adapter {

    private ArrayList<GameState> scores = new ArrayList<>();

    public ArrayToView(ArrayList<GameState> scores) {
        this.scores = scores;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout layoutScore = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.score_field, parent, false);
        return new ViewHolderScore(layoutScore);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GameState scoreCourant = scores.get(position);
        ((ViewHolderScore)holder).getPseudoViewScore().setText(scoreCourant.getPseudo());
        ((ViewHolderScore)holder).getScoreViewScore().setText(String.valueOf(10));
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }
}

