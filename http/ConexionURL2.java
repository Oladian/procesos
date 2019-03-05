package http;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConexionURL2 {

	public static void main(String[] args) {
		BufferedReader buffer = null;
		try {
			URL url = new URL("http://www.nodejs.org:80");
			URLConnection urlConnection = url.openConnection();
			
			Map<String, List<String>> headers = urlConnection.getHeaderFields();
			Set<String> setKey = headers.keySet();
			
			for (String claves : setKey) {
				System.out.println(claves + ":" + headers.get(claves));		
			}
			
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
