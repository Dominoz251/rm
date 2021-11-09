import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Objects;

public class Agent {
    public Agent() {
    }

    public static void main(String[] args) {
        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry(null);

            // Looking up the registry for the remote object
//            Hello stub = (Hello) registry.lookup("Hello");
            OperationAgent stub = (OperationAgent) registry.lookup("Agent_" +Integer.parseInt(args[3]));


            // Calling the remote method using the obtained object
            if(Objects.equals(args[0], "add")) {
                System.out.println("To jest wynik: " + stub.add(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
            } else if (Objects.equals(args[0], "multiple")) {
                System.out.println("To jest wynik: " + stub.multiple(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
            } else if (Objects.equals(args[0], "sub")){
                System.out.println("To jest wynik: " + stub.sub(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
            }

            // System.out.println("Remote method invoked");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
