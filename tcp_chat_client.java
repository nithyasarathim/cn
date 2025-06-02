import java.io.;import java.net.;
public class TCPClient{
  public static void main(String[]a) throws IOException {
    Socket s = new Socket("localhost",3128);
    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
    BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
    while(true){
      System.out.print("Client: ");
      out.println(kb.readLine());
      System.out.println("Server: "+in.readLine());
    }
  }
}