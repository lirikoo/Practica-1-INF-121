import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        
        // --- 1. PRUEBA DE AGREGAR PRODUCTO (Punto c) ---
        
        Producto p1 = new Producto("A001", "Laptop", 1200.00, 10);
        Producto p2 = new Producto("A002", "Mouse", 15.00, 50);
        Producto p_existente = new Producto("A001", "Tablet", 300.00, 5);
        Producto p_invalido = new Producto("A003", "Monitor", 500.00, -5); // Stock negativo
        
        System.out.println("--- PRUEBA DE AGREGACIÓN ---");
        try {
            inventario.agregarProducto(p1); // ✅ Correcto
            inventario.agregarProducto(p2); // ✅ Correcto
            inventario.agregarProducto(p_invalido); // ❌ Debería fallar (Stock negativo)
        } catch (ProductoInvalidoException e) {
            System.err.println("❌ ERROR: " + e.getMessage());
        }
        try {
            inventario.agregarProducto(p_existente); // ❌ Debería fallar (Código repetido)
        } catch (ProductoInvalidoException e) {
            System.err.println("❌ ERROR: " + e.getMessage());
        }

        // --- 2. PRUEBA DE BÚSQUEDA (Punto d) ---
        
        System.out.println("\n--- PRUEBA DE BÚSQUEDA (ProductoNoEncontradoException) ---");
        try {
            Producto encontrado = inventario.buscarProducto("A002");
            System.out.println("✅ Producto encontrado: " + encontrado.getNombre());
            
            inventario.buscarProducto("X999"); // ❌ Debería fallar (No encontrado)
        } catch (ProductoNoEncontradoException e) {
            System.err.println("❌ ERROR: " + e.getMessage());
        }
        
        // --- 3. PRUEBA DE VENTA (Punto e) ---
        
        System.out.println("\n--- PRUEBA DE VENTA (StockInsuficienteException) ---");
        try {
            // Caso 1: Venta exitosa
            inventario.venderProducto("A001", 3);
            
            // Caso 2: Stock insuficiente (Intentar vender 10, cuando quedan 7)
            inventario.venderProducto("A001", 10); // ❌ Debería fallar
        } catch (ProductoNoEncontradoException e) {
            System.err.println("❌ ERROR fatal (Venta): " + e.getMessage());
        } catch (StockInsuficienteException e) {
            System.err.println("❌ ERROR: " + e.getMessage());
        }
        
        // Mostrar stock final
        try {
            inventario.buscarProducto("A001").mostrarInfo();
        } catch (ProductoNoEncontradoException ignored) { }
    }
}