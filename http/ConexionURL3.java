package http;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConexionURL3 {

	public static void main(String[] args) throws Exception {
		BufferedReader buffer = null;
			URL url = new URL("http://www.nodejs.org:80");
			HttpURLConnection conexion = (HttpURLConnection)url.openConnection();
			
			System.out.println(conexion.getRequestMethod());
			System.out.println(conexion.getResponseCode());
			System.out.println(conexion.getResponseMessage());
	}
}
