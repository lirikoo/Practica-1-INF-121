import com.google.gson.Gson;
import java.io.*;

public class Consulta {
    private int ci;
    private String nombrePaciente;
    private String apellidoPaciente;
    private int idMedico;
    private int dia;
    private String mes;
    private int anio;
    
    public Consulta() {} 

    public Consulta(int ci, String nombrePaciente, String apellidoPaciente, int idMedico, int dia, String mes, int anio) {
        this.ci = ci;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.idMedico = idMedico;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    public int getIdMedico() { return idMedico; }
    public int getDia() { return dia; }
    public void setDia(int dia) { this.dia = dia; }
    public String getMes() { return mes; }
    public void setMes(String mes) { this.mes = mes; }
    public String getNombrePaciente() { return nombrePaciente; }


    public void guardar(String rutaDir) {
        Gson gson = new Gson();
        String nombreArchivo = this.ci + "_" + this.idMedico + ".json";
        String rutaCompleta = rutaDir + File.separator + nombreArchivo;

        try (FileWriter writer = new FileWriter(rutaCompleta)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar consulta: " + e.getMessage());
        }
    }

    public boolean cargar(String rutaCompleta) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(rutaCompleta)) {
            Consulta aux = gson.fromJson(reader, Consulta.class);
            
            this.ci = aux.ci;
            this.nombrePaciente = aux.nombrePaciente;
            this.apellidoPaciente = aux.apellidoPaciente;
            this.idMedico = aux.idMedico;
            this.dia = aux.dia;
            this.mes = aux.mes;
            this.anio = aux.anio;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void eliminar(String rutaDir) {
        String nombreArchivo = this.ci + "_" + this.idMedico + ".json";
        File f = new File(rutaDir + File.separator + nombreArchivo);
        if(f.exists()) {
            f.delete();
        }
    }

    @Override
    public String toString() {
        return "Consulta: " + nombrePaciente + " " + apellidoPaciente + " (Con Medico ID: " + idMedico + ") Fecha: " + dia + "/" + mes;
    }
}