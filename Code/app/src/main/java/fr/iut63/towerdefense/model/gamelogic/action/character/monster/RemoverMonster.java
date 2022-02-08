package fr.iut63.towerdefense.model.gamelogic.action.character.monster;

import fr.iut63.towerdefense.model.characters.monster.Monster;
import fr.iut63.towerdefense.model.characters.Character;
import fr.iut63.towerdefense.model.gamelogic.GameState;
import fr.iut63.towerdefense.model.gamelogic.action.IRemover;


/**
 * Classe pour supprimer des monstres
 */
public class RemoverMonster implements IRemover {
    private GameState game;

    public RemoverMonster(GameState game) {
        this.game = game;
    }

    /**
     * Supprime un Character dans l'ObservableList<Characters> de la GameState
     * @param character Character (Monster)
     */
    @Override
    public void remove(Character character) {
        Monster monster = (Monster) character;
        game.setRemoveCharacter(true);
        game.getCharactersAlive().remove(monster);
        monster.setVisible(false);
        game.setRemoveCharacter(false);
    }
}
