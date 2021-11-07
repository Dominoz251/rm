public class AgentImpl implements AddAgent {
    @Override
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    @Override
    public int multiple(int a, int b, int c) {
        return a * b * c;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }
}
