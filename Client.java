import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        private static int PORT = 5000;
        Socket socket;
        BufferedReader reader;
        PrintWriter writer;
        Scanner scanner;

        try {
            socket = new Socket("localhost", PORT);
            System.out.println("Connected to server");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
            scanner = new Scanner(System.in);
            System.out.println("I/O ready");
            
            String line = "";

            while(!line.equals("exit")) {
                System.out.printf("> ");
                line = scan.nextLine();
                writer.println(line);
                writer.flush();
                System.out.println(reader.readLine());
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}