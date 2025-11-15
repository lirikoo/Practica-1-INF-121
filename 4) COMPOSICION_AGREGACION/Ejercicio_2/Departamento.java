import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombre;
    private String area;
    // Lista para la Agregación: un Departamento tiene muchos Empleados
    private List<Empleado> empleados;

    // Constructor
    public Departamento(String nombre, String area) {
        this.nombre = nombre;
        this.area = area;
        // Inicializamos la lista de empleados.
        this.empleados = new ArrayList<>();
    }

    // Método para agregar un empleado (esencial para la Agregación)
    public void agregarEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }
    
    // Getter para la lista de empleados (necesario para el punto 'e')
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    // b) Agregar el método mostrarEmpleados()
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

    // c) Implementar cambioSalario() para todos los empleados de un departamento
    public void cambioSalario(double porcentajeAumento) {
        System.out.println("\n*** Aplicando aumento del " + porcentajeAumento + "% a todos los empleados de " + this.nombre + " ***");
        for (Empleado emp : empleados) {
            emp.cambiarSalario(porcentajeAumento);
        }
    }
    
    // d) Verificar si un empleado pertenece a este departamento
    public boolean contieneEmpleado(Empleado empleadoAComprobar) {
        return this.empleados.contains(empleadoAComprobar);
    }
    
    // Método auxiliar para mover empleados (necesario para el punto 'e')
    public void removerEmpleado(Empleado empleado) {
        this.empleados.remove(empleado);
    }
}