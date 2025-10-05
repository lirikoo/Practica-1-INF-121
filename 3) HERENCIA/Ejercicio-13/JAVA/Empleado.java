public class Empleado {
    protected String nombre;
    public float sueldomes;

    public Empleado(String nombre, float sueldomes) {
        this.nombre = nombre;
        this.sueldomes = sueldomes;
    }

    public float sueldoTotal() {
        return this.sueldomes;
    }

    public String toString() {
        return String.format("Nombre: %s, Sueldo Base Mensual: %.2f", this.nombre, this.sueldomes);
    }
}