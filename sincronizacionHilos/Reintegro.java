package sincronizacionHilos;

public class Reintegro implements Runnable{
	private double cantidad;
	private CuentaBancaria cuentaBancaria;
	
	public Reintegro(double cantidad, CuentaBancaria cuentaBancaria) {
		this.cantidad = cantidad;
		this.cuentaBancaria = cuentaBancaria;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000L);
			System.out.println("Reintegro: "+cantidad+", SALDO: "+
					cuentaBancaria.transaccion(cantidad));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
