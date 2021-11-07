public class AddThread extends Thread{
    private Operation operation;

    public AddThread(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void run() {
        System.out.println("Thread start running: " + operation);

        if(operation.getOperation() == "add") {
        } else if(operation.getOperation() == "mult") {

        } else if(operation.getOperation() == "sub") {

        }
    }
}
