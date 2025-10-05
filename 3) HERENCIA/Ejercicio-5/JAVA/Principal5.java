public class Principal5 {
    public static void main(String[] args) {
        // a) Instanciar un vehículo de cada tipo
        Vehiculo busEjemplo = new Bus("Carlos Ruiz", "BCA-100", 1, 50, "Sindicato Azul");
        Vehiculo autoEjemplo = new Auto("Ana Gómez", "AUT-202", 2, 250, true);

        System.out.println("--- b) Mostrar Placa y Conductor de cada vehículo ---");
        busEjemplo.mostrarDatos();
        autoEjemplo.mostrarDatos();

        System.out.println("\n--- c) Cambiar el conductor de un vehículo ---");
        autoEjemplo.cambiarConductor("Marta Linares");

        System.out.println("\n--- Verificación del cambio ---");
        autoEjemplo.mostrarDatos();
    }
}