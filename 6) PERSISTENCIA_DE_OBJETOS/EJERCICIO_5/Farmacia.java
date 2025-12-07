package EJERCICIO_5;

public class Farmacia {
    private String nombreFarmacia;
    private int sucursal;
    private String direccion;
    private int nroMedicamentos;
    private Medicamento[] m;

    public Farmacia(String nombreFarmacia, int sucursal, String direccion) {
        this.nombreFarmacia = nombreFarmacia;
        this.sucursal = sucursal;
        this.direccion = direccion;
        this.nroMedicamentos = 0;
        this.m = new Medicamento[100];
    }

    public void agregarMedicamento(Medicamento med) {
        m[nroMedicamentos] = med;
        nroMedicamentos++;
    }

    public String getNombreFarmacia() {
        return nombreFarmacia;
    }

    public int getSucursal() {
        return sucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNroMedicamentos() {
        return nroMedicamentos;
    }

    public Medicamento[] getMedicamentos() {
        return m;
    }
    
    public void setNroMedicamentos(int n) {
        this.nroMedicamentos = n;
    }

    @Override
    public String toString() {
        return "Farmacia: " + nombreFarmacia + " Sucursal: " + sucursal + " Dir: " + direccion + " (Meds: " + nroMedicamentos + ")";
    }
}