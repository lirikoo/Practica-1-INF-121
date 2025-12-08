import com.google.gson.Gson;
import java.io.*;

public class Medico {
    private int idMedico;
    private String nombreMedico;
    private String apellidoMedico;
    private int aniosExperiencia;

    public Medico() {}

    public Medico(int idMedico, String nombreMedico, String apellidoMedico, int aniosExperiencia) {
        this.idMedico = idMedico;
        this.nombreMedico = nombreMedico;
        this.apellidoMedico = apellidoMedico;
        this.aniosExperiencia = aniosExperiencia;
    }

    public int getIdMedico() { return idMedico; }
    public String getNombreMedico() { return nombreMedico; }
    public String getApellidoMedico() { return apellidoMedico; }

    public void guardar(String rutaDir) {
        Gson gson = new Gson();
        String rutaArchivo = rutaDir + File.separator + this.idMedico + ".json";
        
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar medico: " + e.getMessage());
        }
    }

    public boolean cargar(String rutaCompleta) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(rutaCompleta)) {
            // Convertimos el JSON de vuelta a un objeto Medico
            Medico aux = gson.fromJson(reader, Medico.class);
            
            this.idMedico = aux.idMedico;
            this.nombreMedico = aux.nombreMedico;
            this.apellidoMedico = aux.apellidoMedico;
            this.aniosExperiencia = aux.aniosExperiencia;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void eliminar(String rutaDir) {
        File f = new File(rutaDir + File.separator + this.idMedico + ".json");
        if(f.exists()) {
            f.delete();
        }
    }

    @Override
    public String toString() {
        return "Medico [ID=" + idMedico + "] " + nombreMedico + " " + apellidoMedico;
    }
}