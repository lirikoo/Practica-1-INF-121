import java.util.ArrayList;
import java.util.List;
public class Main2 {
    public static void main(String[] args) {
        
        // Creamos algunos empleados que existirán independientemente de los departamentos
        Empleado emp1 = new Empleado("Juan Pérez", "Desarrollador Senior", 50000.0);
        Empleado emp2 = new Empleado("Ana López", "Gerente de Proyecto", 75000.0);
        Empleado emp3 = new Empleado("Carlos Ruiz", "Diseñador Junior", 35000.0);
        Empleado emp4 = new Empleado("María Soto", "Analista QA", 45000.0);
        Empleado emp5 = new Empleado("Pedro Gómez", "Líder Técnico", 80000.0);
        
        // a) Instanciar 2 departamentos, uno con 5 empleados y el otro sin empleados.
        
        // Departamento 1 (Con 5 empleados)
        Departamento dptoVentas = new Departamento("Ventas", "Comercial");
        dptoVentas.agregarEmpleado(emp1);
        dptoVentas.agregarEmpleado(emp2);
        dptoVentas.agregarEmpleado(emp3);
        dptoVentas.agregarEmpleado(emp4);
        dptoVentas.agregarEmpleado(emp5);

        // Departamento 2 (Sin empleados)
        Departamento dptoRRHH = new Departamento("Recursos Humanos", "Administrativo");

        // b) Mostrar empleados de ambos departamentos
        System.out.println("--- B) Estado Inicial de Empleados ---");
        dptoVentas.mostrarEmpleados();
        dptoRRHH.mostrarEmpleados();


        // c) Implementar cambioSalario() para todos los empleados de un departamento en específico.
        dptoVentas.cambioSalario(10.0); // Aumento del 10%

        // Mostrar salarios actualizados (punto b nuevamente para verificación)
        dptoVentas.mostrarEmpleados();


        // d) Verificar si algún empleado del departamento 1 pertenece al departamento 2.
        System.out.println("\n--- D) Verificación de Pertenencia ---");
        // Verificamos si emp1, que está en dptoVentas, está en dptoRRHH
        boolean pertenece = dptoRRHH.contieneEmpleado(emp1);
        System.out.println("¿'Juan Pérez' (dptoVentas) pertenece a RRHH? " + (pertenece ? "Sí" : "No"));

        // Verificamos si emp3, que está en dptoVentas, está en dptoVentas
        boolean pertenece2 = dptoVentas.contieneEmpleado(emp3);
        System.out.println("¿'Carlos Ruiz' (dptoVentas) pertenece a Ventas? " + (pertenece2 ? "Sí" : "No"));
        

        // e) Mover los empleados del departamento 1 al departamento 2. Tras eso mostrar de nuevo los departamentos.
        System.out.println("\n--- E) Moviendo Empleados (Agregación) ---");
        
        // Creamos una copia de la lista de empleados a mover para evitar problemas de concurrencia al remover.
        List<Empleado> empleadosAMover = new ArrayList<>(dptoVentas.getEmpleados());
        
        for (Empleado emp : empleadosAMover) {
            // 1. Añadir al nuevo departamento
            dptoRRHH.agregarEmpleado(emp);
            // 2. Remover del departamento original
            dptoVentas.removerEmpleado(emp);
            System.out.println("Moviendo a " + emp.getNombre() + "...");
        }

        // Mostrar estado final (punto b nuevamente para verificación)
        System.out.println("\n*** Estado Final después de la transferencia ***");
        dptoVentas.mostrarEmpleados(); // Ahora debe estar vacío
        dptoRRHH.mostrarEmpleados(); // Ahora debe tener 5 empleados
    }
}