package EJERCICIO_4;

import java.io.*;
import java.util.ArrayList;

public class ArchiNota {
    private String nombreArchi;

    public ArchiNota(String nombreArchi) {
        this.nombreArchi = nombreArchi;
    }

    public void crearArchivo() {
        try {
            File f = new File(nombreArchi);
            if (f.createNewFile()) {
                System.out.println("Archivo de notas creado.");
            }
        } catch (Exception e) {
            System.out.println("Error creando archivo.");
        }
    }

    private ArrayList<Nota> listar() {
        ArrayList<Nota> lista = new ArrayList<>();
        try {
            File f = new File(nombreArchi);
            if (f.exists()) {
                DataInputStream dis = new DataInputStream(new FileInputStream(nombreArchi));
                while (dis.available() > 0) {
                    String mat = dis.readUTF();
                    double nf = dis.readDouble();
                    
                    int ru = dis.readInt();
                    String nom = dis.readUTF();
                    String pat = dis.readUTF();
                    String matN = dis.readUTF(); 
                    int edad = dis.readInt();

                    Estudiante est = new Estudiante(ru, nom, pat, matN, edad);
                    lista.add(new Nota(mat, nf, est));
                }
                dis.close();
            }
        } catch (Exception e) {
            System.out.println("Error al leer notas.");
        }
        return lista;
    }

    private void guardarLista(ArrayList<Nota> lista) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(nombreArchi));
            for (Nota n : lista) {
                dos.writeUTF(n.getMateria());
                dos.writeDouble(n.getNotaFinal());
                
                Estudiante e = n.getEstudiante();
                dos.writeInt(e.getRu());
                dos.writeUTF(e.getNombre());
                dos.writeUTF(e.getPaterno());
                dos.writeUTF(e.getMaterno());
                dos.writeInt(e.getEdad());
            }
            dos.close();
        } catch (Exception e) {
            System.out.println("Error al guardar.");
        }
    }

    public void agregarNota(Nota n) {
        ArrayList<Nota> lista = listar();
        lista.add(n);
        guardarLista(lista);
    }

    public void agregarVariosEstudiantes(ArrayList<Nota> nuevasNotas) {
        ArrayList<Nota> lista = listar();
        lista.addAll(nuevasNotas);
        guardarLista(lista);
        System.out.println("Se agregaron " + nuevasNotas.size() + " registros.");
    }

    public void promedioNotas() {
        ArrayList<Nota> lista = listar();
        if (lista.isEmpty()) {
            System.out.println("No hay notas registradas.");
        } else {
            double suma = 0;
            for (Nota n : lista) {
                suma = suma + n.getNotaFinal();
            }
            System.out.println("Promedio general de notas: " + (suma / lista.size()));
        }
    }

    public void buscarMejorNota() {
        ArrayList<Nota> lista = listar();
        if (lista.isEmpty()) {
            System.out.println("No hay notas.");
        } else {
            double max = -1;
            for (Nota n : lista) {
                if (n.getNotaFinal() > max) {
                    max = n.getNotaFinal();
                }
            }
            System.out.println("Estudiantes con la mejor nota (" + max + "):");
            for (Nota n : lista) {
                if (n.getNotaFinal() == max) {
                    System.out.println(n.getEstudiante());
                }
            }
        }
    }

    public void eliminarPorMateria(String materiaX) {
        ArrayList<Nota> lista = listar();
        ArrayList<Nota> nuevaLista = new ArrayList<>();
        boolean eliminado = false;

        for (Nota n : lista) {
            if (!n.getMateria().equalsIgnoreCase(materiaX)) {
                nuevaLista.add(n);
            } else {
                eliminado = true;
            }
        }

        if (eliminado) {
            guardarLista(nuevaLista);
            System.out.println("Se eliminaron los registros de la materia: " + materiaX);
        } else {
            System.out.println("No se encontro esa materia.");
        }
    }
    
    public void mostrarTodo() {
        ArrayList<Nota> lista = listar();
        for(Nota n : lista) {
            System.out.println(n);
        }
    }
}