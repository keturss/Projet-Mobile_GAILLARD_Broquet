package fr.iut63.towerdefense.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import fr.iut63.towerdefense.model.gamelogic.GameState;

/**
 * Classe Score et Ranking permettant de classer le resultat en fonction du score obtenu
 */
public class ScoreRanking {
    private final List<GameState> rankingObservable = new List<GameState>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<GameState> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] ts) {
            return null;
        }

        @Override
        public boolean add(GameState gameState) {
            return false;
        }

        @Override
        public boolean remove(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends GameState> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, @NonNull Collection<? extends GameState> collection) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public GameState get(int i) {
            return null;
        }

        @Override
        public GameState set(int i, GameState gameState) {
            return null;
        }

        @Override
        public void add(int i, GameState gameState) {

        }

        @Override
        public GameState remove(int i) {
            return null;
        }

        @Override
        public int indexOf(@Nullable Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(@Nullable Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<GameState> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<GameState> listIterator(int i) {
            return null;
        }

        @NonNull
        @Override
        public List<GameState> subList(int i, int i1) {
            return null;
        }
    };

    private final List<GameState> ranking = new List<GameState>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<GameState> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] ts) {
            return null;
        }

        @Override
        public boolean add(GameState gameState) {
            return false;
        }

        @Override
        public boolean remove(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends GameState> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, @NonNull Collection<? extends GameState> collection) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public GameState get(int i) {
            return null;
        }

        @Override
        public GameState set(int i, GameState gameState) {
            return null;
        }

        @Override
        public void add(int i, GameState gameState) {

        }

        @Override
        public GameState remove(int i) {
            return null;
        }

        @Override
        public int indexOf(@Nullable Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(@Nullable Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<GameState> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<GameState> listIterator(int i) {
            return null;
        }

        @NonNull
        @Override
        public List<GameState> subList(int i, int i1) {
            return null;
        }
    };
        public List<GameState> getRanking() { return ranking;}

    private int numberScores;
        public int getNumberScores() {return numberScores;}
        public int numberScoresProperty() {return numberScores;}
        public void setNumberScores(int numberScores) {this.numberScores = numberScores;}

    /**
     * Set le score de base au lancement de la Partie
     */
    public ScoreRanking() {
        setNumberScores(10);
    }

    /**
     * Met a jour le Classement une fois que la partie est terminée
     * Prépare aussi la persistence
     * @param gameState GameState
     */
    public void updateRanking(GameState gameState) {

        if(getNumberScores() == 0){
            rankingObservable.clear();
            return;
        }

        if (!rankingObservable.isEmpty()) {
            if (rankingObservable.size() >= getNumberScores()) {
                Collections.sort(rankingObservable);
                GameState lowerState = rankingObservable.get(rankingObservable.size() - 1);
                if (lowerState != gameState) {
                    rankingObservable.remove(lowerState);
                }
            }
        }
        rankingObservable.add(gameState);
        if(rankingObservable.size() > 1){
            Collections.sort(rankingObservable);
        }
    }
}
