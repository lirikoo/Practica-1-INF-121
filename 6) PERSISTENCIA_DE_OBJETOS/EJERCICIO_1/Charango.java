package EJERCICIO_1;
import java.util.Arrays;

public class Charango {
    private String material;
    private int nroCuerdas;
    private boolean[] cuerdas;

    public Charango(String material, int nroCuerdas, boolean[] cuerdas) {
        this.material = material;
        this.nroCuerdas = nroCuerdas;
        this.cuerdas = cuerdas;
    }

    public String getMaterial() {
        return material;
    }

    public int getNroCuerdas() {
        return nroCuerdas;
    }

    public boolean[] getCuerdas() {
        return cuerdas;
    }

    @Override
    public String toString() {
        return "Charango [Material=" + material + ", Cuerdas=" + nroCuerdas + ", Estado=" + Arrays.toString(cuerdas) + "]";
    }
}