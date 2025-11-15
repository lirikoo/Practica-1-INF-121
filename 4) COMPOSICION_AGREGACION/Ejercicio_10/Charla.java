import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Charla {
    private String lugar;
    private String nombreCharla;
    private int np; // Número actual de participantes
    private Speaker speaker; // S
    private List<Participante> participantes; // P[50]

    public Charla(String lugar, String nombreCharla, Speaker speaker) {
        this.lugar = lugar;
        this.nombreCharla = nombreCharla;
        this.speaker = speaker;
        this.participantes = new ArrayList<>();
        this.np = 0;
    }
    
    // Método para agregar un participante
    public void agregarParticipante(Participante p) {
        if (participantes.size() < 50) {
            this.participantes.add(p);
            this.np = participantes.size();
        } else {
            System.out.println("Max. capacidad de participantes alcanzada para: " + nombreCharla);
        }
    }

    // Getters necesarios para las operaciones
    public String getNombreCharla() { return nombreCharla; }
    public Speaker getSpeaker() { return speaker; }
    public List<Participante> getParticipantes() { return participantes; }
    public int getNp() { return np; }
}

public class Evento {
    private String nombre;
    private int nc; // Número actual de charlas
    private List<Charla> charlas; // C[50]

    public Evento(String nombre) {
        this.nombre = nombre;
        this.charlas = new ArrayList<>();
        this.nc = 0;
    }

    public void agregarCharla(Charla c) {
        if (charlas.size() < 50) {
            this.charlas.add(c);
            this.nc = charlas.size();
        }
    }
    
    public List<Charla> getCharlas() { return charlas; }
}