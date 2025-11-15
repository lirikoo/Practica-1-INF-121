import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nombre;
    // Agregación: El Hospital tiene una lista de Doctores
    private List<Doctor> doctores; 

    public Hospital(String nombre) {
        this.nombre = nombre;
        this.doctores = new ArrayList<>();
    }

    // c) Método para asignar/agregar doctores al hospital
    public void asignarDoctor(Doctor doctor) {
        // La Agregación se implementa pasando el objeto 'Doctor' ya existente.
        this.doctores.add(doctor); 
        System.out.println("✅ " + doctor.getNombre() + " ha sido asignado al hospital " + this.nombre);
    }

    // c) Método para mostrar los doctores del hospital
    public void mostrarDoctores() {
        System.out.println("\n*** Doctores Asignados a: " + nombre + " ***");
        if (doctores.isEmpty()) {
            System.out.println("No hay doctores asignados a este hospital.");
        } else {
            for (Doctor d : doctores) {
                d.mostrarInfo();
            }
        }
        System.out.println("------------------------------------------");
    }
}