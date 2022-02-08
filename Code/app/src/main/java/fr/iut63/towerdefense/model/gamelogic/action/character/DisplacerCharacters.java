package fr.iut63.towerdefense.model.gamelogic.action.character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.iut63.towerdefense.model.characters.Character;
import fr.iut63.towerdefense.model.characters.monster.Monster;
import fr.iut63.towerdefense.model.gamelogic.GameState;
import fr.iut63.towerdefense.model.gamelogic.action.IDisplacer;
import fr.iut63.towerdefense.model.gamelogic.action.IRemover;
import fr.iut63.towerdefense.model.gamelogic.action.character.monster.RemoverMonster;
import fr.iut63.towerdefense.model.gamelogic.action.states.Updater;

/**
 * Déplaceur de caractères
 */
public class DisplacerCharacters implements IDisplacer {

    private GameState game;
    private IRemover remover;

    public DisplacerCharacters(GameState game) {this.game = game;}

    /**
     * Modifie la position de tous les Character dans Observable List -> GameState
     * @return
     */
    @Override
    public boolean updateLocations() {
        ArrayList<Character> charactersEnd = new ArrayList<>();
        List<Character> listCharacters = game.getCharactersAlive();
        if (!listCharacters.isEmpty()) {
            Iterator<Character> characterIterator = listCharacters.iterator();
            Character character;
            while (characterIterator.hasNext()) {
                character = characterIterator.next();
                character.updateLocation();
                if (character.isPathFinished()) {
                    Updater.updateStates(character, game);
                    charactersEnd.add(character);
                    if (game.getLives() == 0) {
                        return false;
                    }
                }
            }
            for (Character characterDelete : charactersEnd) {
                if(characterDelete instanceof Monster){
                    remover = new RemoverMonster(game);
                }
                remover.remove(characterDelete);
            }
        }
        return true;
    }
}
