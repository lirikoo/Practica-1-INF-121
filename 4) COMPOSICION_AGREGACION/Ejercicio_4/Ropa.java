public public class Ropa {
    private String tipo;
    private String material;

    public Ropa(String tipo, String material) {
        this.tipo = tipo;
        this.material = material;
    }

    // Getters para acceder a los atributos desde Ropero
    public String getTipo() {
        return tipo;
    }

    public String getMaterial() {
        return material;
    }

    public void mostrarInformacion() {
        System.out.println("  [Ropa] Tipo: " + tipo + ", Material: " + material);
    }
} 
    

