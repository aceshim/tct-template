import java.io.*;
import java.net.*;
import java.lang.Thread;

public class Server {
  public static void main (String[] args) {
    private static int PORT = 5566;
    try {
      ServerSocket server = new ServerSocket(PORT);
      while (true) {
        Socket client = server.accept();
        ClientHandler handler = new ClientHandler(client);
        handler.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class ClientHandler extends Thread {
  Socket client;
  ClientHandler (Socket client) {
    this.client = client;
  }

  public void run () {
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
      PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
      writer.println("[type 'bye' to disconnect]");

      String line = "";
      while (!(line = reader.readLine()).equals(null)) {
        if (line.trim().equals("bye")) {
          writer.println("bye!");
          break;
        }
        writer.println("[echo] " + line);
        writer.flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try { 
        if (client != null ){
          client.close(); 
        }
      } catch ( IOException e ){
        e.printStackTrace();
      }
    }
  }

  public static String getTime() {
    String threadName = Thread.currentThread().getName();
    SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
    return f.format(new Date()) + threadName;
  }

  public static void sleep(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}