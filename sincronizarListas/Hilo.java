package sincronizarListas;

public class Hilo extends Thread{
	
	private Recurso recurso;

	public Hilo(Recurso recurso) {
		this.recurso = recurso;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep((int)(Math.random()*1000));
			recurso.quitar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
