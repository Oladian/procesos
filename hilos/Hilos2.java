package hilos;

public class Hilos2 {
	public static void main(String[] args) {
//		HiloRunnable hilo = new HiloRunnable(5_000_000);
//		
//		hilo.run();
		
		
		for (int i = 0; i < 1000; i++) {
			new Thread(new HiloRunnable(5_000_000)).start();
		}
		
	}
}

class HiloRunnable implements Runnable{

	private long numero;
	
	
	
	public HiloRunnable(long numero) {
		super();
		this.numero = numero;
	}



	@Override
	public void run() {
		for(long i=0; i < numero; i++) {
			System.out.println(i+ " ----- " +
					Thread.currentThread().getName());
		}
	}
	
}