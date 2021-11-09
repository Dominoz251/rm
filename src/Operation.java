public class Operation {
    private String operation;
    private int arg1;
    private int arg2;
    private int port;

    public Operation(int arg1, int arg2, String operation, int port) {
        this.operation = operation;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.port = port;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getArg1() {
        return arg1;
    }

    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    public int getArg2() {
        return arg2;
    }

    public void setArg2(int arg2) {
        this.arg2 = arg2;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
