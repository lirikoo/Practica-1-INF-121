import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa {
    private String nombre;
    // Agregación: Lista de objetos Empleado
    private List<Empleado> empleados; 

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    // a) Método para agregar empleados
    public void agregarEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
        System.out.println("-> Añadido: " + empleado.getNombre());
    }

    // b) Mostrar información de la empresa y sus empleados
    public void mostrarInformacion() {
        System.out.println("\n*** INFORMACIÓN DE LA EMPRESA ***");
        System.out.println("Nombre de la Empresa: " + nombre);
        System.out.println("Total de Empleados: " + empleados.size());
        
        System.out.println("--- Lista de Empleados ---");
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado emp : empleados) {
                emp.mostrarInfo();
            }
        }
        System.out.println("---------------------------------");
    }

    // c) Implementar un método para buscar un empleado por nombre
    public Empleado buscarEmpleado(String nombreBuscado) {
        for (Empleado emp : empleados) {
            if (emp.getNombre().equalsIgnoreCase(nombreBuscado)) {
                return emp;
            }
        }
        return null; // Retorna null si no se encuentra
    }

    // d) Crear un método para eliminar un empleado de la empresa por nombre
    public boolean eliminarEmpleado(String nombreEliminar) {
        boolean eliminado = this.empleados.removeIf(emp -> emp.getNombre().equalsIgnoreCase(nombreEliminar));
        
        if (eliminado) {
            System.out.println("\n✅ ELIMINADO: El empleado " + nombreEliminar + " fue retirado de la empresa.");
        } else {
            System.out.println("\n❌ ERROR: No se encontró al empleado " + nombreEliminar + " para eliminar.");
        }
        return eliminado;
    }
    
    // e) Método para calcular y mostrar el promedio salarial
    public void calcularPromedioSalarial() {
        if (empleados.isEmpty()) {
            System.out.println("\nE) PROMEDIO SALARIAL: No hay empleados para calcular el promedio.");
            return;
        }

        double sumaSalarios = 0;
        for (Empleado emp : empleados) {
            sumaSalarios += emp.getSalario();
        }

        double promedio = sumaSalarios / empleados.size();
        System.out.printf("\nE) PROMEDIO SALARIAL: %.2f\n", promedio);
    }

    // e) Método para listar todos los empleados que tengan un salario mayor a un valor dado
    public void listarSalarioMayorA(double valor) {
        System.out.printf("\nE) LISTADO: Empleados con salario mayor a %.2f:\n", valor);

        // Usamos Streams para filtrar de manera eficiente
        List<Empleado> filtrados = empleados.stream()
            .filter(emp -> emp.getSalario() > valor)
            .collect(Collectors.toList());

        if (filtrados.isEmpty()) {
            System.out.println("  No se encontraron empleados que superen ese salario.");
        } else {
            filtrados.forEach(Empleado::mostrarInfo);
        }
    }
}