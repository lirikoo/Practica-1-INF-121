import java.util.Arrays;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        
        Ropero miRopero = new Ropero("Madera Roble");

        List<Ropa> prendasIniciales = Arrays.asList(
            new Ropa("Camisa", "Algodón"), 
            new Ropa("Pantalón", "Mezclilla"),
            new Ropa("Chaqueta", "Cuero"),
            new Ropa("Camisa", "Seda"),
            new Ropa("Vestido", "Algodón"),
            new Ropa("Chaqueta", "Algodón")
        );
        
        miRopero.adicionarPrendas(prendasIniciales);
        miRopero.mostrarContenidoTotal();

        String materialEliminar = "Algodón";
        String tipoEliminar = "Pantalón";
        miRopero.eliminarPrendas(materialEliminar, tipoEliminar);
        miRopero.mostrarContenidoTotal();
        
        String materialMostrar = "Cuero";
        String tipoMostrar = "Chaqueta";
        miRopero.mostrarPrendas(materialMostrar, tipoMostrar);
        
        miRopero.mostrarPrendas("Seda", "Pantalón");
    }
}