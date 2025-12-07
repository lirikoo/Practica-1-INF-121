package EJERCICIO_8;

public class Alimento {
    private String nombre;
    private String fechaVencimiento;
    private int cantidad;

    public Alimento(String nombre, String fechaVencimiento, int cantidad) {
        this.nombre = nombre;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Alimento: " + nombre + " | Vence: " + fechaVencimiento + " | Cant: " + cantidad;
    }
}