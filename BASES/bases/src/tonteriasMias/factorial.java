package tonteriasMias;

import java.time.LocalDateTime;

public class factorial {
    public static void main(String[] args) {
        long tiempoEmpieza = LocalDateTime.now().getNano();
        factorialDe(2000);
        long tiempoTermina = LocalDateTime.now().getNano() - tiempoEmpieza;
        System.out.println(tiempoTermina);
    }

    private static int factorialDe(int i) {
        if (i == 1 || i== 0) return 1;
        return  i * factorialDe(i-1);
    }
}
