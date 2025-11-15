// Clase 1: Facultad
public class Facultad {
    private String nombre;
    private String area;

    public Facultad(String nombre, String area) {
        this.nombre = nombre;
        this.area = area;
    }

    public String getNombre() { return nombre; }
}

// Clase 2: Bailarin (Participante)
public class Bailarin {
    private String nombre;
    private int edad;
    private String ci;
    // Referencia para saber a qué Facultad y Fraternidad pertenecen
    private Facultad facultadPerteneciente; 
    private Fraternidad fraternidadPerteneciente; 

    public Bailarin(String nombre, int edad, String ci) {
        this.nombre = nombre;
        this.edad = edad;
        this.ci = ci;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCi() { return ci; }
    
    public void setFraternidad(Fraternidad frater) { this.fraternidadPerteneciente = frater; }
    public void setFacultad(Facultad fac) { this.facultadPerteneciente = fac; }

    public void mostrarPertenencia() {
        String fName = (fraternidadPerteneciente != null) ? fraternidadPerteneciente.getNombre() : "N/A";
        String facName = (facultadPerteneciente != null) ? facultadPerteneciente.getNombre() : "N/A";
        System.out.println("  - " + nombre + " (" + edad + " años) | Fraternidad: " + fName + " | Facultad: " + facName);
    }
}