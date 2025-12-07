package EJERCICIO_9;

public class Main {
    public static void main(String[] args) {
        ArchZoo arch = new ArchZoo("zoos.dat");
        arch.crear();

        Zoologico z1 = new Zoologico(1, "Municipal");
        z1.agregarAnimal(new Animal("Felino", "Leon", 2));
        z1.agregarAnimal(new Animal("Reptil", "Cocodrilo", 5));

        Zoologico z2 = new Zoologico(2, "Privado");
        z2.agregarAnimal(new Animal("Ave", "Loro", 10));

        Zoologico z3 = new Zoologico(3, "Abandonado"); // Vacio

        arch.adicionar(z1);
        arch.adicionar(z2);
        arch.adicionar(z3);

        System.out.println("--- Lista Inicial ---");
        arch.mostrarTodo();

        System.out.println("\n--- b) Mayor Variedad ---");
        arch.mostrarMayorVariedad();

        System.out.println("\n--- c) Eliminar Vacios ---");
        arch.eliminarVacios(); // Deberia borrar el Zoo 3
        
        System.out.println("\n--- d) Buscar Felino ---");
        arch.mostrarPorEspecie("Felino");

        System.out.println("\n--- e) Mover del Zoo 1 al Zoo 2 ---");
        arch.moverAnimales(1, 2);
        arch.mostrarTodo();
    }
}