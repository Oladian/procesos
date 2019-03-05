package consumidorProductor;

public class Buffer {
	private char contenido;
	private boolean disponible;
	
	public Buffer() {}
		
	public synchronized void poner(char c) throws InterruptedException {
		//condicion de espera
		while(disponible) {
			wait();
		}
		contenido = c;
		disponible =! disponible;
		notify(); //despierta a los consumidores
	}
	
	public synchronized char recoger() throws InterruptedException {
		
		while(!disponible) {
			wait();
		}
		disponible=!disponible;
		notify(); //despierta a productores	
		
		return contenido;
	}
}
