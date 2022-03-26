package fr.iut63.towerdefense.UI.util.save;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import fr.iut63.towerdefense.model.gamelogic.GameState;

public class FileLoader implements ILoad{
    @Nullable
    @Override
    public Serializable load(@NonNull FileInputStream file) {
        Serializable serializable = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(file)) {
            serializable  = (Serializable) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return serializable;
    }
}
