public class Vehiculo {
    // Atributos protegidos (#)
    protected String conductor;
    protected String placa;
    protected int id;

    public Vehiculo(String conductor, String placa, int id) {
        this.conductor = conductor;
        this.placa = placa;
        this.id = id;
    }

    // b) Mostrar la Placa y conductor cada vehículo.
    public void mostrarDatos() {
        System.out.println("ID: " + this.id + ", Placa: " + this.placa + ", Conductor: " + this.conductor);
    }

    // c) Crear un método para cambiar al conductor de un vehículo
    public void cambiarConductor(String nuevoConductor) {
        this.conductor = nuevoConductor;
        System.out.println("El conductor del vehículo con placa " + this.placa + " ha cambiado a " + nuevoConductor + ".");
    }
}