import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ropero {
    private String material;
    // Usamos List para mejor manejo, la restricción de 20 se controla
    private List<Ropa> ropas; 
    private int nroRopas; // Cantidad actual de prendas

    private final int CAPACIDAD_MAXIMA = 20;

    public Ropero(String material) {
        this.material = material;
        this.ropas = new ArrayList<>();
        this.nroRopas = 0;
    }

    // Método de soporte para Agregación
    // b) Adicionar N prendas al ropero
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

    // c) Eliminar las prendas de material x O de tipo y
    public void eliminarPrendas(String materialX, String tipoY) {
        System.out.println("\n--- C) Eliminando Prendas (Material " + materialX + " O Tipo " + tipoY + ") ---");
        
        // Usamos un iterador para eliminar de forma segura mientras recorremos la lista
        int eliminadas = 0;
        
        ropas.removeIf(ropa -> {
            if (ropa.getMaterial().equalsIgnoreCase(materialX) || ropa.getTipo().equalsIgnoreCase(tipoY)) {
                System.out.println("  - Eliminada: " + ropa.getTipo() + " de " + ropa.getMaterial());
                return true; // Indica que se debe eliminar
            }
            return false;
        });

        // Actualizar el contador de prendas
        this.nroRopas = this.ropas.size();
        System.out.println("  Total de prendas restantes: " + this.nroRopas);
    }

    // d) Mostrar las prendas de materia X Y de tipo Y
    public void mostrarPrendas(String materialX, String tipoY) {
        System.out.println("\n--- D) Mostrando Prendas (Material " + materialX + " Y Tipo " + tipoY + ") ---");
        
        // Usamos Stream para filtrar las prendas que cumplen AMBAS condiciones
        List<Ropa> encontradas = this.ropas.stream()
            .filter(ropa -> ropa.getMaterial().equalsIgnoreCase(materialX) && ropa.getTipo().equalsIgnoreCase(tipoY))
            .collect(Collectors.toList());

        if (encontradas.isEmpty()) {
            System.out.println("  No se encontraron prendas con material " + materialX + " Y tipo " + tipoY + ".");
        } else {
            encontradas.forEach(Ropa::mostrarInformacion);
        }
    }
    
    // Método auxiliar para mostrar todo el contenido del ropero
    public void mostrarContenidoTotal() {
        System.out.println("\n=== Contenido Total del Ropero (" + nroRopas + "/" + CAPACIDAD_MAXIMA + ") ===");
        if (ropas.isEmpty()) {
            System.out.println("Ropero vacío.");
        } else {
            ropas.forEach(Ropa::mostrarInformacion);
        }
    }
}
