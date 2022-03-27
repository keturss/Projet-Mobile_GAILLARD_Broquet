package fr.iut63.towerdefense.model.gameloop;

import java.util.LinkedList;

/**
 * Classe LoopListener
 */
public abstract class LoopListener {
    private final LinkedList<ILoopListener> observatory = new LinkedList<>();

    public void subscribe(ILoopListener listener){
        observatory.add(listener);
    }

    public void unsubscribe(ILoopListener listener){
        observatory.remove(listener);
    }

    /**
     * Notification de tout Observer sur la boucle
     * @param timer
     */
    protected void notify(int timer){
        for(ILoopListener observer : observatory){
            observer.update(timer);
        }
    }
}