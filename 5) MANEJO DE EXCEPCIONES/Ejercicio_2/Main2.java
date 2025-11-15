public class Main2 {
    public static void main(String[] args) {
        
        System.out.println("--- PRUEBA DE OPERACIONES ESTÁTICAS ---");
        
        // Suma, Resta, Multiplicación
        System.out.println("Suma (10 + 5): " + Calculadora.sumar(10, 5));
        System.out.println("Resta (10 - 5): " + Calculadora.restar(10, 5));
        System.out.println("Multiplicación (10 * 5): " + Calculadora.multiplicar(10, 5));
        
        // Prueba de la División (Caso Correcto)
        try {
            System.out.println("División (10 / 5): " + Calculadora.dividir(10, 5));
        } catch (ArithmeticException e) {
            // No debería ocurrir
            System.out.println("ERROR INESPERADO: " + e.getMessage());
        }

        // --- PRUEBA DE ERRORES COMUNES ---
        
        // 1. Prueba de División por Cero (Punto b)
        System.out.println("\n--- PRUEBA DE ArithmeticException ---");
        try {
            System.out.println("División (10 / 0): " + Calculadora.dividir(10, 0));
        } catch (ArithmeticException e) {
            System.err.println("❌ Error Capturado (División por Cero): " + e.getMessage());
        }
        
        // 2. Prueba de Conversión de String a Entero (Punto c)
        System.out.println("\n--- PRUEBA DE NumeroInvalidoException ---");
        String valorValido = "123";
        String valorInvalido = "Hola";

        // Caso 1: Valor Válido
        try {
            int numero = Calculadora.convertirAEntero(valorValido);
            System.out.println("✅ Conversión exitosa de '" + valorValido + "': " + numero);
        } catch (NumeroInvalidoException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
        
        // Caso 2: Valor Inválido
        try {
            int numero = Calculadora.convertirAEntero(valorInvalido);
            System.out.println("Conversión exitosa: " + numero); // No se debería ejecutar
        } catch (NumeroInvalidoException e) {
            System.err.println("❌ Error Capturado (Valor Inválido): " + e.getMessage());
        }
    }
}