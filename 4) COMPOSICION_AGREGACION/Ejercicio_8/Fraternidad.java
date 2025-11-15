import java.util.ArrayList;
import java.util.List;

public class Fraternidad {
    private String nombre;
    private Bailarin encargado; 
    private List<Bailarin> participantes;

    public Fraternidad(String nombre, Bailarin encargado) {
        this.nombre = nombre;
        this.encargado = encargado;
        this.participantes = new ArrayList<>();
        // El encargado es también un participante
        this.participantes.add(encargado); 
    }

    public String getNombre() { return nombre; }
    public Bailarin getEncargado() { return encargado; }

    public void agregarParticipante(Bailarin b) {
        this.participantes.add(b);
    }
    
    public void mostrarBailarines() {
        System.out.println("\n--- Fraternidad: " + nombre + " (Encargado: " + encargado.getNombre() + ") ---");
        for (Bailarin b : participantes) {
            b.mostrarPertenencia();
        }
    }
}