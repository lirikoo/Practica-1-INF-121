package EJERCICIO_6;

public class Cliente {
    private int codCliente;
    private int ci;
    private String nombre;
    private String apellido;

    public Cliente(int codCliente, int ci, String nombre, String apellido) {
        this.codCliente = codCliente;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Cliente [" + codCliente + "] " + nombre + " " + apellido + " (CI: " + ci + ")";
    }
}