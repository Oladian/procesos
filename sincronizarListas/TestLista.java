package sincronizarListas;

import java.util.List;

public class TestLista {
	public static void main(String[] args) {

		Recurso recurso = new Recurso();
			
		for (int i=0; i<5000; i++) {
			new Hilo(recurso).start();
		}
	}
}
