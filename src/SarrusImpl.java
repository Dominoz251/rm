import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

public class SarrusImpl  implements Sarrus{

    public SarrusImpl() {
    }

    @Override
    public int[] compute(int number) {
        List<AddThread> threads = new LinkedList<>();
//        int[] array = {numbers};
        int[][] numbers = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        System.out.println(number);



        threads.add(new AddThread(new Operation("add",
                numbers[0][0],
                numbers[1][1])));
        threads.get(0).start();

        try {
            threads.get(0).join();
            System.out.println("Thread result" + threads.get(0).getResult());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new int[1];
//        threads.add(new AddThread(new Operation("mult",
//                numbers[0][1],
//                numbers[1][2],
//                numbers[2][0])));
//        threads.add(new AddThread(new Operation("mult",
//                numbers[0][2],
//                numbers[1][1],
//                numbers[2][0])));
//        threads.add(new AddThread(new Operation("mult",
//                numbers[0][2],
//                numbers[1][1],
//                numbers[2][0])));
//        threads.add(new AddThread(new Operation("mult",
//                numbers[0][0],
//                numbers[1][2],
//                numbers[2][1])));
//        threads.add(new AddThread(new Operation("mult",
//                numbers[0][1],
//                numbers[1][0],
//                numbers[2][2])));
//
//        for (AddThread thread : threads) {
//            thread.start();
//        }
//
//        for (AddThread thread : threads) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

//        return new int[0];
    }
}
