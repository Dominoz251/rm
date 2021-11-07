public class Operation {
    private String operation;
    private int[] args;

    public Operation(String operation, int ...args) {
        this.operation = operation;
        this.args = args;
    }

    public int[] getArgs() {
        return args;
    }

    public String getOperation() {
        return operation;
    }
}
