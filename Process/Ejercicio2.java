package Process;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		Process grepProc = rt.exec("grep java");
		OutputStream out = grepProc.getOutputStream();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
		pw.println("I love coffee");
		pw.println("I love tea");
		pw.println("I love the java");
		pw.println("and the java love me");
		pw.close();
		
		InputStream in = grepProc.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		while((line = br.readLine())!= null) {
			System.out.println(line);
		}
		
	}
}
