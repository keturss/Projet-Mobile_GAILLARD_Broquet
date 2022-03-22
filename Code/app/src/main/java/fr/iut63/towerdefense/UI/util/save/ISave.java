package fr.iut63.towerdefense.UI.util.save;

import java.io.FileOutputStream;
import java.io.Serializable;

public interface ISave {

    void save(FileOutputStream file, Serializable toSave);
}
