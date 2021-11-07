import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddThread extends Thread {
    private Operation operation;
    private int result;

    public AddThread(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void run() {
        System.out.println("Thread start running: " + operation);
        ProcessBuilder processBuilder = new ProcessBuilder("G:/SEM7/ObliczeniaRownolegleIRozproszone/L1/rm/src/addAgent.bat ",
                 operation.getOperation()
                + " "
                + operation.getArg1()
                + " "
                + operation.getArg2()
        );
        System.out.println("Executing thread");
        try {
            Process process = processBuilder.start();
//            StringBuilder output = new StringBuilder();
//            System.out.println("Proces input stream " + process.getInputStream());
//
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                output.append(line + "\n");
//            }
//
//            int exitVal = process.waitFor();
//            if (exitVal == 0) {
//                System.out.println("Agent result: " + output);
//                System.exit(0);
//            }
//            this.result = Integer.getInteger(output.toString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int getResult() {
        return result;
    }
}
