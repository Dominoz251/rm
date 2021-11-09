import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Objects;

public class OperationThread extends Thread {
    private Operation operation;
    private int result;

    public OperationThread(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void run() {
        try {
            Registry registry = LocateRegistry.getRegistry(null);

            OperationAgent stub = (OperationAgent) registry.lookup("Agent_" + operation.getPort());


            if (Objects.equals(operation.getOperation(), "add")) {
                result = stub.add(operation.getArg1(), operation.getArg2());
                printOperation(operation.getArg1(),
                        operation.getArg2(),
                        operation.getOperation(),
                        operation.getPort(),
                        result);
            } else if (Objects.equals(operation.getOperation(), "multiple")) {
                result = stub.multiple(operation.getArg1(), operation.getArg2());
                printOperation(operation.getArg1(),
                        operation.getArg2(),
                        operation.getOperation(),
                        operation.getPort(),
                        result);
            } else if (Objects.equals(operation.getOperation(), "sub")) {
                result = stub.sub(operation.getArg1(), operation.getArg2());
                printOperation(operation.getArg1(),
                        operation.getArg2(),
                        operation.getOperation(),
                        operation.getPort(),
                        result);
            }

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private void printOperation(int a, int b, String operation, int agent, int result) {
        System.out.println("Agent_" + agent + ": " + a + " " + operation + " " + b + " = " + result);
    }

    public int getResult() {
        return result;
    }
}
