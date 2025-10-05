public class Principal5 {
    public static void main(String[] args) {

        Celular celular = new Celular("555-1234", "Estudiante", 100.0f, 8, 5);

        System.out.println("---  Estado Inicial ---");
        System.out.println(celular);

        System.out.println("\n---  Aplicando Operador ++ (Apps + 10) ---");
        celular.aumentarNroApp();
        System.out.println(celular);

        System.out.println("\n--- Aplicando Operador -- (Espacio - 5 GB) ---");
        celular.disminuirEspacio();
        System.out.println(celular);
    }
}