package fr.iut63.towerdefense.model.gamelogic.action.tower;


import static java.lang.Thread.sleep;

import fr.iut63.towerdefense.model.characters.tower.Tower;

/**
 * Classe permettant de faire attendre la tour durant le temps de construction
 */
public class WaitingBuild implements Runnable{
    private final Tower tower;

    /**
     * Créé une attente pour une construction de Tour
     * @param t
     */
    public WaitingBuild(Tower t){
        tower = t;
    }

    /**
     * Vérifie si la Tower est en construction et définit si elle est libre pour attaquer
     */
    @Override
    public void run() {
        try {
            if (!tower.isBuild()) {
                sleep(tower.getBuildTimeSeconds() * 1000L);        // conversion Second to Millis
                tower.setBuild(true);
            } else {
                tower.setAttacker(false);
                sleep(2000);
                tower.setAttacker(true);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
