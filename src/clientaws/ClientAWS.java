package clientaws;

/**
 *
 * @author carlo
 */
public class ClientAWS {
    
    private static ClientThread[] threads;

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        int nThreads = Integer.parseInt(args[1]);
        threads = new ClientThread[nThreads];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ClientThread(i+1, args[0]);
        }
        long initialTime = System.currentTimeMillis();
        for (ClientThread ct : threads) {
            ct.start();
        }
        for (ClientThread ct : threads) {
            ct.join();
        }
        long finalTime = System.currentTimeMillis();
        System.out.println("Total Time: " + (finalTime - initialTime) + " --> Requests: " + nThreads);
    }

}
