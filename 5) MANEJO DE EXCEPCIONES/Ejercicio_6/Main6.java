public class Main6 {
    public static void main(String[] args) {
        
        // c) Genera una cuenta
        CuentaBancaria cuenta = new CuentaBancaria("12345", "Juan Pérez", 1000.00);
        cuenta.mostrarInfo();
        
        // ----------------------------------------------------
        // PRUEBAS DE DEPÓSITO (IllegalArgumentException)
        // ----------------------------------------------------
        System.out.println("\n--- PRUEBA DE DEPÓSITOS ---");
        
        // 1. Depósito Válido
        try {
            cuenta.depositar(250.50);
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error en Depósito: " + e.getMessage());
        }
        
        // 2. Depósito con Monto Negativo (Dispara la excepción)
        try {
            cuenta.depositar(-50.00);
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error Capturado (Monto Negativo): " + e.getMessage());
        }

        cuenta.mostrarInfo(); // Saldo debe ser 1250.50

        // ----------------------------------------------------
        // PRUEBAS DE RETIRO (FondosInsuficientesException)
        // ----------------------------------------------------
        System.out.println("\n--- PRUEBA DE RETIROS ---");
        
        // 3. Retiro Válido
        try {
            cuenta.retirar(100.00);
        } catch (FondosInsuficientesException e) {
            System.err.println("❌ Error en Retiro: " + e.getMessage());
        }
        
        // 4. Retiro que supera el saldo (Dispara la excepción personalizada)
        double montoExcedente = 1500.00;
        try {
            cuenta.retirar(montoExcedente);
        } catch (FondosInsuficientesException e) {
            System.err.println("❌ Error Capturado (Fondos Insuficientes): " + e.getMessage());
        }
        
        cuenta.mostrarInfo(); // Saldo final debe ser 1150.50
    }
}