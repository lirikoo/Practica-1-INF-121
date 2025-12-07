package EJERCICIO_10;

import java.io.*;
import java.util.Scanner;

public class ArchivoJugadores {
    private String nombreArchivo = "jugadores.txt";

    public ArchivoJugadores() {
    }

    public void crearArchivo() {
        try {
            File f = new File(nombreArchivo);
            if (f.createNewFile()) {
                System.out.println("Archivo jugadores.txt creado.");
            }
        } catch (Exception e) {
            System.out.println("Error al crear archivo.");
        }
    }

    public void guardarJugador(Jugador j) {
        try {
            // El 'true' sirve para agregar al final sin borrar lo anterior
            FileWriter fw = new FileWriter(nombreArchivo, true);
            PrintWriter pw = new PrintWriter(fw);
            // Guardamos separado por comas: Nombre,Nivel,Puntaje
            pw.println(j.getNombre() + "," + j.getNivel() + "," + j.getPuntaje());
            pw.close();
            System.out.println("Jugador guardado: " + j.getNombre());
        } catch (Exception e) {
            System.out.println("Error al guardar en texto.");
        }
    }

    public void listarJugadores() {
        System.out.println("--- Lista de Jugadores ---");
        try {
            File f = new File(nombreArchivo);
            if (f.exists()) {
                Scanner scanner = new Scanner(f);
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    // Separamos la linea por la coma
                    String[] datos = linea.split(",");
                    if (datos.length == 3) {
                        System.out.println("Nombre: " + datos[0] + " | Nivel: " + datos[1] + " | Pts: " + datos[2]);
                    }
                }
                scanner.close();
            } else {
                System.out.println("El archivo no existe aun.");
            }
        } catch (Exception e) {
            System.out.println("Error al leer archivo.");
        }
    }

    public void buscarJugador(String nombreBusqueda) {
        System.out.println("--- Buscando a: " + nombreBusqueda + " ---");
        boolean encontrado = false;
        try {
            File f = new File(nombreArchivo);
            if (f.exists()) {
                Scanner scanner = new Scanner(f);
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    String[] datos = linea.split(",");
                    // datos[0] es el nombre
                    if (datos[0].equalsIgnoreCase(nombreBusqueda)) {
                        System.out.println("ENCONTRADO -> Nivel: " + datos[1] + ", Puntaje: " + datos[2]);
                        encontrado = true;
                    }
                }
                scanner.close();
            }
        } catch (Exception e) {
            System.out.println("Error buscando.");
        }
        if (!encontrado) {
            System.out.println("No se encontro al jugador.");
        }
    }
}