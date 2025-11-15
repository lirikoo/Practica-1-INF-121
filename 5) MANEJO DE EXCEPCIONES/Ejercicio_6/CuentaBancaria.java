public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    // b) Método depositar
    public void depositar(double monto) throws IllegalArgumentException {
        if (monto <= 0) {
            // Lanza excepción estándar si el monto no es positivo
            throw new IllegalArgumentException("ERROR: El monto a depositar debe ser positivo.");
        }
        this.saldo += monto;
        System.out.printf("✅ DEPÓSITO EXITOSO: Se depositaron %.2f. Nuevo saldo: %.2f\n", monto, this.saldo);
    }

    // b) Método retirar
    public void retirar(double monto) throws FondosInsuficientesException {
        if (monto <= 0) {
            // Se recomienda manejar esto, aunque el ejercicio se enfoca en FondosInsuficientesException
            throw new IllegalArgumentException("ERROR: El monto a retirar debe ser positivo.");
        }
        
        if (monto > this.saldo) {
            // Lanza la excepción personalizada si no hay fondos suficientes
            double faltante = monto - this.saldo;
            throw new FondosInsuficientesException("ERROR: Fondos insuficientes. Intenta retirar " + String.format("%.2f", monto) + 
                                                " y solo tiene " + String.format("%.2f", this.saldo) + 
                                                ". Faltan: " + String.format("%.2f", faltante));
        }
        
        this.saldo -= monto;
        System.out.printf("✅ RETIRO EXITOSO: Se retiraron %.2f. Nuevo saldo: %.2f\n", monto, this.saldo);
    }

    // b) Método mostrarInfo
    public void mostrarInfo() {
        System.out.println("\n*** INFORMACIÓN DE LA CUENTA ***");
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo Disponible: " + String.format("%.2f", saldo));
        System.out.println("---------------------------------");
    }
}