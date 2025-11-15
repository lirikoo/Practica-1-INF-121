public class Calculadora {

    // a) Métodos estáticos para operaciones básicas
    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    // b) El método dividir debe lanzar ArithmeticException si el divisor es cero
    public static double dividir(double a, double b) throws ArithmeticException {
        if (b == 0) {
            // Java ya lanza esta excepción, pero la forzamos explícitamente para cumplir el requisito
            throw new ArithmeticException("El divisor no puede ser cero.");
        }
        return a / b;
    }

    // c) Método para convertir String a número entero con excepción personalizada
    public static int convertirAEntero(String valor) throws NumeroInvalidoException {
        try {
            // Intentamos convertir el String a int
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            // Si la conversión falla, lanzamos nuestra excepción personalizada
            throw new NumeroInvalidoException("El valor '" + valor + "' no es un número entero válido.");
        }
    }
}