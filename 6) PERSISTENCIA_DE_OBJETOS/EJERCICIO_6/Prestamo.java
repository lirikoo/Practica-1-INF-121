package EJERCICIO_6;

public class Prestamo {
    private int codCliente;
    private int codLibro;
    private String fechaPrestamo;
    private int cantidad;

    public Prestamo(int codCliente, int codLibro, String fechaPrestamo, int cantidad) {
        this.codCliente = codCliente;
        this.codLibro = codLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.cantidad = cantidad;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public int getCodLibro() {
        return codLibro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Prestamo: Cliente " + codCliente + " se llevo Libro " + codLibro + " (Cant: " + cantidad + ")";
    }
}
