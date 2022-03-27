package fr.iut63.towerdefense.model.characters.tower;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import fr.iut63.towerdefense.model.Coordinate;
import fr.iut63.towerdefense.model.characters.Character;
import fr.iut63.towerdefense.model.characters.Projectile;

/**
 * Tour
 */
public abstract class Tower {
    private static final int BUILD_TIME_SECONDS = 2; //Temps de construction
    private static final int DEFAULT_SELL_COST = 25; //Prix de construction
    private final int attackDamage;
    private final int attackRange;

    private final List<Projectile> projectile = new List<Projectile>() {
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
        public Iterator<Projectile> iterator() {
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
        public boolean add(Projectile projectile) {
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
        public boolean addAll(@NonNull Collection<? extends Projectile> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, @NonNull Collection<? extends Projectile> collection) {
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
        public Projectile get(int i) {
            return null;
        }

        @Override
        public Projectile set(int i, Projectile projectile) {
            return null;
        }

        @Override
        public void add(int i, Projectile projectile) {

        }

        @Override
        public Projectile remove(int i) {
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
        public ListIterator<Projectile> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<Projectile> listIterator(int i) {
            return null;
        }

        @NonNull
        @Override
        public List<Projectile> subList(int i, int i1) {
            return null;
        }
    };

    private final Coordinate coordinate;
    private boolean attacker = true;
    private boolean build = false;


    /**
     * Création d'une Tower à une position X et Y sur la map
     * @param x int position X sur la map
     * @param y int position Y sur la map
     */
    public Tower(int x , int y){
        coordinate = new Coordinate(x , y);
        attackDamage = 5;
        attackRange = 200;
    }

    public int getBuildTimeSeconds() {
        return BUILD_TIME_SECONDS;
    }

    public boolean isBuild() {
        return build;
    }
    public void setBuild(boolean build) {
        this.build = build;
    }

    public int getX() {
        return coordinate.getExactX();
    }
    public int getY() {
        return coordinate.getExactY();
    }

    public int getAttackRange(){
        return attackRange;
    }

    public int getAttackDamage(){
        return  attackDamage;
    }

    public static int getDefaultSellCost(){
        return DEFAULT_SELL_COST;
    }

    public Coordinate getCoordinate(){
        return coordinate;
    }

    public boolean isAttacker() {
        return attacker;
    }
    public void setAttacker(boolean attacker) {
        this.attacker = attacker;
    }

    /**
     * Créé un projetctile et cible un Character
     * @param target Character ciblé
     */
    public void createProjectile(Character target){
        projectile.add(new Projectile(target , coordinate.getExactX() , coordinate.getExactY()));
    }

}
