public class Persona {
    private String nombre;
    private int edad;
    private float pesoPersona;

    public Persona(String nombre, int edad, float pesoPersona) {
        this.nombre = nombre;
        this.edad = edad;
        this.pesoPersona = pesoPersona;
    }

    // Getters necesarios para las validaciones
    public int getEdad() {
        return edad;
    }

    public float getPesoPersona() {
        return pesoPersona;
    }
    
    // Opcional: para imprimir bonito si te sobra tiempo
    public String getNombre() {
        return nombre;
    }
}