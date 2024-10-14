package tonteriasMias;

import javax.smartcardio.TerminalFactory;
import javax.smartcardio.TerminalFactorySpi;

public class MeAburro {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(300);
            System.out.println("Me aburro " + i);
        }
    }
}
