import java.util.LinkedList;
import java.util.List;

public class SarrusImpl implements Sarrus{
    @Override
    public int[] compute(int[][] numbers) {
        List<AddThread> threads = new LinkedList<>();

        threads.add(new AddThread(new Operation("mult",
                numbers[0][0],
                numbers[1][1],
                numbers[2][2])));
        threads.add(new AddThread(new Operation("mult",
                numbers[0][1],
                numbers[1][2],
                numbers[2][0])));
        threads.add(new AddThread(new Operation("mult",
                numbers[0][2],
                numbers[1][1],
                numbers[2][0])));
        threads.add(new AddThread(new Operation("mult",
                numbers[0][2],
                numbers[1][1],
                numbers[2][0])));
        threads.add(new AddThread(new Operation("mult",
                numbers[0][0],
                numbers[1][2],
                numbers[2][1])));
        threads.add(new AddThread(new Operation("mult",
                numbers[0][1],
                numbers[1][0],
                numbers[2][2])));

        for (AddThread thread : threads) {
            thread.start();
        }

        for (AddThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return new int[0];
    }
}
