import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SarrusServer {
    public SarrusServer() {
    }

    public static void main(String args[]) {
        try {

            AgentImpl obj = new AgentImpl();


            OperationAgent stub = (OperationAgent) UnicastRemoteObject.exportObject(obj, Integer.parseInt(args[0]));


            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Agent_" +args[0], stub);
            System.err.println("Agent "+ args[0] + " ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
