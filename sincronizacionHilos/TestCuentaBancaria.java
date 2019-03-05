package sincronizacionHilos;

import java.util.Random;

public class TestCuentaBancaria {
	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria(10000.0);
//		RetiradaDinero retirada = new RetiradaDinero(cuenta);
//		IngresoDinero ingreso = new IngresoDinero(cuenta);
		
//		ingreso.setCantidadIngreso(10.0);
//		retirada.setCantidadRetirar(100.0);
		
		Random random = new Random();
		
		for (int i = 0; i < 20; i++) {
			
			double retirada = 10.0 * random.nextInt(100);
			double ingreso = 10.0 * random.nextInt(10);
			
			new RetiradaDinero(cuenta, -100).start();
			
//			System.out.println("Retirando "+retirada+" SALDO: "+cuenta.getSaldo());
			
			new IngresoDinero(cuenta, 100).start();
			
//			System.out.println("Ingresando "+ingreso+" SALDO: "+cuenta.getSaldo());
//			ingreso.run();
//			retirada.run();
		}
	}
}
