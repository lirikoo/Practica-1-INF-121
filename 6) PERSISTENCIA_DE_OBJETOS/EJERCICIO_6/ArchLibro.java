package EJERCICIO_6;

import java.io.*;
import java.util.ArrayList;

public class ArchLibro {
    private String nomArch;

    public ArchLibro(String nomArch) {
        this.nomArch = nomArch;
    }

    public void crear() {
        try {
            File f = new File(nomArch);
            if (f.createNewFile()) System.out.println("Archivo libros creado.");
        } catch (Exception e) { System.out.println("Error creando archivo libros."); }
    }

    public void guardar(Libro l) {
        try {
            ArrayList<Libro> lista = listar();
            lista.add(l);
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(nomArch));
            for (Libro lib : lista) {
                dos.writeInt(lib.getCodLibro());
                dos.writeUTF(lib.getTitulo());
                dos.writeDouble(lib.getPrecio());
            }
            dos.close();
        } catch (Exception e) { System.out.println("Error guardando libro."); }
    }

    public ArrayList<Libro> listar() {
        ArrayList<Libro> lista = new ArrayList<>();
        try {
            File f = new File(nomArch);
            if (f.exists()) {
                DataInputStream dis = new DataInputStream(new FileInputStream(nomArch));
                while (dis.available() > 0) {
                    lista.add(new Libro(dis.readInt(), dis.readUTF(), dis.readDouble()));
                }
                dis.close();
            }
        } catch (Exception e) { System.out.println("Error listando libros."); }
        return lista;
    }

    // Inciso a) Listar libros entre precios
    public void listarEntrePrecios(double x, double y) {
        ArrayList<Libro> lista = listar();
        System.out.println("Libros con precio entre " + x + " y " + y + ":");
        for (Libro l : lista) {
            if (l.getPrecio() >= x && l.getPrecio() <= y) {
                System.out.println(l);
            }
        }
    }
}