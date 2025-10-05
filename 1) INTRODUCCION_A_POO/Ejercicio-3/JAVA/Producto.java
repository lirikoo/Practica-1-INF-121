public class Producto {
    String nombre;
    double precio;
    int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void vender(int cantidad) {
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
        }
    }

    public void reabastecer(int cantidad) {
        this.stock += cantidad;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + " | Precio: $" + precio + " | Stock: " + stock;
    }

    public static void main(String[] args) {
        Producto arroz = new Producto("Arroz", 3.25, 100);

        System.out.println("--- PRUEBA DE CLASE PRODUCTO (JAVA) ---");
        System.out.println("Estado Inicial:");
        System.out.println(arroz);

        arroz.vender(20);
        System.out.println("\nDespués de vender 20 unidades:");
        System.out.println(arroz);

        arroz.reabastecer(50);
        System.out.println("\nDespués de reabastecer 50 unidades:");
        System.out.println(arroz);

        arroz.vender(200);
        System.out.println("\nIntentando vender 200 (sin stock suficiente):");
        System.out.println(arroz);
    }
}
