public class Main {
    public static void main14(String[] args) {
        
        // --- 1. Creación de Objetos Empleado ---
        Empleado e1 = new Empleado("Ana Soto", "Gerente", 8500.00);
        Empleado e2 = new Empleado("Juan Pérez", "Desarrollador", 4500.50);
        Empleado e3 = new Empleado("Laura Díaz", "Diseñadora", 4800.00);
        Empleado e4 = new Empleado("Carlos Ruiz", "Pasante", 2000.00);
        
        // --- a) Crear una empresa y agregar varios empleados ---
        Empresa miEmpresa = new Empresa("Tech Solutions S.A.");
        miEmpresa.agregarEmpleado(e1);
        miEmpresa.agregarEmpleado(e2);
        miEmpresa.agregarEmpleado(e3);
        miEmpresa.agregarEmpleado(e4);

        // --- b) Mostrar la información de la empresa y sus empleados ---
        miEmpresa.mostrarInformacion();

        // --- c) Buscar un empleado por nombre ---
        String nombreBuscar = "Laura Díaz";
        System.out.println("\n--- c) BÚSQUEDA ---");
        Empleado buscado = miEmpresa.buscarEmpleado(nombreBuscar);
        if (buscado != null) {
            System.out.println("Empleado encontrado:");
            buscado.mostrarInfo();
        } else {
            System.out.println("Empleado " + nombreBuscar + " no encontrado.");
        }

        // --- d) Eliminar un empleado por nombre ---
        miEmpresa.eliminarEmpleado("Carlos Ruiz");
        miEmpresa.mostrarInformacion(); // Verificamos que fue eliminado

        // --- e) Calcular promedio salarial ---
        miEmpresa.calcularPromedioSalarial();
        
        // --- e) Listar empleados con salario mayor a un valor dado (ej: 5000) ---
        miEmpresa.listarSalarioMayorA(5000.00);
        
        // --- e) Listar empleados con salario mayor a un valor dado (ej: 4000) ---
        miEmpresa.listarSalarioMayorA(4000.00);
    }
}