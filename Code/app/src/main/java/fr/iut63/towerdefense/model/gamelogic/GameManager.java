package fr.iut63.towerdefense.model.gamelogic;


import fr.iut63.towerdefense.model.characters.Character;
import fr.iut63.towerdefense.model.gamelogic.action.IAttacker;
import fr.iut63.towerdefense.model.gamelogic.action.IDisplacer;
import fr.iut63.towerdefense.model.gamelogic.action.ILevel;
import fr.iut63.towerdefense.model.gamelogic.action.ISpawner;
import fr.iut63.towerdefense.model.gamelogic.action.character.DisplacerCharacters;
import fr.iut63.towerdefense.model.gamelogic.action.character.SpawnerCharacter;
import fr.iut63.towerdefense.model.gamelogic.action.states.Updater;
import fr.iut63.towerdefense.model.gamelogic.action.tower.AttackerTower;
import fr.iut63.towerdefense.model.gamelogic.map.Map;
import fr.iut63.towerdefense.model.gameloop.ILoopListener;
import fr.iut63.towerdefense.model.gameloop.Loop;

/**
 * Classe qui gère la partie
 */
public class GameManager implements ILoopListener {

    private final Map gameMap;
    private final GameState game;
    private final Loop loop;
    private final IDisplacer displacer;
    private final AdministratorVictoryGameOver administratorVictoryGameOver;
    private final ISpawner spawner;
    private final IAttacker attacker;
    private final ILevel levelNext;

    /**
     * Creation d'un gameManager et de tout ses éléments
     *
     * @param pseudo String Pseudo representant le Player
     * @param map    Map a dessiner
     */
    public GameManager(String pseudo, Map map) {
        this.gameMap = map;
        game = new GameState(pseudo);
        Character.setPath(gameMap.getPath());
        loop = new Loop();
        loop.subscribe(this);
        displacer = new DisplacerCharacters(game);
        levelNext = new AdministratorLevel(game);
        administratorVictoryGameOver = new AdministratorVictoryGameOver(game, levelNext, loop);
        spawner = new SpawnerCharacter(game, levelNext);
        attacker = new AttackerTower(game.getPlayerTowers(), game.getCharactersAlive());
    }

    public Loop getLoop(){ return loop; }

    public GameState getGame() {
        return game;
    }

    public Map getGameMap() {return gameMap;}

    /**
     * Démarre la boucle de jeu
     */
    public void start() {
        loop.setRunning(true);
        Thread boucleThread = new Thread(loop);
        boucleThread.start();
    }

    /**
     * Update à chaque tour de boucle
     * @param timer int Timer de la boucle de Jeu
     */
    @Override
    public void update(int timer) {
        if (loop.isRunning()) {
            Updater.updateTimerSeconds(timer, Loop.getDefaultMillis(), game);

            //administratorVictoryGameOver.verifyVictory();

            //spawner.spawn(timer);

            //administratorVictoryGameOver.verifyGameOver(!displacer.updateLocations());

            //attacker.attack();
        }
    }
}
