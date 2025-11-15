import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ropero {
    private String material;
    private List<Ropa> ropas; 
    private int nroRopas; 

    private final int CAPACIDAD_MAXIMA = 20;

    public Ropero(String material) {
        this.material = material;
        this.ropas = new ArrayList<>();
        this.nroRopas = 0;
    }

    public void adicionarPrendas(List<Ropa> nuevasRopas) {
        System.out.println("\n--- B) Adicionando Prendas ---");
        for (Ropa prenda : nuevasRopas) {
            if (nroRopas < CAPACIDAD_MAXIMA) {
                this.ropas.add(prenda);
                this.nroRopas++;
                System.out.println("  + Agregada: " + prenda.getTipo() + " de " + prenda.getMaterial());
            } else {
                System.out.println("  ! Advertencia: Ropero lleno. No se pudo agregar la prenda: " + prenda.getTipo());
                break;
            }
        }
    }

    public void eliminarPrendas(String materialX, String tipoY) {
        System.out.println("\n--- C) Eliminando Prendas (Material " + materialX + " O Tipo " + tipoY + ") ---");
        
        int eliminadas = 0;
        
        ropas.removeIf(ropa -> {
            if (ropa.getMaterial().equalsIgnoreCase(materialX) || ropa.getTipo().equalsIgnoreCase(tipoY)) {
                System.out.println("  - Eliminada: " + ropa.getTipo() + " de " + ropa.getMaterial());
                return true; 
            }
            return false;
        });

        this.nroRopas = this.ropas.size();
        System.out.println("  Total de prendas restantes: " + this.nroRopas);
    }

    public void mostrarPrendas(String materialX, String tipoY) {
        System.out.println("\n--- D) Mostrando Prendas (Material " + materialX + " Y Tipo " + tipoY + ") ---");
        
        List<Ropa> encontradas = this.ropas.stream()
            .filter(ropa -> ropa.getMaterial().equalsIgnoreCase(materialX) && ropa.getTipo().equalsIgnoreCase(tipoY))
            .collect(Collectors.toList());

        if (encontradas.isEmpty()) {
            System.out.println("  No se encontraron prendas con material " + materialX + " Y tipo " + tipoY + ".");
        } else {
            encontradas.forEach(Ropa::mostrarInformacion);
        }
    }
    
    public void mostrarContenidoTotal() {
        System.out.println("\n=== Contenido Total del Ropero (" + nroRopas + "/" + CAPACIDAD_MAXIMA + ") ===");
        if (ropas.isEmpty()) {
            System.out.println("Ropero vacío.");
        } else {
            ropas.forEach(Ropa::mostrarInformacion);
        }
    }
}
