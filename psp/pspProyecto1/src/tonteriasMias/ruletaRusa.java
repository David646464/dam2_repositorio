package tonteriasMias;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class ruletaRusa {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int numeroAleatorio = random.nextInt(6) + 1;

        for (int i = 1; i < 7; i++) {
            System.out.println("Dispara");
            String numero = sc.nextLine();
            if (i == numeroAleatorio){
                System.out.println("Pummm");
                System.out.println("Moristes");
                throw new OutOfMemoryError();
            }else {
                System.out.println("Click");
                System.out.println("Te salvaste");
            }

        }

    }
}
