import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Sarrus extends Remote {
    int[] compute(int numbers) throws RemoteException;
}
