package EJERCICIO_8;

public class Main {
    public static void main(String[] args) {
        ArchRefri arch = new ArchRefri("refri.dat");
        arch.crear();

        // Usamos formato AAAA-MM-DD para que sea facil comparar
        arch.adicionar(new Alimento("Leche", "2025-01-10", 2));
        arch.adicionar(new Alimento("Yogurt", "2023-12-01", 5)); // Vencido
        arch.adicionar(new Alimento("Huevo", "2025-02-20", 0));  // Cantidad 0
        arch.adicionar(new Alimento("Carne", "2024-01-01", 1));  // Vencido
        arch.adicionar(new Alimento("Manzana", "2025-05-15", 10));

        System.out.println("--- Lista Inicial ---");
        arch.listarTodo();

        System.out.println("\n--- a) Modificar Leche a LecheDeslactosada ---");
        arch.modificarNombre("Leche", "LecheDeslactosada");
        
        System.out.println("\n--- a) Eliminar Manzana ---");
        arch.eliminarPorNombre("Manzana");
        arch.listarTodo();

        System.out.println("\n--- b) Vencen antes de 2024-06-01 ---");
        arch.mostrarCaducadosAntesDe("2024-06-01");

        System.out.println("\n--- c) Eliminar los de cantidad 0 ---");
        arch.eliminarVacios();
        arch.listarTodo();

        System.out.println("\n--- d) Buscar vencidos (Fecha actual simulada: 2025-01-01) ---");
        arch.buscarVencidos("2025-01-01");

        System.out.println("\n--- e) Alimento con mas cantidad ---");
        arch.mostrarMasCantidad();
    }
}