package sincronizacionHilos;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCBancaria {
	public static void main(String[] args) {
		CuentaBancaria cuentaBancaria = new CuentaBancaria(1000);
		
		int nHilos = Runtime.getRuntime().availableProcessors()+1;
		
		ExecutorService pool = Executors.newFixedThreadPool(nHilos);
		
		Random random = new Random();
		int cantidad;
		
		for (int i = 0; i < 10; i++) {
			cantidad = random.nextInt(100);
			pool.submit(new Ingresar(100, cuentaBancaria));
			cantidad = -random.nextInt(100);
			pool.submit(new Reintegro(-100, cuentaBancaria));
		}
		pool.shutdown();
	}
}
