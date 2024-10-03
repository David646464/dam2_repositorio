import java.util.Timer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String s = "Hello";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 219000000; i++) {
            sb.append(i).append(" ");
            //s += i + " ";
        }
        long end2 = System.currentTimeMillis();
        System.out.println(sb);

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms");
        System.out.println("Time: " + (end2 - start) + " ms");



    }
}