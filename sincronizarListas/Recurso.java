package sincronizarListas;

import java.util.ArrayList;
import java.util.List;

public class Recurso {
	List<Integer> numeros = new ArrayList<Integer>();

	public Recurso() {
		for (int i = 0; i < 1000; i++) {
			this.numeros.add(i);
		}
	}
	
	public void quitar() {
		System.out.println("Quitando el elemento "+numeros.get(0));
		numeros.remove(0);
	}
}
