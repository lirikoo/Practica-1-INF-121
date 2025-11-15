public class Empleado {
    private String nombre;
    private String puesto;
    private double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    // Getters necesarios para las operaciones en la clase Empresa
    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void mostrarInfo() {
        System.out.printf("  [Empleado] Nombre: %s, Puesto: %s, Salario: %.2f\n", 
                          nombre, puesto, salario);
    }
}