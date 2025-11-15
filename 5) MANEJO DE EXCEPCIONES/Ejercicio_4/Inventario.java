import java.util.ArrayList;
import java.util.List;

public class Inventario {
    // Agregación: Lista de objetos Producto
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }
    
    // Método auxiliar para verificar existencia por código
    private boolean existeCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    // c) Implementar agregarProducto(Producto p) que lance una excepción
    public void agregarProducto(Producto p) throws ProductoInvalidoException {
        // 1. Validar precio/stock negativos
        if (p.getPrecio() < 0 || p.getStock() < 0) {
            throw new ProductoInvalidoException("ERROR: El precio o el stock no pueden ser valores negativos.");
        }
        
        // 2. Validar código existente
        if (existeCodigo(p.getCodigo())) {
            throw new ProductoInvalidoException("ERROR: El producto con código " + p.getCodigo() + " ya existe en el inventario.");
        }

        // Si pasa las validaciones, se agrega
        this.productos.add(p);
        System.out.println("✅ Producto agregado: " + p.getNombre());
    }

    // d) Implementar buscarProducto(String codigo) que lance ProductoNoEncontradoException
    public Producto buscarProducto(String codigo) throws ProductoNoEncontradoException {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        // Si el ciclo termina sin encontrar el producto
        throw new ProductoNoEncontradoException("ERROR: Producto con código " + codigo + " no fue encontrado.");
    }

    // e) Implementar venderProducto(...) que lance StockInsuficienteException
    public void venderProducto(String codigo, int cantidad) throws ProductoNoEncontradoException, StockInsuficienteException {
        
        // 1. Buscar el producto (usamos el método que ya lanza excepción si no lo encuentra)
        Producto p = buscarProducto(codigo);
        
        // 2. Validar stock
        if (p.getStock() < cantidad) {
            throw new StockInsuficienteException("ERROR: Stock insuficiente. Solo hay " + p.getStock() + " unidades disponibles de " + p.getNombre());
        }

        // 3. Realizar la venta y actualizar stock
        p.setStock(p.getStock() - cantidad);
        System.out.println("✅ Venta exitosa: Se vendieron " + cantidad + " unidades de " + p.getNombre() + ". Nuevo stock: " + p.getStock());
    }
}