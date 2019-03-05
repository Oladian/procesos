package sincronizacionHilos;

public class Ingresar implements Runnable{
	private double cantidad;
	private CuentaBancaria cuentaBancaria;
	
	public Ingresar(double cantidad, CuentaBancaria cuentaBancaria) {
		this.cantidad = cantidad;
		this.cuentaBancaria = cuentaBancaria;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000L);
			System.out.println("Ingreso: "+cantidad+", SALDO: "+
					cuentaBancaria.transaccion(cantidad));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
