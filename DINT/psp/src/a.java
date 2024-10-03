import javax.smartcardio.TerminalFactory;
import java.time.LocalDateTime;

public class a {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().getHour() + " " + LocalDateTime.now().getMinute());
        while (LocalDateTime.now().getHour() != 14 || LocalDateTime.now().getMinute() != 30) {
            System.out.println("Waiting for 14:30");
            System.out.println(LocalDateTime.now().getHour() + " " + LocalDateTime.now().getMinute() + " " + LocalDateTime.now().getSecond());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("It's 14:30");
    }
}
