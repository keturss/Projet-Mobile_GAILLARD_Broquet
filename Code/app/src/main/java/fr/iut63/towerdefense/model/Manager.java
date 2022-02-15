package fr.iut63.towerdefense.model;


import fr.iut63.towerdefense.model.gamelogic.GameManager;
import fr.iut63.towerdefense.model.serialization.AdministratorPersistence;
import fr.iut63.towerdefense.model.serialization.AdministratorPersistenceBinary;

/**
 * Gestion de l'application
 */
public class Manager {
    private GameManager gameManager;
    private ScoreRanking scoreRanking;
    private AdministratorPersistence administratorPersistence;
    private String pseudo;

    public Manager(ScoreRanking scoreRanking){
        this.scoreRanking=scoreRanking;
        administratorPersistence = new AdministratorPersistenceBinary();
        //ScreenController.getStage().setOnCloseRequest(event -> saveStates());
        //administratorPersistence.load(scoreRanking);
        scoreRanking = new ScoreRanking();
    }

    /**
     * Sauvegarde le Score de la partie
     */
    public void saveStates(){
        administratorPersistence.save(scoreRanking);
    }

    public GameManager getGameManager() {return gameManager;}
    public void setGameManager(GameManager gameManager) {this.gameManager = gameManager;}

    public ScoreRanking getScoreRanking() {return scoreRanking;}

    public String getPseudo() {return pseudo;}
    public void setPseudo(String pseudo) {this.pseudo = pseudo;}
}
