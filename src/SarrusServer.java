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
            OperationAgent stub = (OperationAgent) UnicastRemoteObject.exportObject(obj, Integer.parseInt(args[0]));


            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Agent_" +args[0], stub);
            System.err.println("Agent "+ args[0] + " ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
