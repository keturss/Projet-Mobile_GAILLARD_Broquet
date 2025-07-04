package fr.iut63.towerdefense.model;



/**
 * Coordonnées
 */
public class Coordinate {

    private int x;
        public int getX() {return x;}
        public int xProperty() {return x;}
        public void setX(int x) {this.x = x ;}
    private int y;
        public int getY() {return y;}
        public int yProperty() {return y;}
        public void setY(int y) {this.y = y ;}

    /**
     * Coordonée sur la map
     * @param x int Position X
     * @param y int Position Y
     */
    public Coordinate(int x , int y){
        setX(x);
        setY(y);
    }

    /**
     * Accède a la position X exacte sur la fenêtre
     * @return int Position X
     */
    public int getExactX() {
        return getX() * 64 + 32;
    }

    /**
     * Accède a la position Y exacte sur la fenêtre
     * @return  int Position Y
     */
    public int getExactY() {
        return getY() * 64 + 32;
    }

    public boolean equals(Coordinate obj) {
        return this.x == obj.x && this.y == obj.y;
    }
}
