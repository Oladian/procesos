package hilos;

public class Hilos1 {
	public static void main(String[] args) {
			Thread hilo1 = new Hilo500();
			Thread hilo2 = new Hilo500();
			
				hilo1.start();
				hilo2.start();
			
			
	}
}

class Hilo500 extends Thread{
	
	@Override
	public void run() {
		try {
			Hilo500.sleep(1000);
			for(long i=0; i<2_000_000; i++) {
				System.out.println(i+ " ----- " +
						Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

