import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for a client to connect...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Input/output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));

            // Communication loop
            String clientMessage, serverMessage;

            while (true) {
                clientMessage = in.readLine();
                if (clientMessage == null || clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                System.out.println("Client: " + clientMessage);

                System.out.print("Server: ");
                serverMessage = serverInput.readLine();
                out.println(serverMessage);

                if (serverMessage.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
