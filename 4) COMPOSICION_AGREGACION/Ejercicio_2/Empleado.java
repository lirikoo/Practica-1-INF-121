public class Empleado {
    private String nombre;
    private String cargo;
    private double sueldo;

    public Empleado(String nombre, String cargo, double sueldo) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public void cambiarSalario(double porcentajeAumento) {
        double aumento = sueldo * (porcentajeAumento / 100.0);
        this.sueldo += aumento;
        System.out.println("  --> Salario de " + this.nombre + " actualizado a: " + this.sueldo);
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }
    
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}