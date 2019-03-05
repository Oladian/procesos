package hilos;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HilosNumerosPrimos {
		public static void main(String[] args) {
			
			int nProcessors = Runtime.getRuntime().availableProcessors();
			System.out.println("Este procesador tiene "+
					nProcessors+
					" procesadores");
			
			List<Long> listaNumeros = leerDatos();
			
			Long inicio = System.currentTimeMillis();
			
			ExecutorService controladorHilos = 
					Executors.newFixedThreadPool(1000000);
			
//			ExecutorService controladorHilos = 
//					Executors.newSingleThreadExecutor();
			
			for (Long long1 : listaNumeros) {
				Future<Boolean> f = controladorHilos.submit(new Callable<Boolean>() {
					@Override
					public Boolean call() throws Exception {
						return testPrimalidad(long1);
					}
				});
				try {
					System.out.printf("El nº %d es primo: %B%n", 
							long1, f.get());
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			} 
			
			controladorHilos.shutdown();
			
//			for (Long long1 : listaNumeros) {
//				System.out.printf("El nº %d es primo: %B%n", long1, testPrimalidad(long1));
//			}
			
			Long fin  = System.currentTimeMillis();
			System.out.println("Duración del cálculo: " + (fin-inicio) + " milisegundos");
			
		}

		// Método de lectura de los datos
		
		private static List<Long> leerDatos() {
			// Path evita inyección de dependencias
			
			Path path = Paths.get("archivosAuxiliares", "numeros_primos.txt");
			
			List<Long> listaNumeros = new ArrayList<>();
			try(Scanner sc = new Scanner(path);) {
				while (sc.hasNext()) {
		            long i = sc.nextLong();
		            listaNumeros.add(i);
		        }
				
			} catch (IOException e) {
				e.printStackTrace();
			}	
			return listaNumeros;
		}
		
		private static Boolean testPrimalidad(Long n) {
			if(((n&1)==0 && n!=2) || n==1) return false;//si es par y es diferente de 2 porque el 2 es primo
			for(int i=3;i<=Math.sqrt(n);i+=2)
			    if(n%i==0)
			        return false;
			return true;
		}
}






