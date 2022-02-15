package fr.iut63.towerdefense.model.characters.monster;


import fr.iut63.towerdefense.model.characters.Character;

/**
 * Définit un Monster à partir d'un Character
 */
public class Monster extends Character {

    /**
     * Variable qui définit si le Monstre est visible ou non
     */
    private boolean visible = true;
        public boolean isVisible() {return visible;}
        public void setVisible(boolean visible) {this.visible = visible;}

    /**
     * Constructeur de Monstre
     * @param healthPoints  int Nombre Point de Vie
     * @param movementSpeed int Vitesse de Mouvement
     */
    public Monster(int healthPoints, int movementSpeed) {
        super(healthPoints,movementSpeed);
        setVisible(true);
    }

    /**
     *  Dommages reçus
     * @param damage int Valeur des dégats
     */
    public void takeDamage(int damage) {
        setHealthPoints(getHealthPoints() - damage);
        if (getHealthPoints() <= 0) {
            setDead(true);
            setPathFinished(false);
        }
    }
}
