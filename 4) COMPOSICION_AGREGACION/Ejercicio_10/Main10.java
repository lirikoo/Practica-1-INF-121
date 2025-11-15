import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Main10 {

    public static void main(String[] args) {
        
        // --- 0. Inicialización de Datos para la Prueba ---
        
        // Speakers
        Speaker s1 = new Speaker("Dr.", "García", 45, "100A", "IA");
        Speaker s2 = new Speaker("Lic.", "López", 30, "200B", "Marketing");
        Speaker s3 = new Speaker("Ing.", "Méndez", 55, "300C", "Finanzas"); // Speaker con CI=300C para eliminar
        
        // Participantes
        Participante p1 = new Participante("Carlos", "Rojas", 25, "400D", 1);
        Participante p2 = new Participante("Ana", "Soto", 35, "500E", 2);
        Participante p3 = new Participante("X", "Y", 40, "600F", 3); // Persona a buscar
        Participante p4 = new Participante("Elena", "Vargas", 22, "700G", 4);
        Participante p5 = new Participante("Pedro", "Gómez", 50, "800H", 5);

        // Charlas
        Charla c1 = new Charla("Salón A", "Futuro de la IA", s1);
        c1.agregarParticipante(p1);
        c1.agregarParticipante(p2);
        c1.agregarParticipante(p3); // 3 participantes
        
        Charla c2 = new Charla("Salón B", "Estrategias Digitales", s2);
        c2.agregarParticipante(p4);
        c2.agregarParticipante(p5); // 2 participantes
        
        Charla c3 = new Charla("Auditorio", "Inversión Segura", s3); // Charla de Speaker a eliminar
        c3.agregarParticipante(p1);
        c3.agregarParticipante(p4);
        c3.agregarParticipante(p5);
        c3.agregarParticipante(p3); // 4 participantes
        
        // Evento
        Evento evento = new Evento("Cumbre Tecnológica 2025");
        evento.agregarCharla(c1);
        evento.agregarCharla(c2);
        evento.agregarCharla(c3);
        
        System.out.println("==========================================");
        System.out.println("         RESOLUCIÓN DE EJERCICIO 10       ");
        System.out.println("==========================================");

        // --- a) Edad promedio de los participantes en el evento. ---
        calcularEdadPromedio(evento);

        // --- b) Verificar si la persona nombre "X" y apellido "Y" se encuentra en alguna charla ---
        verificarPersonaEnCharla(evento, "X", "Y");
        verificarPersonaEnCharla(evento, "Carlos", "Rojas");
        
        // --- c) Eliminar todas las charlas que iba a dar el speaker con C.I. X (300C) ---
        eliminarCharlasPorSpeaker(evento, "300C");
        
        // --- d) Ordenar las charlas por el número de participantes. ---
        ordenarCharlasPorParticipantes(evento);
    }
    
    // ==============================================================================
    // IMPLEMENTACIONES DE LOS PUNTOS A, B, C, D
    // ==============================================================================

    // --- a) Edad promedio ---
    public static void calcularEdadPromedio(Evento evento) {
        int sumaEdades = 0;
        int contador = 0;

        for (Charla charla : evento.getCharlas()) {
            for (Participante p : charla.getParticipantes()) {
                sumaEdades += p.getEdad();
                contador++;
            }
        }
        
        double promedio = (contador > 0) ? (double) sumaEdades / contador : 0;
        
        System.out.println("\n--- a) Edad Promedio de Participantes ---");
        System.out.printf("El promedio de edad de los %d participantes es: %.2f años.\n", contador, promedio);
    }

    // --- b) Verificar si la persona está en una charla (Participante o Speaker) ---
    public static void verificarPersonaEnCharla(Evento evento, String nombre, String apellido) {
        boolean encontrado = false;
        
        for (Charla charla : evento.getCharlas()) {
            String nombreBuscado = nombre + " " + apellido;

            // 1. Verificar como Speaker
            if (charla.getSpeaker().getNombreCompleto().equalsIgnoreCase(nombreBuscado)) {
                System.out.printf("\n--- b) Búsqueda de %s %s ---\n", nombre, apellido);
                System.out.printf("¡ENCONTRADO! La persona es SPEAKER de la charla: %s\n", charla.getNombreCharla());
                encontrado = true;
                break;
            }

            // 2. Verificar como Participante
            for (Participante p : charla.getParticipantes()) {
                if (p.getNombreCompleto().equalsIgnoreCase(nombreBuscado)) {
                    System.out.printf("\n--- b) Búsqueda de %s %s ---\n", nombre, apellido);
                    System.out.printf("¡ENCONTRADO! La persona es PARTICIPANTE de la charla: %s\n", charla.getNombreCharla());
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) break;
        }

        if (!encontrado) {
            System.out.printf("\n--- b) Búsqueda de %s %s ---\n", nombre, apellido);
            System.out.println("La persona no se encuentra ni como Speaker ni como Participante en ninguna charla.");
        }
    }

    // --- c) Eliminar charlas por CI del Speaker ---
    public static void eliminarCharlasPorSpeaker(Evento evento, String ciSpeaker) {
        System.out.println("\n--- c) Eliminando Charlas del Speaker CI: " + ciSpeaker + " ---");
        
        List<Charla> charlasEvento = evento.getCharlas();
        int charlasIniciales = charlasEvento.size();

        // Usamos removeIf para eliminar de forma segura
        charlasEvento.removeIf(charla -> {
            if (charla.getSpeaker().getCi().equalsIgnoreCase(ciSpeaker)) {
                System.out.println("  - ELIMINADA Charla: " + charla.getNombreCharla());
                return true;
            }
            return false;
        });
        
        int eliminadas = charlasIniciales - charlasEvento.size();
        System.out.println("  Total de charlas eliminadas: " + eliminadas);
        evento.nc = charlasEvento.size(); // Actualizar el contador del Evento
    }

    // --- d) Ordenar las charlas por el número de participantes ---
    public static void ordenarCharlasPorParticipantes(Evento evento) {
        System.out.println("\n--- d) Ordenando Charlas por Número de Participantes ---");
        
        List<Charla> charlas = evento.getCharlas();

        // Usamos Collections.sort con un Comparator lambda para ordenar por np (descendente)
        Collections.sort(charlas, Comparator.comparing(Charla::getNp).reversed());

        System.out.println("Charlas ordenadas:");
        for (Charla c : charlas) {
            System.out.printf("  - %s (Participantes: %d)\n", c.getNombreCharla(), c.getNp());
        }
    }
}