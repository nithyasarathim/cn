import java.net.*;

public class UDPEchoServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(4550);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        socket.receive(packet); // receive message
        socket.send(new DatagramPacket(packet.getData(), packet.getLength(), packet.getAddress(), packet.getPort())); // echo back

        socket.close();
    }
}
