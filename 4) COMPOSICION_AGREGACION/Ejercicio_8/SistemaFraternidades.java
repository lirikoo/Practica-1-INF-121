import java.util.ArrayList;
import java.util.List;

public class SistemaFraternidades {
    private List<Fraternidad> fraternidades;
    // Lista para verificar rápidamente si un bailarín ya está registrado en ALGUNA fraternidad
    private List<String> bailarinesCIsRegistrados; 

    public SistemaFraternidades() {
        this.fraternidades = new ArrayList<>();
        this.bailarinesCIsRegistrados = new ArrayList<>();
    }
    
    public void registrarFraternidad(Fraternidad frater) {
        this.fraternidades.add(frater);
        // Aseguramos que el encargado esté registrado para la validación
        this.bailarinesCIsRegistrados.add(frater.getEncargado().getCi());
    }

    // C) Verificar que no estén en 2 o más fraternidades.
    public void registrarNuevoIntegrate(Bailarin nuevoBailarin, Facultad fac, Fraternidad frater) {
        // 1. Verificación de unicidad (Regla del Cliente)
        if (bailarinesCIsRegistrados.contains(nuevoBailarin.getCi())) {
            System.out.println("\n🚫 ERROR: El bailarín " + nuevoBailarin.getNombre() + " (CI: " + nuevoBailarin.getCi() + 
                               ") ya está registrado en otra fraternidad y no puede ser añadido.");
            return;
        }
        
        // 2. Registro (Si pasa la verificación)
        nuevoBailarin.setFacultad(fac);
        nuevoBailarin.setFraternidad(frater);
        frater.agregarParticipante(nuevoBailarin);
        this.bailarinesCIsRegistrados.add(nuevoBailarin.getCi());
        
        System.out.println("\n✅ REGISTRO EXITOSO: " + nuevoBailarin.getNombre() + " añadido a " + frater.getNombre());
    }

    // C) Mostrar encargados de cada fraternidad
    public void mostrarEncargados() {
        System.out.println("\n*** ENCARGADOS DE FRATERNIDADES ***");
        for (Fraternidad frater : fraternidades) {
            System.out.println("Fraternidad: " + frater.getNombre() + " | Encargado: " + frater.getEncargado().getNombre());
        }
    }
    
    // C) Mostrar bailarines (y sus facultades/fraternidades)
    public void mostrarTodosLosBailarines() {
        System.out.println("\n*** LISTADO COMPLETO DE PARTICIPANTES ***");
        for (Fraternidad frater : fraternidades) {
            frater.mostrarBailarines();
        }
    }
}