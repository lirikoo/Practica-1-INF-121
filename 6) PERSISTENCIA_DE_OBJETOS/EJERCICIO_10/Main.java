package EJERCICIO_10;

public class Main {
    public static void main(String[] args) {
        // Simulacion de Especialidad: Desarrollo de Software
        System.out.println("Bienvenido al sistema de gestion de Videojuego.");
        
        ArchivoJugadores arch = new ArchivoJugadores();
        arch.crearArchivo();

        // Creamos y guardamos jugadores
        Jugador j1 = new Jugador("DragonSlayer", 55, 12000);
        Jugador j2 = new Jugador("NoobMaster69", 10, 500);
        Jugador j3 = new Jugador("ProGamer_Bol", 99, 99999);

        arch.guardarJugador(j1);
        arch.guardarJugador(j2);
        arch.guardarJugador(j3);

        // Mostramos todos
        System.out.println();
        arch.listarJugadores();

        // Buscamos un jugador especifico
        System.out.println();
        arch.buscarJugador("NoobMaster69");
        arch.buscarJugador("Ghost");
    }
}