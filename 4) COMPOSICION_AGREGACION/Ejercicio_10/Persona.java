// Clase Base: Persona
public class Persona {
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String ci;

    public Persona(String nombre, String apellido, int edad, String ci) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ci = ci;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public String getCi() { return ci; }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}

// Clase Hija: Participante (Hereda de Persona)
public class Participante extends Persona {
    private int nroTicket;

    public Participante(String nombre, String apellido, int edad, String ci, int nroTicket) {
        super(nombre, apellido, edad, ci);
        this.nroTicket = nroTicket;
    }
}

// Clase Hija: Speaker (Hereda de Persona)
public class Speaker extends Persona {
    private String especialidad;

    public Speaker(String nombre, String apellido, int edad, String ci, String especialidad) {
        super(nombre, apellido, edad, ci);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { return especialidad; }
}