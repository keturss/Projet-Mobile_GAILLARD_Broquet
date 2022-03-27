package fr.iut63.towerdefense.model.gamelogic;


import fr.iut63.towerdefense.model.gamelogic.action.ILevel;
import fr.iut63.towerdefense.model.gameloop.Loop;

/**
 * Classe permettant de vérifier la victoire ou la partie perdu
 */
public class AdministratorVictoryGameOver {

    private final GameState game;
    private final Loop loop;
    private final ILevel enemyFile;

    public AdministratorVictoryGameOver(GameState game, ILevel level, Loop boucle) {
        this.game = game;
        this.loop = boucle;
        this.enemyFile = level;
    }

    /**
     * Vérifie si l'état de la partie est une victoire
     */
    public void verifyVictory() {
        if(enemyFile instanceof AdministratorLevel) {
            if (!((AdministratorLevel) enemyFile).getLevelFile().hasNextLine() && game.getCharactersAlive().isEmpty() && loop.isRunning()) {
                loop.setRunning(false);
                game.setVictory(true);
            }
        }
    }

    /**
     * Verifie si l'Etat de la partie est une Defaite
     * @param value none
     */
    public void verifyGameOver(boolean value){
        if(!value) return;
        game.setRemoveCharacter(true);
        game.getCharactersAlive().clear();
        loop.setRunning(false);
        game.setGameOver(true);
    }
}
