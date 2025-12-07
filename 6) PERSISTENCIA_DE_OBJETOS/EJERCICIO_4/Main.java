package EJERCICIO_4;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArchiNota arch = new ArchiNota("notas.dat");
        arch.crearArchivo();

        Estudiante e1 = new Estudiante(1001, "Ana", "Torres", "Lopez", 20);
        Estudiante e2 = new Estudiante(1002, "Luis", "Mamani", "Perez", 21);
        Estudiante e3 = new Estudiante(1003, "Carla", "Flores", "Rojas", 19);

        ArrayList<Nota> grupo = new ArrayList<>();
        grupo.add(new Nota("Calculo", 85.5, e1));
        grupo.add(new Nota("Calculo", 40.0, e2));
        grupo.add(new Nota("Fisica", 90.0, e3));
        grupo.add(new Nota("Fisica", 90.0, e1)); 

        System.out.println("--- Agregando estudiantes ---");
        arch.agregarVariosEstudiantes(grupo);
        arch.mostrarTodo();

        System.out.println("\n--- Promedio de Notas ---");
        arch.promedioNotas();

        System.out.println("\n--- Buscar Mejor Nota ---");
        arch.buscarMejorNota();

        System.out.println("\n--- Eliminar Materia Calculo ---");
        arch.eliminarPorMateria("Calculo");
        arch.mostrarTodo();
    }
}