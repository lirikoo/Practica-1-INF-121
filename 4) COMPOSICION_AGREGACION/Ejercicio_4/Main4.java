import java.util.Arrays;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        
        // 1. Instanciamos el Ropero
        Ropero miRopero = new Ropero("Madera Roble");

        // 2. Definimos las prendas
        List<Ropa> prendasIniciales = Arrays.asList(
            new Ropa("Camisa", "Algodón"), 
            new Ropa("Pantalón", "Mezclilla"),
            new Ropa("Chaqueta", "Cuero"),
            new Ropa("Camisa", "Seda"),
            new Ropa("Vestido", "Algodón"),
            new Ropa("Chaqueta", "Algodón")
        );
        
        // b) Adicionar N prendas
        miRopero.adicionarPrendas(prendasIniciales);
        miRopero.mostrarContenidoTotal();

        // c) Eliminar las prendas de material "Algodón" O de tipo "Pantalón"
        String materialEliminar = "Algodón";
        String tipoEliminar = "Pantalón";
        miRopero.eliminarPrendas(materialEliminar, tipoEliminar);
        miRopero.mostrarContenidoTotal();
        
        // d) Mostrar las prendas de materia "Cuero" Y de tipo "Chaqueta"
        String materialMostrar = "Cuero";
        String tipoMostrar = "Chaqueta";
        miRopero.mostrarPrendas(materialMostrar, tipoMostrar);
        
        // d) Mostrar un ejemplo sin coincidencias
        miRopero.mostrarPrendas("Seda", "Pantalón");
    }
}