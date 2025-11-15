import java.util.ArrayList;
import java.util.List;
public class Main2 {
    public static void main(String[] args) {
        
        Empleado emp1 = new Empleado("Juan Pérez", "Desarrollador Senior", 50000.0);
        Empleado emp2 = new Empleado("Ana López", "Gerente de Proyecto", 75000.0);
        Empleado emp3 = new Empleado("Carlos Ruiz", "Diseñador Junior", 35000.0);
        Empleado emp4 = new Empleado("María Soto", "Analista QA", 45000.0);
        Empleado emp5 = new Empleado("Pedro Gómez", "Líder Técnico", 80000.0);
        
        Departamento dptoVentas = new Departamento("Ventas", "Comercial");
        dptoVentas.agregarEmpleado(emp1);
        dptoVentas.agregarEmpleado(emp2);
        dptoVentas.agregarEmpleado(emp3);
        dptoVentas.agregarEmpleado(emp4);
        dptoVentas.agregarEmpleado(emp5);

        Departamento dptoRRHH = new Departamento("Recursos Humanos", "Administrativo");

        System.out.println("--- B) Estado Inicial de Empleados ---");
        dptoVentas.mostrarEmpleados();
        dptoRRHH.mostrarEmpleados();


        dptoVentas.cambioSalario(10.0); // Aumento del 10%

        dptoVentas.mostrarEmpleados();


        System.out.println("\n--- D) Verificación de Pertenencia ---");
        boolean pertenece = dptoRRHH.contieneEmpleado(emp1);
        System.out.println("¿'Juan Pérez' (dptoVentas) pertenece a RRHH? " + (pertenece ? "Sí" : "No"));

        boolean pertenece2 = dptoVentas.contieneEmpleado(emp3);
        System.out.println("¿'Carlos Ruiz' (dptoVentas) pertenece a Ventas? " + (pertenece2 ? "Sí" : "No"));
        

        System.out.println("\n--- E) Moviendo Empleados (Agregación) ---");
        
        List<Empleado> empleadosAMover = new ArrayList<>(dptoVentas.getEmpleados());
        
        for (Empleado emp : empleadosAMover) {
            dptoRRHH.agregarEmpleado(emp);
            dptoVentas.removerEmpleado(emp);
            System.out.println("Moviendo a " + emp.getNombre() + "...");
        }

        System.out.println("\n*** Estado Final después de la transferencia ***");
        dptoVentas.mostrarEmpleados(); 
        dptoRRHH.mostrarEmpleados(); 
    }
}