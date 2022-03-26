package fr.iut63.towerdefense.UI.util.save;

import java.io.FileInputStream;
import java.io.Serializable;

public interface ILoad {
    Serializable load(FileInputStream file);
}
