package sincronizacionHilos;

public class IngresoDinero extends Thread {
	private CuentaBancaria cuentaBancaria = new CuentaBancaria();
	private double cantidadIngreso;
	
	public IngresoDinero(CuentaBancaria cuentaBancaria, double cantidadIngreso) {
		super();
		this.cuentaBancaria = cuentaBancaria;
		this.cantidadIngreso = cantidadIngreso;
	}

	@Override
	public void run() {
		try {
			Thread.sleep((long)((Math.random()*100)));
			//cuentaBancaria.ingreso(cantidadIngreso);
			cuentaBancaria.transaccion(cantidadIngreso);
			//System.out.println("Ingresando "+cantidadIngreso+"... Actualmente hay: "+cuentaBancaria.getSaldo());
			System.out.println("Ingresando "+cantidadIngreso+"... Actualmente hay: "+
					cuentaBancaria.transaccion(cantidadIngreso));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public double getCantidadIngreso() {
		return cantidadIngreso;
	}

	public void setCantidadIngreso(double cantidadIngreso) {
		this.cantidadIngreso = cantidadIngreso;
	}
}
