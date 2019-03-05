package http;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramReceiver {
	public static void main(String[] args) {
		try(DatagramSocket datagramSocket = new DatagramSocket(3000);){
			
			byte[] bytes = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
			datagramSocket.receive(datagramPacket);
			
			String welcome = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
			System.out.println(welcome+" from receiver");
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
