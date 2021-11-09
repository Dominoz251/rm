import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperationAgent extends Remote {

    int add(int a, int b) throws RemoteException;

    int multiple(int a, int b) throws RemoteException;

    int sub(int a, int b) throws RemoteException;
}
