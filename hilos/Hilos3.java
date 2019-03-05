package hilos;

public class Hilos3 {
	public static void main(String[] args) {
		HiloCalculoNumerico h1 = new HiloCalculoNumerico();
		HiloCalculoNumerico h2 = new HiloCalculoNumerico();
		HiloCalculoNumerico h3 = new HiloCalculoNumerico();
		HiloCalculoNumerico h4 = new HiloCalculoNumerico();
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		
		 try {
			h1.join();
			h2.join();
			h3.join();
			h4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		long resultado = h1.getResultado() + h2.getResultado() + h3.getResultado() + h4.getResultado();
		System.out.println(resultado);
	}
}

class HiloCalculoNumerico extends Thread{
	
	private long resultado;
		
	@Override
	public void run() {
		for (int i = 0; i < 100_000_000; i++) {
			resultado++;
		}
	}

	public long getResultado() {
		return resultado;
	}

	public void setResultado(long resultado) {
		this.resultado = resultado;
	}	
}
