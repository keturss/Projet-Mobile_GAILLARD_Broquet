package fr.iut63.towerdefense.UI.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fr.iut63.towerdefense.R;
import fr.iut63.towerdefense.UI.activity.ScoreActivity;
import fr.iut63.towerdefense.UI.util.adaptater.ArrayToView;

/**
 * Détail Score Fragment
 */
public class MasterScoreFragment extends Fragment {

    private ScoreActivity activiteParente;

    public MasterScoreFragment() {
        super(R.layout.fragment_master_score);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activiteParente = (ScoreActivity) getContext();
        RecyclerView laListView = view.findViewById(R.id.laListView);
        laListView.setLayoutManager(new LinearLayoutManager(activiteParente));
        laListView.setAdapter(new ArrayToView(activiteParente.getScores()));
    }
}