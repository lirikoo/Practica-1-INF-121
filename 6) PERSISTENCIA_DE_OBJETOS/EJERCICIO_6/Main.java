package EJERCICIO_6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArchLibro aLib = new ArchLibro("libros.dat");
        ArchCliente aCli = new ArchCliente("clientes.dat");
        ArchPrestamo aPres = new ArchPrestamo("prestamos.dat");

        aLib.crear();
        aCli.crear();
        aPres.crear();

        // 1. Cargamos datos de prueba
        aLib.guardar(new Libro(100, "Programacion Java", 50.0));
        aLib.guardar(new Libro(101, "Estructura de Datos", 45.0));
        aLib.guardar(new Libro(102, "Historia Universal", 30.0)); // Este no lo venderemos para probar el inciso C

        aCli.guardar(new Cliente(1, 123456, "Juan", "Perez"));
        aCli.guardar(new Cliente(2, 654321, "Maria", "Lopez"));

        aPres.guardar(new Prestamo(1, 100, "01/12/2025", 2)); // Juan compra 2 de Java
        aPres.guardar(new Prestamo(2, 100, "02/12/2025", 1)); // Maria compra 1 de Java
        aPres.guardar(new Prestamo(1, 101, "03/12/2025", 1)); // Juan compra 1 de Estructura

        // --- a) Listar libros entre precios ---
        System.out.println("\n--- a) Libros entre 40 y 60 Bs ---");
        aLib.listarEntrePrecios(40, 60);

        // --- b) Ingreso total generado por un libro (ej. Codigo 100) ---
        System.out.println("\n--- b) Ingreso total del Libro 100 ---");
        calcularIngreso(100, aLib, aPres);

        // --- c) Libros nunca vendidos (que no estan en prestamos) ---
        System.out.println("\n--- c) Libros nunca prestados/vendidos ---");
        mostrarLibrosSinVentas(aLib, aPres);

        // --- d) Clientes que compraron el libro 100 ---
        System.out.println("\n--- d) Clientes que llevaron el libro 100 ---");
        mostrarClientesDeLibro(100, aCli, aPres);

        // --- e) Libro mas prestado ---
        System.out.println("\n--- e) El libro mas prestado es ---");
        mostrarMasPrestado(aLib, aPres);
    }

    public static void calcularIngreso(int codL, ArchLibro al, ArchPrestamo ap) {
        ArrayList<Libro> libros = al.listar();
        ArrayList<Prestamo> prestamos = ap.listar();
        double precio = 0;
        
        // Buscamos precio
        for (Libro l : libros) {
            if (l.getCodLibro() == codL) precio = l.getPrecio();
        }

        // Sumamos cantidades
        int totalCant = 0;
        for (Prestamo p : prestamos) {
            if (p.getCodLibro() == codL) totalCant += p.getCantidad();
        }

        System.out.println("Total recaudado: " + (totalCant * precio) + " Bs.");
    }

    public static void mostrarLibrosSinVentas(ArchLibro al, ArchPrestamo ap) {
        ArrayList<Libro> libros = al.listar();
        ArrayList<Prestamo> prestamos = ap.listar();

        for (Libro l : libros) {
            boolean vendido = false;
            for (Prestamo p : prestamos) {
                if (p.getCodLibro() == l.getCodLibro()) {
                    vendido = true;
                }
            }
            if (!vendido) {
                System.out.println(l);
            }
        }
    }

    public static void mostrarClientesDeLibro(int codL, ArchCliente ac, ArchPrestamo ap) {
        ArrayList<Cliente> clientes = ac.listar();
        ArrayList<Prestamo> prestamos = ap.listar();

        for (Prestamo p : prestamos) {
            if (p.getCodLibro() == codL) {
                // Buscamos al cliente de este prestamo
                for (Cliente c : clientes) {
                    if (c.getCodCliente() == p.getCodCliente()) {
                        System.out.println(c);
                    }
                }
            }
        }
    }

    public static void mostrarMasPrestado(ArchLibro al, ArchPrestamo ap) {
        ArrayList<Libro> libros = al.listar();
        ArrayList<Prestamo> prestamos = ap.listar();

        Libro masVendido = null;
        int maxCant = -1;

        for (Libro l : libros) {
            int cantTotal = 0;
            for (Prestamo p : prestamos) {
                if (p.getCodLibro() == l.getCodLibro()) {
                    cantTotal += p.getCantidad();
                }
            }
            if (cantTotal > maxCant) {
                maxCant = cantTotal;
                masVendido = l;
            }
        }

        if (masVendido != null) {
            System.out.println("Libro: " + masVendido.getTitulo() + " con " + maxCant + " prestamos.");
        }
    }
}