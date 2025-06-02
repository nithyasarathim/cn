import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to the server.");

            // Input/output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage, serverMessage;

            while (true) {
                System.out.print("Client: ");
                clientMessage = clientInput.readLine();
                out.println(clientMessage);

                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }

                serverMessage = in.readLine();
                if (serverMessage == null || serverMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Server disconnected.");
                    break;
                }

                System.out.println("Server: " + serverMessage);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
