package fr.iut63.towerdefense.model.gamelogic.action.tower;


import fr.iut63.towerdefense.model.characters.tower.ClassicTower;
import fr.iut63.towerdefense.model.characters.tower.Tower;
import fr.iut63.towerdefense.model.gamelogic.GameState;
import fr.iut63.towerdefense.model.gamelogic.action.IBuyer;
import fr.iut63.towerdefense.model.gamelogic.map.Map;

/**
 * Class permettant d'acheter des tours
 */
public class BuyerTower implements IBuyer {
    private final GameState game;
    private final Map gameMap;

    /**
     * Créé les services d'achat de tour sur la Map
     *
     * @param game    GamesState
     * @param gameMap Map
     */
    public BuyerTower(GameState game, Map gameMap) {
        this.game = game;
        this.gameMap = gameMap;
    }

    /**
     * Achat et placement d'une Tower en fonction de la fenêtre
     * @param xCords    double Position X sur la Fenetre
     * @param yCords    double Position Y sur la Fenetre
     */
    @Override
    public boolean buy(double xCords, double yCords) {
        int xTile =  (int) Math.floor(xCords / gameMap.getTileLengthX());
        int yTile = (int) Math.floor((yCords-87) / gameMap.getTileLengthY());          //-87 pour status bar


        if (gameMap.nodeOpen(xTile, yTile)) {
            Tower tower = new ClassicTower(xTile, yTile);
            if (game.getCoins() >= Tower.getDefaultSellCost()) {
                game.addTower(tower);
                game.setCoins(game.getCoins() - Tower.getDefaultSellCost());
                gameMap.setMapNode(xTile, yTile, 7);
                return true;
            }
        }
        return false;
    }
}
