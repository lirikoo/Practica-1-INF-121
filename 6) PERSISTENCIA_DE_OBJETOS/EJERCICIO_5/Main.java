package EJERCICIO_5;

public class Main {
    public static void main(String[] args) {
        ArchFarmacia arch = new ArchFarmacia("farmacia.dat");
        arch.crearArchivo();

        Farmacia f1 = new Farmacia("Farmacorp", 10, "Av. Arce");
        f1.agregarMedicamento(new Medicamento("Tapsin", 101, "Resfrio", 5.50));
        f1.agregarMedicamento(new Medicamento("JarabeX", 102, "Tos", 25.00));
        f1.agregarMedicamento(new Medicamento("Paracetamol", 103, "Dolor", 2.00));

        Farmacia f2 = new Farmacia("Chavez", 20, "Calle 21");
        f2.agregarMedicamento(new Medicamento("Vick", 201, "Tos", 15.00));
        f2.agregarMedicamento(new Medicamento("Ibuprofeno", 202, "Dolor", 3.00));

        Farmacia f3 = new Farmacia("Bolivia", 5, "Zona Sur");
        f3.agregarMedicamento(new Medicamento("Tapsin", 301, "Resfrio", 6.00));

        arch.adicionar(f1);
        arch.adicionar(f2);
        arch.adicionar(f3);

        System.out.println("--- a) Medicamentos TOS Sucursal 10 ---");
        arch.mostrarMedicamentosTosSucursal(10);

        System.out.println("\n--- b) Sucursal y direccion de Tapsin ---");
        arch.buscarTapsin();

        System.out.println("\n--- c) Buscar tipo Dolor ---");
        arch.buscarPorTipo("Dolor");

        System.out.println("\n--- d) Ordenar por direccion ---");
        arch.ordenarPorDireccion();

        System.out.println("\n--- e) Mover tipo Tos de suc 10 a suc 20 ---");
        arch.moverMedicamentos("Tos", 10, 20);
        arch.listarTodas();
    }
}