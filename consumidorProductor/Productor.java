package consumidorProductor;

public class Productor implements Runnable{
	private static final String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Buffer buffer;
	int orden;
	
	public Productor(Buffer buffer, int orden) {
		this.buffer = buffer;
		this.orden = orden;
	}
	
	@Override
	public void run() {
		char valor = alfabeto.charAt((int)(Math.random()*alfabeto.length()));
		
		try {
			buffer.poner(valor);
			System.out.println(orden + " - produciendo: "+valor);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		
		try {
			Thread.sleep((long) (Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
