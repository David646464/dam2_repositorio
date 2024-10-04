package psp;

import java.util.StringTokenizer;

public class prueba {
    public static void main(String[] args) {
        for (StringTokenizer stringTokenizer = new StringTokenizer("Casa"); stringTokenizer.hasMoreTokens(); ) {
            String s = stringTokenizer.nextToken();
            System.out.println(s);

        }
    }
}
