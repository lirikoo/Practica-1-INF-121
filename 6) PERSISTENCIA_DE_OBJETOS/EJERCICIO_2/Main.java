package EJERCICIO_2;

public class Main {
    public static void main(String[] args) {
        ArchivoTrabajador arch = new ArchivoTrabajador();
        arch.crearArchivo();

        Trabajador t1 = new Trabajador("Juan Perez", 111, 2500.50);
        Trabajador t2 = new Trabajador("Maria Gomez", 222, 5000.00);
        Trabajador t3 = new Trabajador("Carlos Ruiz", 333, 1200.00);

        arch.guardarTrabajador(t1);
        arch.guardarTrabajador(t2);
        arch.guardarTrabajador(t3);

        System.out.println("--- Lista Original ---");
        arch.listarTodos();

        System.out.println("\n--- Aumentar Salario a Juan (1000 mas) ---");
        arch.aumentarSalario(1000, t1);
        arch.listarTodos();

        System.out.println("\n--- Buscar Mayor Salario ---");
        arch.buscarMayorSalario();

        System.out.println("\n--- Ordenar por Salario ---");
        arch.ordenarPorSalario();
    }
}