package EJERCICIO_6;

import java.io.*;
import java.util.ArrayList;

public class ArchCliente {
    private String nomArch;

    public ArchCliente(String nomArch) {
        this.nomArch = nomArch;
    }

    public void crear() {
        try {
            File f = new File(nomArch);
            if (f.createNewFile()) System.out.println("Archivo clientes creado.");
        } catch (Exception e) { System.out.println("Error creando archivo clientes."); }
    }

    public void guardar(Cliente c) {
        try {
            ArrayList<Cliente> lista = listar();
            lista.add(c);
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(nomArch));
            for (Cliente cli : lista) {
                dos.writeInt(cli.getCodCliente());
                dos.writeInt(0); // CI (lo guardo como int simple si no tienes metodo getCi en tu clase original, asumiendo 0 o agregalo)
                dos.writeUTF(cli.getNombre());
                dos.writeUTF(cli.getApellido());
            }
            dos.close();
        } catch (Exception e) { System.out.println("Error guardando cliente."); }
    }

    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            File f = new File(nomArch);
            if (f.exists()) {
                DataInputStream dis = new DataInputStream(new FileInputStream(nomArch));
                while (dis.available() > 0) {
                    // Nota: ajusta si agregaste getCi en Cliente.java, aqui puse lectura simple
                    int cod = dis.readInt();
                    int ci = dis.readInt(); 
                    String nom = dis.readUTF();
                    String ape = dis.readUTF();
                    lista.add(new Cliente(cod, ci, nom, ape));
                }
                dis.close();
            }
        } catch (Exception e) { System.out.println("Error listando clientes."); }
        return lista;
    }
}