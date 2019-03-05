package sincronizacionHilos;

import java.util.concurrent.Semaphore;

public class CuentaBancaria {
	//private volatile double saldo;
	
	private double saldo;
	
	private Semaphore semaforo = new Semaphore(1);
	
	public CuentaBancaria() {
	}

	
	public CuentaBancaria(double saldo) {
		this.saldo = saldo;
	}

//	public synchronized double getSaldo() {
//		return saldo;
//	}
//
//	public void setSaldo(double saldo) {
//		this.saldo = saldo;
//	}
//
//	public synchronized void ingreso(double dinero) {
//		this.saldo+=dinero;
//	}
//	
//	public synchronized void reintegro(double dinero) {
//		this.saldo-=dinero;
//	}
	
//	public synchronized double transaccion(double dinero) {
//		this.saldo+=dinero;
//		return this.saldo;
//	}
	
	public double transaccion(double dinero) throws InterruptedException {
	semaforo.acquire();
	this.saldo+=dinero;
	semaforo.release();
	return this.saldo;
}

	
	
}
