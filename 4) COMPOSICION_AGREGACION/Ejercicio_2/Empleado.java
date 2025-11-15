public class Empleado {
    private String nombre;
    private String cargo;
    private double sueldo;

    // Constructor
    public Empleado(String nombre, String cargo, double sueldo) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    // Método para cambiar el salario
    public void cambiarSalario(double porcentajeAumento) {
        // Suponemos que el porcentajeAumento es un valor como 10.0 para 10%
        double aumento = sueldo * (porcentajeAumento / 100.0);
        this.sueldo += aumento;
        System.out.println("  --> Salario de " + this.nombre + " actualizado a: " + this.sueldo);
    }

    // Getters y Setters necesarios (especialmente para el cambio de departamento en el punto 'e')
    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }
    
    // Setter para el sueldo, útil para la parte 'c'
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}