package tonteriasMias;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            System.out.println(new Random().nextInt(-80,80));
        }
    }
}