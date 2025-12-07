package EJERCICIO_9;

public class Zoologico {
    private int id;
    private String nombre;
    private int nroAnimales;
    private Animal[] animales;

    public Zoologico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.nroAnimales = 0;
        this.animales = new Animal[30]; // Segun diagrama
    }

    public void agregarAnimal(Animal a) {
        if (nroAnimales < 30) {
            animales[nroAnimales] = a;
            nroAnimales++;
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroAnimales() {
        return nroAnimales;
    }

    public Animal[] getAnimales() {
        return animales;
    }
    
    public void vaciar() {
        this.nroAnimales = 0;
    }

    @Override
    public String toString() {
        return "Zoo [" + id + "] " + nombre + " | Variedad de Animales: " + nroAnimales;
    }
}