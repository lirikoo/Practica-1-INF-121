import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombre;
    private String area;
    private List<Empleado> empleados;
    public Departamento(String nombre, String area) {
        this.nombre = nombre;
        this.area = area;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }
    
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void mostrarEmpleados() {
        System.out.println("\n--- Departamento: " + nombre + " (" + area + ") ---");
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados en este departamento.");
        } else {
            for (Empleado emp : empleados) {
                System.out.println("  - Nombre: " + emp.getNombre() + ", Sueldo: " + emp.getSueldo());
            }
        }
    }

    public void cambioSalario(double porcentajeAumento) {
        System.out.println("\n*** Aplicando aumento del " + porcentajeAumento + "% a todos los empleados de " + this.nombre + " ***");
        for (Empleado emp : empleados) {
            emp.cambiarSalario(porcentajeAumento);
        }
    }
    
    public boolean contieneEmpleado(Empleado empleadoAComprobar) {
        return this.empleados.contains(empleadoAComprobar);
    }
    
    public void removerEmpleado(Empleado empleado) {
        this.empleados.remove(empleado);
    }
}