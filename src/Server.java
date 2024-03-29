import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public Server() {
    }

    public static void main(String args[]) {
        try {

            SarrusImpl obj = new SarrusImpl();

            Sarrus stub = (Sarrus) UnicastRemoteObject.exportObject(obj, 0);


            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Sarrus", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}