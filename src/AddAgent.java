import java.rmi.Remote;

public interface AddAgent extends Remote {

    int add(int a, int b, int c);

    int multiple(int a, int b, int c);

    int sub(int a, int b);
}
