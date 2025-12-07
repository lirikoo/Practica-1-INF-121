public class Main {
    public static void main(String[] args) {
        MiTeleferico sis = new MiTeleferico();
        Persona p1 = new Persona("A", 30, 70);
        Persona p2 = new Persona("B", 20, 60);
        
        sis.agregarPersonaFila(p1, "Amarilla", 1);
        sis.agregarPersonaFila(p2, "Amarilla", 1);
        
        sis.verificarReglas();
        System.out.println("Total: " + sis.calcularIngresoTotal());
        sis.mostrarLineaMasIngresoRegular();
    }
}