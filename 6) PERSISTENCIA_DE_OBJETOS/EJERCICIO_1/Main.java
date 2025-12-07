package EJERCICIO_1;
public class Main {
    public static void main(String[] args) {
        ArchivoCharango arch = new ArchivoCharango();

        boolean[] c1 = {true, true, true, true, true, true, true, true, true, true};
        boolean[] c2 = {false, false, false, false, false, false, false, true, true, true}; 
        boolean[] c3 = {true, false, true, false, true, false, true, false, true, false}; 

        arch.registrarCharango(new Charango("Madera", 10, c1));
        arch.registrarCharango(new Charango("Plastico", 10, c2));
        arch.registrarCharango(new Charango("Armadillo", 12, c3));

        System.out.println("--- Buscar 10 cuerdas ---");
        arch.buscarPorNroCuerdas(10);

        System.out.println("\n--- Eliminar cuerdas malas > 6 ---");
        arch.eliminarCharangosMalos();

        System.out.println("\n--- Listar Material Madera ---");
        arch.listarPorMaterial("Madera");

        System.out.println("\n--- Ordenar por Material ---");
        arch.ordenarPorMaterial();
    }
}