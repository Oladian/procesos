package http;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class DatagramSender {
	public static void main(String[] args) {
		try(DatagramSocket datagramSocket = new DatagramSocket()) {
			String welcome = "WELCOME JAVA";
			
			InetAddress ip = InetAddress.getByName("127.0.0.1");
			
			DatagramPacket datagramPacket = new DatagramPacket(welcome.getBytes(), welcome.length(), ip, 3000);
			
			System.out.println("Sending welcome...");
			
			datagramSocket.send(datagramPacket);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
