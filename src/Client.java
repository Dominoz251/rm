import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;


public class Client {
    private Client() {
    }

    public static void main(String[] args) {
        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry(null);

            // Looking up the registry for the remote object
//            Hello stub = (Hello) registry.lookup("Hello");
            Sarrus stub = (Sarrus) registry.lookup("Sarrus");


            // Calling the remote method using the obtained object
            stub.compute(generateArray());

            // System.out.println("Remote method invoked");
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
}