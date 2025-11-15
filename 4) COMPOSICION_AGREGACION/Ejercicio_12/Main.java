public class Main {
    public static void main12(String[] args) {
        
        // 1. Crear Doctores (Objetos independientes)
        Doctor d1 = new Doctor("Dr. Pérez", "Cardiología");
        Doctor d2 = new Doctor("Dra. Soto", "Pediatría");
        Doctor d3 = new Doctor("Dr. López", "Cirugía");
        
        // 2. Crear Hospitales (Objetos contenedores)
        Hospital h1 = new Hospital("Hospital Central");
        Hospital h2 = new Hospital("Clínica del Sur");
        
        // 3. Asignación (Un doctor puede estar en varios hospitales)
        
        // Asignación a Hospital Central (h1)
        h1.asignarDoctor(d1); // Dr. Pérez
        h1.asignarDoctor(d2); // Dra. Soto
        
        // Asignación a Clínica del Sur (h2)
        h2.asignarDoctor(d2); // Dra. Soto también trabaja aquí (Agregación)
        h2.asignarDoctor(d3); // Dr. López
        
        // 4. Mostrar los doctores de cada hospital
        h1.mostrarDoctores();
        h2.mostrarDoctores();
        
        // Verificación de Agregación:
        System.out.println("\n--- Prueba de Agregación ---");
        System.out.println("La Dra. Soto trabaja en Hospital Central (h1) y Clínica del Sur (h2).");
    }
}