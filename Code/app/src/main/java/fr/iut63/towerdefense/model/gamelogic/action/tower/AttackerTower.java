package fr.iut63.towerdefense.model.gamelogic.action.tower;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import fr.iut63.towerdefense.model.characters.monster.Monster;
import fr.iut63.towerdefense.model.characters.Character;
import fr.iut63.towerdefense.model.characters.tower.Tower;
import fr.iut63.towerdefense.model.gamelogic.action.IAttacker;

/**
 * Classe permettant aux tours d'attaquer
 */
public class AttackerTower implements IAttacker {
    private List<Tower> listTower = new List<Tower>() {
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
    private List<Character> listCharacter = new List<Character>() {
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

    /**
     * Créé le système d'attaque des Tours sur les Characters
     * @param listTower
     * @param listCharacter
     */
    public AttackerTower(List<Tower> listTower, List<Character> listCharacter) {
        this.listTower = listTower;
        this.listCharacter = listCharacter;
    }


    /**
     * Verifie quel monstre est dans la portée de la Tour pour l'attaquer
     * Si plusieurs monstres sont dans la portée, la Tour attaquera le premier Character de la liste
     */
    public void attack() {
        Character target;
        WaitingBuild attackService;

        for (Tower tower : listTower) {
            if (tower.isAttacker()) {
                int towerMinXRange = tower.getX() - tower.getAttackRange();
                int towerMaxXRange = tower.getX() + tower.getAttackRange();
                int towerMinYRange = tower.getY() - tower.getAttackRange();
                int towerMaxYRange = tower.getY() + tower.getAttackRange();

                for (Character character : listCharacter) {
                    target = character;
                    if (target.getX() < towerMaxXRange & target.getX() > towerMinXRange & target.getY() > towerMinYRange & target.getY() < towerMaxYRange) {
                        attackService = new WaitingBuild(tower);
                        Thread t = new Thread(attackService);
                        t.start();
                        if (tower.isBuild()) {
                            tower.createProjectile(target);
                            if (target instanceof Monster) {
                                ((Monster) target).takeDamage(tower.getAttackDamage());
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
