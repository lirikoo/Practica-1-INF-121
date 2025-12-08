import java.io.File;
import java.util.ArrayList;

public class Consultorio {
    private String rutaConsultas;
    private String rutaMedicos;
    
    public Consultorio(String rutaConsultas, String rutaMedicos) {
        this.rutaConsultas = rutaConsultas;
        this.rutaMedicos = rutaMedicos;
    }

    public void agregarMedico(Medico m){
        m.guardar(this.rutaMedicos);
    }

    public void agregarConsulta(Consulta c){
        c.guardar(this.rutaConsultas);
    }

    public void mostrarMedicos(){
        System.out.println("--- LISTA DE MEDICOS (desde JSON) ---");
        ArrayList<Medico> lista = cargarMedicos();
        for(Medico m: lista){
            System.out.println(m);
        }
    }

    public void mostrarConsultas(){
        System.out.println("--- LISTA DE CONSULTAS (desde JSON) ---");
        ArrayList<Consulta> lista = cargarConsultas();
        for(Consulta c: lista){
            System.out.println(c);
        }
    }

    // Lee la carpeta y convierte todos los .json a objetos Medico
    public ArrayList<Medico> cargarMedicos(){
        ArrayList<Medico> lista = new ArrayList<>();
        File carpeta = new File(this.rutaMedicos);
        File[] archivos = carpeta.listFiles();
        
        if(archivos != null){
            for(File f: archivos){
                if(f.isFile() && f.getName().endsWith(".json")){
                    Medico nuevo = new Medico();
                    if(nuevo.cargar(f.getPath())){
                        lista.add(nuevo);
                    }
                }
            }
        }
        return lista;
    }

    public ArrayList<Consulta> cargarConsultas(){
        ArrayList<Consulta> lista = new ArrayList<>();
        File carpeta = new File(this.rutaConsultas);
        File[] archivos = carpeta.listFiles();
        
        if(archivos != null){
            for(File f: archivos){
                if(f.isFile() && f.getName().endsWith(".json")){
                    Consulta nuevo = new Consulta();
                    if(nuevo.cargar(f.getPath())){
                        lista.add(nuevo);
                    }
                }
            }
        }
        return lista;
    }
    
    public void bajaMedicoYConsultas(String nombreX, String apellidoY){
        ArrayList<Medico> lista = this.cargarMedicos();
        int idMedicoBorrar = -1;
        
        for(Medico m: lista){
            if(m.getNombreMedico().equalsIgnoreCase(nombreX) && m.getApellidoMedico().equalsIgnoreCase(apellidoY)){
                idMedicoBorrar = m.getIdMedico();
                m.eliminar(this.rutaMedicos); // Borra el archivo .json
                System.out.println(">> Eliminando Medico: " + nombreX + " " + apellidoY);
                break;
            }
        }
        
        if(idMedicoBorrar != -1){
            ArrayList<Consulta> listaConsultas = this.cargarConsultas();
            for(Consulta c: listaConsultas){
                if(c.getIdMedico() == idMedicoBorrar){
                    c.eliminar(this.rutaConsultas); // Borra el archivo .json
                }
            }
            System.out.println(">> Consultas asociadas eliminadas.");
        } else {
            System.out.println(">> No se encontró al médico solicitado.");
        }
    }

    public void cambiarFechasFestivas() {
        ArrayList<Consulta> lista = cargarConsultas();
        boolean huboCambios = false;

        for (Consulta c : lista) {
            boolean esNavidad = (c.getDia() == 25 && c.getMes().equalsIgnoreCase("diciembre"));
            boolean esAnioNuevo = (c.getDia() == 1 && c.getMes().equalsIgnoreCase("enero"));

            if (esNavidad || esAnioNuevo) {
                System.out.println(">> Reprogramando cita de: " + c.getNombrePaciente());
                c.setDia(2);
                c.setMes("febrero");
                
                c.guardar(this.rutaConsultas); 
                huboCambios = true;
            }
        }
        if(!huboCambios) System.out.println("No había citas en fechas festivas.");
    }
}