package http;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {

	public static void main(String[] args) {			
		try (MulticastSocket socket = new MulticastSocket(8888);) {
			DatagramPacket datagramPacket = null;
			byte[] inBuf = new byte[256];
			InetAddress ip = InetAddress.getByName("224.2.2.3");
			socket.joinGroup(ip);
			
			while(true) {
				datagramPacket = new DatagramPacket(inBuf, inBuf.length);
				socket.receive(datagramPacket);
				String msg = new String(inBuf, 0 , datagramPacket.getLength());
				System.out.println("From "+ datagramPacket.getAddress()+" - Msg: "+msg);
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
