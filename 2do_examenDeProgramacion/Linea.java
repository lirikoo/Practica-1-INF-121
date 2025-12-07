public class Linea {
    private String color;
    private Persona[] filaPersonas;
    private Cabina[] cabinas;
    private int cantidadCabinas;

    public Linea(String color, int cantidadCabinas) {
        this.color = color;
        this.cantidadCabinas = cantidadCabinas;
        this.cabinas = new Cabina[cantidadCabinas];
        for (int i = 0; i < cantidadCabinas; i++) {
            this.cabinas[i] = new Cabina(i + 1);
        }
        this.filaPersonas = new Persona[50];
    }

    public String getColor() {
        return color;
    }

    public Cabina[] getCabinas() {
        return cabinas;
    }

    public void subirPersonaACabinaEspecifica(Persona p, int nroCabina) {
        for (int i = 0; i < cabinas.length; i++) {
            if (cabinas[i] != null && cabinas[i].getNroCabina() == nroCabina) {
                cabinas[i].agregarPersona(p);
                return;
            }
        }
    }
}