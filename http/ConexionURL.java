package http;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ConexionURL {

	public static void main(String[] args) {
		BufferedReader buffer = null;
		try {
			URL url = new URL("http://www.nodejs.org:80");
			System.out.printf("Host: %S, Port: %d%n", url.getHost(), url.getPort());
			
			buffer = new BufferedReader(
					new InputStreamReader(url.openStream()));
			String linea;
			while ((linea=buffer.readLine())!=null) {
				System.out.println(linea);
			}
		} catch (MalformedURLException e) {
			System.out.println("URL MAL FORMADA");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
