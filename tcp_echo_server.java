import java.io.;import java.net.;
public class EchoServer{
  public static void main(String[]a)throws IOException{
    Socket s=new ServerSocket(1234).accept();
    BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
    PrintWriter out=new PrintWriter(s.getOutputStream(),true);
    while(true){
      String msg = in.readLine();
      System.out.println("Client: " + msg); 
      out.println("Echo: " + msg);
    }
  }
}