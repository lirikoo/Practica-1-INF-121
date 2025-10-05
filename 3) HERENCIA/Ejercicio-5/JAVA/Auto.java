public class Auto extends Vehiculo {
    private int caballosFuerza;
    private boolean descapotable;

    public Auto(String conductor, String placa, int id, int caballosFuerza, boolean descapotable) {
        super(conductor, placa, id);
        this.caballosFuerza = caballosFuerza;
        this.descapotable = descapotable;
    }

    public void mostrarDatosCompletos() {
        mostrarDatos();
        String estado = this.descapotable ? "Sí" : "No";
        System.out.println("Tipo: Auto, Caballos de Fuerza: " + this.caballosFuerza + ", Descapotable: " + estado);
    }
}