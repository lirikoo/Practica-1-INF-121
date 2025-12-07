package EJERCICIO_7;

public class Persona {
    protected String nombre;
    protected String paterno;
    protected String materno;
    protected int ci;

    public Persona(String nombre, String paterno, String materno, int ci) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public int getCi() {
        return ci;
    }
}