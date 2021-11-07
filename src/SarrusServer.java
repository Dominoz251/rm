import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SarrusServer {
    public SarrusServer() {
    }

    public static void main(String args[]) {
        try {
            // Instantiating the implementation class
//            ImplExample obj = new ImplExample();
            AgentImpl obj = new AgentImpl();

            // Exporting the object of implementation class
            // (here we are exporting the remote object to the stub)
//            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
            AddAgent stub = (AddAgent) UnicastRemoteObject.exportObject(obj, 1);


            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.getRegistry();

            registry.bind("AddAgent", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
