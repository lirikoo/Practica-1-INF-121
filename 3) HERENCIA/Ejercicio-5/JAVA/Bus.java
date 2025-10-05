public class Bus extends Vehiculo {
    // Atributos privados (-)
    private int capacidad;
    private String sindicato;

    public Bus(String conductor, String placa, int id, int capacidad, String sindicato) {
        super(conductor, placa, id);
        this.capacidad = capacidad;
        this.sindicato = sindicato;
    }

    public void mostrarDatosCompletos() {
        mostrarDatos();
        System.out.println("Tipo: Bus, Capacidad: " + this.capacidad + ", Sindicato: " + this.sindicato);
    }
}