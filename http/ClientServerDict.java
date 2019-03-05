package http;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientServerDict  {
	final static String HOST = "dict.org";
	final static int PORT = 2628;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Introduce una palabra:\n");
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		Socket socket = new Socket(HOST, PORT);
		
		PrintWriter out = new PrintWriter(
				new OutputStreamWriter(socket.getOutputStream()));
		
		out.write("define fd-spa-eng "+ word +"\n");
		out.flush();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		String linea;
		
		while((linea = in.readLine())!=null) {
			System.out.println(linea);
		}
		
		sc.close();
		out.close();
		
	}
}
