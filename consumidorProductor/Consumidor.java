package consumidorProductor;

public class Consumidor implements Runnable{
	private Buffer buffer;
	int orden;
	
	public Consumidor(Buffer buffer, int orden) {
		super();
		this.buffer = buffer;
		this.orden = orden;
	}

	@Override
	public void run() {
		
		char valor;
		
		try {
			valor = buffer.recoger();
			System.out.println(orden + " - consumiendo: "+valor);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			Thread.sleep((long)Math.random()*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
