package EJERCICIO_9;

public class Animal {
    private String especie;
    private String nombre;
    private int cantidad;

    public Animal(String especie, String nombre, int cantidad) {
        this.especie = especie;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getEspecie() {
        return especie;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return " - " + nombre + " (" + especie + ") Cant: " + cantidad;
    }
}