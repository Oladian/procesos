package http;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.net.ServerSocket;
public class ServerSocketTest {
	public static void main(String[] args){	
		try (ServerSocket server = new ServerSocket(9090);) {
			System.out.println("Server abierto... Puerto: " + server.getLocalPort());
			while (true) {
				Socket socket = server.accept();
				server.setSoTimeout(10_000);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				//out.flush();
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//String line = in.readLine();
				
				out.println("Saludos, "+in.readLine());
				out.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
