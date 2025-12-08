import java.io.File;

public class Main {
    public static void main(String[] args) {
        String pathMedicos = "archivos/medicos";
        String pathConsultas = "archivos/consultas";

        new File(pathMedicos).mkdirs();
        new File(pathConsultas).mkdirs();

        Consultorio consultorio = new Consultorio(pathConsultas, pathMedicos);

        System.out.println("=== A) ALTA DE 3 MEDICOS Y 9 CONSULTAS (GSON) ===");
        
        consultorio.agregarMedico(new Medico(1, "Juan", "Perez", 10));
        consultorio.agregarMedico(new Medico(2, "Ana", "Gomez", 5));
        consultorio.agregarMedico(new Medico(3, "Luis", "Lopez", 15));

        consultorio.agregarConsulta(new Consulta(101, "Pedro", "Diaz", 1, 10, "marzo", 2023));
        consultorio.agregarConsulta(new Consulta(102, "Maria", "Sol", 1, 25, "diciembre", 2023)); // Navidad
        consultorio.agregarConsulta(new Consulta(103, "Jose", "Cruz", 1, 14, "julio", 2023));

        consultorio.agregarConsulta(new Consulta(201, "Edgar", "Ramirez", 2, 22, "febrero", 2023));
        consultorio.agregarConsulta(new Consulta(202, "Luisa", "Lane", 2, 1, "enero", 2024)); // Año nuevo
        consultorio.agregarConsulta(new Consulta(203, "Clark", "Kent", 2, 5, "agosto", 2023));

        consultorio.agregarConsulta(new Consulta(301, "Bruce", "Wayne", 3, 25, "diciembre", 2023)); // Navidad
        consultorio.agregarConsulta(new Consulta(302, "Diana", "Prince", 3, 10, "octubre", 2023));
        consultorio.agregarConsulta(new Consulta(303, "Barry", "Allen", 3, 1, "enero", 2024)); // Año nuevo

        consultorio.mostrarMedicos();
        consultorio.mostrarConsultas();

        System.out.println("\n=== B) BAJA DE DRA. ANA GOMEZ Y SUS CONSULTAS ===");
        consultorio.bajaMedicoYConsultas("Ana", "Gomez");
        
        System.out.println("--- verificamos ---");
        consultorio.mostrarMedicos(); 
        consultorio.mostrarConsultas(); 

        System.out.println("C) CAMBIAR FECHAS FESTIVAS (Navidad/Año Nuevo) ");
        consultorio.cambiarFechasFestivas();
        
        System.out.println("--- Verificamos---");
        consultorio.mostrarConsultas(); 
    }
}