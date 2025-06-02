import java.net.*;

public class UDPEchoClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        byte[] msg = "Hello".getBytes();
        InetAddress addr = InetAddress.getByName("localhost");
        socket.send(new DatagramPacket(msg, msg.length, addr, 4550));
        byte[] buf = new byte[1024];
        DatagramPacket reply = new DatagramPacket(buf, buf.length);
        socket.receive(reply);
        System.out.println("Reply: " + new String(reply.getData(), 0, reply.getLength()));
        socket.close();
    }
}
