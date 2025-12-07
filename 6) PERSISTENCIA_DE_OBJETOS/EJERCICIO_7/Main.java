package EJERCICIO_7;

public class Main {
    public static void main(String[] args) {
        ArchNino arch = new ArchNino("ninos.dat");
        arch.crear();

        // Datos: nombre, paterno, materno, ci, edad, peso(kg), talla(cm)
        arch.adicionar(new Nino("Pedrito", "Gomez", "Ali", 111, 5, 18.0, 110.0)); // Peso ideal aprox: 18
        arch.adicionar(new Nino("Juanito", "Perez", "Sol", 222, 5, 25.0, 110.0)); // Sobrepeso
        arch.adicionar(new Nino("Anita", "Lopez", "Miau", 333, 8, 24.0, 125.0));  // Peso ideal aprox: 24
        arch.adicionar(new Nino("Carlitos", "Roca", "Dura", 444, 10, 30.0, 140.0));

        System.out.println("--- Lista de Ninos ---");
        arch.mostrarTodos();

        System.out.println("\n--- b) Ninos con peso adecuado ---");
        arch.contarPesoAdecuado();

        System.out.println("\n--- c) Ninos inadecuados (peso o talla mal) ---");
        arch.mostrarInadecuados();

        System.out.println("\n--- d) Promedio de edad ---");
        arch.promedioEdad();

        System.out.println("\n--- e) Buscar Carnet 333 ---");
        arch.buscarPorCarnet(333);

        System.out.println("\n--- f) Talla mas alta ---");
        arch.mostrarMasAltos();
    }
}