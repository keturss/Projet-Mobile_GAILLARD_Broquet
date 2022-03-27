package fr.iut63.towerdefense.UI.util.save;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Persitence profonde file save
 */
public class FileSaver implements ISave {

    @Override
    public void save(FileOutputStream file, Serializable toSave) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(file)) {
            objectOutputStream.writeObject(toSave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
