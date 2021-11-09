import java.util.*;

public class SarrusImpl implements Sarrus {

    List<Integer> results = new ArrayList<Integer>();
    public SarrusImpl() {
    }

    @Override
    public int compute(int[][] tab) throws RuntimeException{
        System.out.println(Arrays.deepToString(tab));

        LinkedList<OperationThread> threads = new LinkedList<>();

        //pierwsze 6 mnożeń
        OperationThread t0 = new OperationThread(new Operation(tab[0][0], tab[1][1], "multiple", 1));
        OperationThread t1 = new OperationThread(new Operation(tab[0][1], tab[1][2], "multiple", 2));
        OperationThread t2 = new OperationThread(new Operation(tab[0][2], tab[1][0], "multiple", 3));
        OperationThread t3 = new OperationThread(new Operation(tab[0][2], tab[1][1], "multiple", 4));
        OperationThread t4 = new OperationThread(new Operation(tab[0][0], tab[1][2], "multiple", 5));
        OperationThread t5 = new OperationThread(new Operation(tab[0][1], tab[1][0], "multiple", 6));

        Collections.addAll(threads, t0, t1, t2, t3, t4, t5);

        for (int i = 0; i < 6; i++) {
            threads.get(i).start();
        }

        for (OperationThread thread : threads) {
            try {
                thread.join();
                results.add(thread.getResult());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //drugie 6 mnożeń
        t0 = new OperationThread(new Operation(results.get(0), tab[2][2], "multiple", 1));
        t1 = new OperationThread(new Operation(results.get(1), tab[2][0], "multiple", 2));
        t2 = new OperationThread(new Operation(results.get(2), tab[2][1], "multiple", 3));
        t3 = new OperationThread(new Operation(results.get(3), tab[2][0], "multiple", 4));
        t4 = new OperationThread(new Operation(results.get(4), tab[2][1], "multiple", 5));
        t5 = new OperationThread(new Operation(results.get(5), tab[2][2], "multiple", 6));

        threads.clear();

        Collections.addAll(threads, t0, t1, t2, t3, t4, t5);

        for (int i = 0; i < 6; i++) {
            threads.get(i).start();
        }

        results.clear();

        for (OperationThread thread : threads) {
            try {
                thread.join();
                results.add(thread.getResult());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //pierwsze 2 dodawania
        t0 = new OperationThread(new Operation(results.get(0), results.get(1), "add", 1));
        t1 = new OperationThread(new Operation(results.get(3), results.get(4), "add", 2));

        threads.clear();

        Collections.addAll(threads, t0, t1);

        for (int i = 0; i < 2; i++) {
            threads.get(i).start();
        }

        try {
            threads.get(0).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        results.set(0, threads.get(0).getResult());

        try {
            threads.get(1).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        results.set(1, threads.get(1).getResult());

        //drugie 2 dodawania
        t0 = new OperationThread(new Operation(results.get(0), results.get(2), "add", 1));
        t1 = new OperationThread(new Operation(results.get(1), results.get(5), "add", 2));

        threads.clear();

        Collections.addAll(threads, t0, t1);

        for (int i = 0; i < 2; i++) {
            threads.get(i).start();
        }

        try {
            threads.get(0).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        results.set(0, threads.get(0).getResult());

        try {
            threads.get(1).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        results.set(1, threads.get(1).getResult());

        t0 = new OperationThread(new Operation(results.get(0), results.get(1), "sub", 1));
        t0.start();
        try {
            t0.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return t0.getResult();
    }
}
