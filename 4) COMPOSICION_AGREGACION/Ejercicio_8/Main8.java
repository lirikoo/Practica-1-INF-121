import java.util.List;

public class Main8 {
    public static void main(String[] args) {
        
        // --- B) Instancia de Facultades, Encargados y Participantes ---
        
        // 1. 2 Facultades
        Facultad ing = new Facultad("Ingeniería", "Tecnológica");
        Facultad der = new Facultad("Derecho", "Social");
        
        // 2. Encargados (son Bailarines)
        Bailarin enc1 = new Bailarin("Marco Flores", 25, "1001A");
        Bailarin enc2 = new Bailarin("Laura Rojas", 22, "2002B");
        
        // 3. 2 Fraternidades con sus encargados
        Fraternidad caporales = new Fraternidad("Caporales San Simón", enc1);
        Fraternidad morenada = new Fraternidad("Morenada Central", enc2);
        
        // 4. Participantes adicionales (3)
        Bailarin b1 = new Bailarin("Ana López", 19, "3003C");
        Bailarin b2 = new Bailarin("Juan Pérez", 20, "4004D");
        Bailarin b3 = new Bailarin("ERROR Doble", 21, "1001A"); // Mismo CI que enc1 para la prueba de error
        
        // 5. Instancia del Sistema
        SistemaFraternidades sistema = new SistemaFraternidades();
        sistema.registrarFraternidad(caporales);
        sistema.registrarFraternidad(morenada);
        
        // --- C) Resuelve lo que pide el cliente ---
        
        // 1. Registro de Integrantes (Tomando datos personales, facultad y fraternidad)
        sistema.registrarNuevoIntegrate(b1, ing, caporales);
        sistema.registrarNuevoIntegrate(b2, der, morenada);
        
        // 2. Verificación de unicidad (Prueba del error)
        sistema.registrarNuevoIntegrate(b3, ing, morenada); // Debería fallar
        
        // 3. Mostrar encargados de cada fraternidad
        sistema.mostrarEncargados();
        
        // 4. Ver bailarines, a qué fraternidad y facultad pertenecen, y edades
        sistema.mostrarTodosLosBailarines();
    }
}