package EJERCICIO_7;

public class Nino extends Persona {
    private int edad;
    private double peso;
    private double talla;

    public Nino(String nombre, String paterno, String materno, int ci, int edad, double peso, double talla) {
        super(nombre, paterno, materno, ci);
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public double getTalla() {
        return talla;
    }

    @Override
    public String toString() {
        return "Nino: " + nombre + " " + paterno + " " + materno + 
               " | CI: " + ci + " | Edad: " + edad + 
               " | Peso: " + peso + "kg | Talla: " + talla + "cm";
    }
}