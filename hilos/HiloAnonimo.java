package hilos;

public class HiloAnonimo {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			// Generará una clase interna anónima HiloAnonimo$1.class
			(new Thread(new Runnable() {
				public void run() {
					System.out.println(
							Thread.currentThread().getName());
				}
			})).start();
		}
	}
}
