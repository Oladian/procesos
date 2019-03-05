package hilos;

public class HilosDaemon {
	public static void main(String[] args) {
	
		System.out.println("En el hilo "+Thread.currentThread().getName());
		
		Thread hilo1 = new Thread(new SegundoPlano());
		Thread hilo2 = new Thread(new SegundoPlano());
		Thread hilo3 = new Thread(new SegundoPlano());
		Thread hilo4 = new Thread(new SegundoPlano());

		hilo1.setDaemon(true); hilo2.setDaemon(true);
		
		// El hilo principal (main) NO esperará a los hilos daemon
		hilo1.start();hilo2.start();
		
		// El hilo principal (main) esperará a los hilos de usuario
		hilo3.start();hilo4.start();
		
		/* 
		 * Como el hilo principal estará esperando a los hilos de usuario,
		 * los hilos daemon se ejecutarán debido a que los hilos de usuario
		 * aún no habrán terminado; por lo que los daemon tendrán tiempo
		 * para ejecutarse.
		 */
		
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Acabando el hilo "+Thread.currentThread().getName());
	}
}

class SegundoPlano implements Runnable{

	@Override
	public void run() {
		System.out.println("En el hilo "+Thread.currentThread().getName());
		try {
			Thread.sleep(15_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Acabando el hilo "+Thread.currentThread().getName());
	}
	
}