public class Bus {
    int capacidadMaxima;
    int pasajerosActuales;
    double recaudacion;
    final double COSTO_PASAJE = 1.50;

    public Bus(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.pasajerosActuales = 0;
        this.recaudacion = 0.0;
    }

    public void subir(int cantidad) {
        int asientosDisponibles = this.capacidadMaxima - this.pasajerosActuales;
        
        if (cantidad <= asientosDisponibles) {
            this.pasajerosActuales += cantidad;
        } else {
            System.out.println("ADVERTENCIA: Solo subieron " + asientosDisponibles + " pasajeros. Bus lleno.");
            this.pasajerosActuales = this.capacidadMaxima;
        }
    }

    public void cobrarPasaje(int cantidad) {
        this.recaudacion += cantidad * COSTO_PASAJE;
    }

    public void mostrarAsientosDisponibles() {
        System.out.println(this.capacidadMaxima - this.pasajerosActuales);
    }
    
    public double getRecaudacion() {
        return this.recaudacion;
    }
    
    public int getPasajerosActuales() {
        return this.pasajerosActuales;
    }

    public static void main(String[] args) {
        Bus miBus = new Bus(50);

        System.out.println("Capacidad Maxima del bus: " + miBus.capacidadMaxima);
        System.out.println("Pasajeros iniciales: " + miBus.getPasajerosActuales());
        System.out.printf("Recaudacion inicial: $%.2f%n", miBus.getRecaudacion());

        System.out.println("\n---  Suben 10 pasajeros ---");
        miBus.subir(10);
        miBus.cobrarPasaje(10);
        System.out.println("Pasajeros actuales: " + miBus.getPasajerosActuales());
        System.out.printf("Recaudacinn total: $%.2f%n", miBus.getRecaudacion());
        System.out.print("Asientos disponibles: ");
        miBus.mostrarAsientosDisponibles();

        System.out.println("\n--- Suben 45 pasajeros (solo caben 40) ---");
        miBus.subir(45);
        miBus.cobrarPasaje(45);
        System.out.println("Pasajeros actuales: " + miBus.getPasajerosActuales());
        System.out.printf("Recaudacion total: $%.2f%n", miBus.getRecaudacion());
        System.out.print("Asientos disponibles: ");
        miBus.mostrarAsientosDisponibles();
    }
}