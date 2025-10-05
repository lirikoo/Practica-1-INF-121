import java.util.ArrayList;

public class Principal13 {
    public static void main(String[] args) {
        // a) Instanciar 1 Chef, 2 Meseros y 2 Administrativos.
        Empleado chef = new Chef("Gustave", 4000.0f, 10, "Pastelería", 25.0f);
        Empleado mesero1 = new Mesero("Alfredo", 1500.0f, 500.0, 5, 10.0f);
        Empleado mesero2 = new Mesero("Colette", 1500.0f, 650.0, 15, 10.0f);
        Empleado admin1 = new Empleado("Skinner", 3000.0f); // Administrativo solo usa Empleado
        Empleado admin2 = new Empleado("Amelie", 2800.0f);

        ArrayList<Empleado> personal = new ArrayList<>();
        personal.add(chef);
        personal.add(mesero1);
        personal.add(mesero2);
        personal.add(admin1);
        personal.add(admin2);

        System.out.println("--- c) Sueldos Totales (Polimorfismo) ---");
        for (Empleado e : personal) {
            System.out.printf("%s | Sueldo TOTAL: $%,.2f%n", e.nombre, e.sueldoTotal());
        }
        System.out.println("----------------------------------------");

        // b) Mostrar a aquellos Empleados que tengan sueldomes igual a X.
        float X = 1500.0f;
        System.out.printf("--- b) Empleados con sueldomes igual a $%,.2f ---%n", X);
        for (Empleado e : personal) {
            if (e.sueldomes == X) {
                System.out.printf("ENCONTRADO: %s%n", e.nombre);
            }
        }
    }
}