public class AgentImpl implements AddAgent {

    public AgentImpl() {
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int multiple(int a, int b) {
        return a * b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }
}
