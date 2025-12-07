public class Cabina {
    private int nroCabina;
    private Persona[] personasAbordo;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new Persona[10];
    }

    public int getNroCabina() {
        return nroCabina;
    }

    public Persona[] getPersonasAbordo() {
        return personasAbordo;
    }

    public int getCantidadActual() {
        int cant = 0;
        for (int i = 0; i < personasAbordo.length; i++) {
            if (personasAbordo[i] != null) {
                cant++;
            }
        }
        return cant;
    }

    public float getPesoActual() {
        float total = 0;
        for (int i = 0; i < personasAbordo.length; i++) {
            if (personasAbordo[i] != null) {
                total = total + personasAbordo[i].getPesoPersona();
            }
        }
        return total;
    }

    public void agregarPersona(Persona p) {
        if (getCantidadActual() >= 10) {
            System.out.println("Cabina llena");
            return;
        }
        if (getPesoActual() + p.getPesoPersona() > 850) {
            System.out.println("Excede peso maximo");
            return;
        }
        for (int i = 0; i < personasAbordo.length; i++) {
            if (personasAbordo[i] == null) {
                personasAbordo[i] = p;
                return; 
            }
        }
    }
}