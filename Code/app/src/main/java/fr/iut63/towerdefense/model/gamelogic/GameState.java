package fr.iut63.towerdefense.model.gamelogic;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import fr.iut63.towerdefense.model.characters.Character;
import fr.iut63.towerdefense.model.characters.tower.Tower;

/**
 * States relatifs à la partie
 */
public class GameState implements Comparable<GameState>{

    private final List<Tower> playerTowers = new List<Tower>() {
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
        public Iterator<Tower> iterator() {
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
        public boolean add(Tower tower) {
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
        public boolean addAll(@NonNull Collection<? extends Tower> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, @NonNull Collection<? extends Tower> collection) {
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
        public Tower get(int i) {
            return null;
        }

        @Override
        public Tower set(int i, Tower tower) {
            return null;
        }

        @Override
        public void add(int i, Tower tower) {

        }

        @Override
        public Tower remove(int i) {
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
        public ListIterator<Tower> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<Tower> listIterator(int i) {
            return null;
        }

        @NonNull
        @Override
        public List<Tower> subList(int i, int i1) {
            return null;
        }
    };
    private final List<Character> charactersAlive = new List<Character>() {
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
        public Iterator<Character> iterator() {
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
        public boolean add(Character character) {
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
        public boolean addAll(@NonNull Collection<? extends Character> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, @NonNull Collection<? extends Character> collection) {
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
        public Character get(int i) {
            return null;
        }

        @Override
        public Character set(int i, Character character) {
            return null;
        }

        @Override
        public void add(int i, Character character) {

        }

        @Override
        public Character remove(int i) {
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
        public ListIterator<Character> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<Character> listIterator(int i) {
            return null;
        }

        @NonNull
        @Override
        public List<Character> subList(int i, int i1) {
            return null;
        }
    };
    private boolean speed = false;
    private boolean removeCharacter = false;
    private String pseudo = new String();
        public String getPseudo() {return pseudo;}
        public String pseudoProperty() {return pseudo;}
        public void setPseudo(String pseudo) {this.pseudo = pseudo;}
    private int timeSeconds ;
        public int getTimeSeconds() {return timeSeconds;}
        public int timeSecondsProperty() {return timeSeconds;}
        public void setTimeSeconds(int timeSeconds) {this.timeSeconds = timeSeconds;}
    private Boolean gameOver;
        public boolean isGameOver() {return gameOver;}
        public Boolean gameOverProperty() {return gameOver;}
        public void setGameOver(boolean gameOver) {this.gameOver = gameOver;}
    private Boolean victory = new Boolean(false);
        public boolean isVictory() {return victory;}
        public Boolean victoryProperty() {return victory;}
        public void setVictory(boolean victory) {this.victory =victory;}
    private int level ;
        public int getLevel() {return level;}
        public int levelProperty() {return level;}
        public void setLevel(int level) {this.level = level;}
    private int lives;
        public int getLives(){return lives;}
        public int livesProperty() {return lives;}
        public void setLives(int lives){this.lives = lives;}
    private int coins ;
        public int getCoins() {return coins;}
        public int coinsProperty() {return coins;}
        public void setCoins(int coins) {this.coins = coins;}
    private int score ;
        public int getScore() {return score;}
        public int scoreProperty() {return score;}
        public void setScore(int score) {this.score = score;}

    /**
     * Ressources du joueur et states de la Partie
     * @param pseudo    String Pseudo
     */
    public GameState(String pseudo){
        setPseudo(pseudo);
        setTimeSeconds(0);
        setCoins(50);
        setLevel(1);
        setScore(0);
        setLives(2);
        setVictory(false);
    }

    public boolean isRemoveCharacter() {return removeCharacter;}
    public void setRemoveCharacter(boolean value){
        removeCharacter = value;}

    public boolean isSpeed() {return speed;}
    public void setSpeed(boolean speed) {this.speed = speed;}

    public List<Tower> getPlayerTowers(){
        return playerTowers;
    }
    public List<Character> getCharactersAlive() {
        return charactersAlive;
    }

    public void addTower(Tower tower){playerTowers.add(tower);}

    @Override
    public int compareTo(GameState g) {
        int coeff = g.isGameOver() ? 100 : 1;

        if(this.getPseudo().compareTo(g.getPseudo()) == 0) {
            return ((this.getLevel() - g.getLevel()*coeff) +
                    (this.getScore() - g.getScore()) +
                    (this.getTimeSeconds()) - g.getTimeSeconds());
        }
        else{
            return ((this.getLevel() - g.getLevel()*coeff) +
                    (this.getScore() - g.getScore()) +
                    (this.getTimeSeconds()) - g.getTimeSeconds() +
                    this.getPseudo().compareTo(g.getPseudo()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameState gameState = (GameState) o;
        return pseudo.equals(gameState.pseudo) && timeSeconds == gameState.timeSeconds && victory.equals(gameState.victory) && level == gameState.level && score == gameState.score;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(pseudo, timeSeconds, victory, level, score);
    }
}
