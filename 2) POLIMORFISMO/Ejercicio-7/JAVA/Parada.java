public class Parada {
    private String[] admins;
    private String[][] autos;
    private String nombreP;

    private int nroAdmins;
    private int nroAutos;

    // a) Constructor por defecto
    public Parada() {
        this.nombreP = "Parada Sin Nombre";
        this.admins = new String[10];
        this.autos = new String[10][3];
        this.nroAdmins = 0;
        this.nroAutos = 0;
    }

    // a) Constructor parametrizado
    public Parada(String nombreP) {
        this.nombreP = nombreP;
        this.admins = new String[10];
        this.autos = new String[10][3];
        this.nroAdmins = 0;
        this.nroAutos = 0;
    }

    // b) Método mostrar
    public void mostrar() {
        System.out.println("\n-------------------------------------");
        System.out.println("PARADA: " + this.nombreP);

        System.out.println("ADMINISTRADORES (" + this.nroAdmins + " de 10):");
        if (this.nroAdmins > 0) {
            for (int i = 0; i < this.nroAdmins; i++) {
                System.out.println("  " + (i + 1) + ". " + this.admins[i]);
            }
        } else {
            System.out.println("  (No hay administradores)");
        }

        System.out.println("AUTOS (" + this.nroAutos + " de 10):");
        if (this.nroAutos > 0) {
            System.out.println("  Índice | Modelo | Conductor | Placa");
            for (int i = 0; i < this.nroAutos; i++) {
                System.out.printf("  %5d | %s | %s | %s%n",
                        (i + 1), this.autos[i][0], this.autos[i][1], this.autos[i][2]);
            }
        } else {
            System.out.println("  (No hay autos)");
        }
        System.out.println("-------------------------------------");
    }

    // c) Método adicionar(x) - Adiciona un administrador
    // Sobrecarga 1
    public void adicionar(String x) {
        if (this.nroAdmins < 10) {
            this.admins[this.nroAdmins] = x;
            this.nroAdmins++;
        } else {
            System.out.println("[ERROR] Límite de administradores (10) alcanzado.");
        }
    }

    // d) Método adicionar(x, y, z) - Adiciona un auto
    // Sobrecarga 2 (Polimorfismo)
    public void adicionar(String modelo, String conductor, String placa) {
        if (this.nroAutos < 10) {
            this.autos[this.nroAutos][0] = modelo;
            this.autos[this.nroAutos][1] = conductor;
            this.autos[this.nroAutos][2] = placa;
            this.nroAutos++;
        } else {
            System.out.println("[ERROR] Límite de autos (10) alcanzado.");
        }
    }
}