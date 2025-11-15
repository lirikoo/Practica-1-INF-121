public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters necesarios
    public String getCodigo() { return codigo; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }

    public void mostrarInfo() {
        System.out.printf("  [Producto: %s] %s | Precio: %.2f | Stock: %d\n", 
                          codigo, nombre, precio, stock);
    }
}