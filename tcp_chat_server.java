import java.io.;import java.net.;
public class TCPServer{
  public static void main(String[]a) throws IOException {
    ServerSocket ss = new ServerSocket(3128);
    System.out.println("Server started");
    Socket s = ss.accept();
    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
    BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
    while(true){
      System.out.println("Client: "+in.readLine());
      System.out.print("Server: ");
      out.println(kb.readLine());
    }
  }
}