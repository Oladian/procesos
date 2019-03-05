package Process;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime rt = Runtime.getRuntime();
		Process lsProc = rt.exec("ls -l");
		InputStream in = lsProc.getInputStream();
		Process grepProc = rt.exec("grep bin");
		OutputStream out = grepProc.getOutputStream();
		int b;
		
		while ((b = in.read())!= -1){
			out.write(b);
		}
		
		//lsProc.waitFor();
		in.close();
		out.close();
		
		in = grepProc.getInputStream();
		while ((b = in.read())!= -1) {
			System.out.print((char)b);
		}
		//grepProc.waitFor();
		in.close();
		
	}

}
