
package Process;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio1 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		Process lsProc;
		try {
			lsProc = rt.exec("ls -l");
			InputStream in = lsProc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = br.readLine()) != null)
				System.out.println(line);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
