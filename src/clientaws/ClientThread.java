package clientaws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author carlo
 */
public class ClientThread extends Thread {

    private int id;
    private URL url;

    public ClientThread(int id, String urlArgs) throws Exception {
        this.id = id;
        this.url = new URL(urlArgs);
    }

    @Override
    public void run() {
        System.out.println("ClientThread --> " + id);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

}
