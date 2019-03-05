package Process;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {

	public static void main(String[] args) {
		Process processLS, processGREP;
		ProcessBuilder pBuilder;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		List<String> command = new ArrayList<>();
		command.add("ls");
		command.add("-l");
		
		File directory = new File("/home/osboxes/");
		pBuilder = new ProcessBuilder(command);
		pBuilder.directory(directory);
		try {
			processLS = pBuilder.start();
			inputStream = processLS.getInputStream();
			command.clear();
			command.add("grep");
			command.add("txt");
			pBuilder = new ProcessBuilder(command);
			processGREP = pBuilder.start();
			outputStream = processGREP.getOutputStream();
			int valor;
			while ((valor = inputStream.read())!= -1) {
				outputStream.write(valor);
			}
			//processLS.waitFor();
			inputStream.close();
			outputStream.close();
			inputStream = processGREP.getInputStream();
			while ((valor = inputStream.read()) !=-1) {
				System.out.print((char)valor);
			}
			//processGREP.waitFor();
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
