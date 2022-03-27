package fr.iut63.towerdefense.UI.util.adaptater;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.iut63.towerdefense.R;
import fr.iut63.towerdefense.model.gamelogic.GameState;

/**
 * View Holder for Fragment
 */
public class ViewHolderScore extends RecyclerView.ViewHolder {

    private final TextView pseudoViewScore;
    private final TextView scoreViewScore;

    public ViewHolderScore(@NonNull View itemView) {
        super(itemView);
        pseudoViewScore = itemView.findViewById(R.id.pseudoText);
        scoreViewScore = itemView.findViewById(R.id.scoreText);
    }

    public TextView getScoreViewScore() {
        return scoreViewScore;
    }

    public TextView getPseudoViewScore() {
        return pseudoViewScore;
    }

    public void setScoreCourant(GameState score) {
        // ..
    }
}
