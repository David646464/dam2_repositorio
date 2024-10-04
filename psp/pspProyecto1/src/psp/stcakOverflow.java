package psp;

public class stcakOverflow {

    public static void main(String[] args) {
        runa(0);
    }

    private static void runa(int i) {
        try {
            i++;
            runb(i);
        }catch (StackOverflowError e){
            System.out.println(i);
        }

    }

    private static void runb(int i) {
        try {
            i++;
            runa(i);
        }catch (StackOverflowError e){
            System.out.println(i);
        }
    }


}
