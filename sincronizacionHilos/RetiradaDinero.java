package sincronizacionHilos;

public class RetiradaDinero extends Thread {
	private CuentaBancaria cuentaBancaria;
	private double cantidadRetirar;
		
	@Override
	public void run() {
		try {
			Thread.sleep((long)((Math.random()*100)));
			//cuentaBancaria.reintegro(cantidadRetirar);
			cuentaBancaria.transaccion(cantidadRetirar);
			//System.out.println("Retirando "+cantidadRetirar+"... Actualmente hay: "+cuentaBancaria.getSaldo());
			System.out.println("Retirando "+cantidadRetirar+"... Actualmente hay: "+
			cuentaBancaria.transaccion(cantidadRetirar));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public RetiradaDinero(CuentaBancaria cuentaBancaria, double cantidadRetirar) {
		super();
		this.cuentaBancaria = cuentaBancaria;
		this.cantidadRetirar = cantidadRetirar;
	}

	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public double getCantidadRetirar() {
		return cantidadRetirar;
	}

	public void setCantidadRetirar(double cantidadRetirar) {
		this.cantidadRetirar = cantidadRetirar;
	}

	
}
