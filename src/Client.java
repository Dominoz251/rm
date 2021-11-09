import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Random;


public class Client {
    private Client() {
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null);


            Sarrus stub = (Sarrus) registry.lookup("Sarrus");

            int[][] tab = generateArray();
            System.out.println(Arrays.deepToString(tab));

            long start = System.currentTimeMillis();
            int result = sub(add(add(mult(mult(tab[0][0], tab[1][1]), tab[2][2]), mult(mult(tab[0][1], tab[1][2]), tab[2][0])), mult(mult(tab[0][2], tab[1][0]), tab[2][1])),
                    add(add(mult(mult(tab[0][2], tab[1][1]), tab[2][0]), mult(mult(tab[0][0], tab[1][2]), tab[2][1])), mult(mult(tab[0][1], tab[1][0]), tab[2][2])));
            System.out.println("Normal result: " + result);
            long finish = System.currentTimeMillis();
            long timeElapsed = finish - start;
            System.out.println("Normal time: "+ timeElapsed);



            long startRMI = System.currentTimeMillis();
            System.out.println("RMI result: "+stub.compute(tab));
            long finishRMI = System.currentTimeMillis();
            long timeElapsedRMI = finishRMI - startRMI;
            System.out.println("RMI time: "+ timeElapsedRMI);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private static int[][] generateArray() {
        Random rand = new Random();
        int[][] array = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = rand.nextInt(20);
            }
        }
        return array;
    }

    static int mult(int a, int b) throws InterruptedException {
        Thread.sleep(1000);
        return a*b;
    }

    static int add(int a, int b) throws InterruptedException {
        Thread.sleep(1000);
        return a+b;
    }

    static int sub(int a, int b) throws InterruptedException {
        Thread.sleep(1000);
        return a-b;
    }
}