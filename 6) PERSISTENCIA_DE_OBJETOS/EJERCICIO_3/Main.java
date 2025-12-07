package EJERCICIO_3;

public class Main {
    public static void main(String[] args) {
        ArchivoProducto arch = new ArchivoProducto("productos.dat");
        arch.crearArchivo();

        arch.guardarProducto(new Producto(101, "Leche", 6.50f));
        arch.guardarProducto(new Producto(102, "Pan", 0.50f));
        arch.guardarProducto(new Producto(103, "Queso", 25.00f));
        arch.guardarProducto(new Producto(104, "Yogurt", 12.00f));

        System.out.println("\n--- Buscando producto codigo 103 ---");
        Producto p = arch.buscaProducto(103);
        if (p != null) {
            System.out.println("Encontrado: " + p);
        } else {
            System.out.println("No existe ese codigo.");
        }

        System.out.println("\n--- Promedio de precios ---");
        arch.calcularPromedio();

        System.out.println("\n--- Producto mas caro ---");
        arch.mostrarMasCaro();
    }
}