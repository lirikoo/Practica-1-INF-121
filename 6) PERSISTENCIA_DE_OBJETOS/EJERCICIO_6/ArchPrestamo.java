package EJERCICIO_6;

import java.io.*;
import java.util.ArrayList;

public class ArchPrestamo {
    private String nomArch;

    public ArchPrestamo(String nomArch) {
        this.nomArch = nomArch;
    }

    public void crear() {
        try {
            File f = new File(nomArch);
            if (f.createNewFile()) System.out.println("Archivo prestamos creado.");
        } catch (Exception e) { System.out.println("Error creando archivo prestamos."); }
    }

    public void guardar(Prestamo p) {
        try {
            ArrayList<Prestamo> lista = listar();
            lista.add(p);
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(nomArch));
            for (Prestamo pre : lista) {
                dos.writeInt(pre.getCodCliente());
                dos.writeInt(pre.getCodLibro());
                dos.writeUTF(pre.getFechaPrestamo());
                dos.writeInt(pre.getCantidad());
            }
            dos.close();
        } catch (Exception e) { System.out.println("Error guardando prestamo."); }
    }

    public ArrayList<Prestamo> listar() {
        ArrayList<Prestamo> lista = new ArrayList<>();
        try {
            File f = new File(nomArch);
            if (f.exists()) {
                DataInputStream dis = new DataInputStream(new FileInputStream(nomArch));
                while (dis.available() > 0) {
                    lista.add(new Prestamo(dis.readInt(), dis.readInt(), dis.readUTF(), dis.readInt()));
                }
                dis.close();
            }
        } catch (Exception e) { System.out.println("Error listando prestamos."); }
        return lista;
    }
}