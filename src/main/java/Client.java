import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String host = "localhost";
        int port = 8645;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader( new
                     InputStreamReader(clientSocket.getInputStream()))) {
            out.println("vasya");
            String resp = in.readLine();
            System.out.println(resp);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
