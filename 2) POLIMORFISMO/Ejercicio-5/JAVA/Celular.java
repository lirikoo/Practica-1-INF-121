public class Celular {
    private String nroTel;
    private String dueño;
    private float espacio;
    private int ram;
    private int nroApp;

    public Celular(String nroTel, String dueño, float espacio, int ram, int nroApp) {
        this.nroTel = nroTel;
        this.dueño = dueño;
        this.espacio = espacio;
        this.ram = ram;
        this.nroApp = nroApp;
    }

    public float getEspacio() {
        return espacio;
    }

    public int getNroApp() {
        return nroApp;
    }

    @Override
    public String toString() {
        return "Dueño: " + dueño + ", Apps: " + nroApp + ", Espacio: " + espacio + " GB";
    }

    // b) Sobrecarga operador ++ (Simulación)
    public void aumentarNroApp() {
        this.nroApp += 10;
    }

    // c) Sobrecarga operador -- (Simulación)
    public void disminuirEspacio() {
        this.espacio -= 5.0f;
        if (this.espacio < 0) {
            this.espacio = 0.0f;
        }
    }
}