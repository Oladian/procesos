package http;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteServerDateTime {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String HOST = "dict.org";
		final int PORT    = 2628;
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			socket = new Socket(HOST, PORT);
			out = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			out.write("GET / HTTP/1.1\n");
			out.write("Host:www.dict.org\n\n");
			out.flush();
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String linea;
			while ((linea = in.readLine()) != null)
				System.out.println(linea);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
