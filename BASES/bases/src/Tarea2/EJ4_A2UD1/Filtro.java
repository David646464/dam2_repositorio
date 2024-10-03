package Tarea2.EJ4_A2UD1;

import java.io.File;
import java.io.FileFilter;

public class Filtro implements FileFilter {
    String extension;


    public Filtro(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(extension);
    }
}
