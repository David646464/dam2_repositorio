package tonteriasMias;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MeAburro {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            a.add("hola" + Integer.toString(i));
        }
    }
}
