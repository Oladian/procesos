package consumidorProductor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestProductorConsumidor {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		ExecutorService pool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			pool.submit(new Consumidor(buffer, i));
			pool.submit(new Productor(buffer, i));
		}
		pool.shutdown();
	}
}

