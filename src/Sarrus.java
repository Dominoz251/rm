import java.rmi.Remote;

public interface Sarrus extends Remote {
    int[] compute(int[][] numbers);
}
