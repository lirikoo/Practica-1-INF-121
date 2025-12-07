package EJERCICIO_1;
import java.io.*;

import java.util.ArrayList;

public class ArchivoCharango {
    private String nombreArchivo = "charangos.dat";

    public void guardarLista(ArrayList<Charango> lista) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(nombreArchivo));
            for (Charango c : lista) {
                dos.writeUTF(c.getMaterial());
                dos.writeInt(c.getNroCuerdas());
                boolean[] cuerdas = c.getCuerdas();
                for (int i = 0; i < 10; i++) {
                    dos.writeBoolean(cuerdas[i]);
                }
            }
            dos.close();
        } catch (Exception e) {
            System.out.println("Error al guardar");
        }
    }

    public ArrayList<Charango> obtenerLista() {
        ArrayList<Charango> lista = new ArrayList<>();
        try {
            File f = new File(nombreArchivo);
            if (f.exists()) {
                DataInputStream dis = new DataInputStream(new FileInputStream(nombreArchivo));
                while (dis.available() > 0) {
                    String mat = dis.readUTF();
                    int nro = dis.readInt();
                    boolean[] cuerdas = new boolean[10];
                    for (int i = 0; i < 10; i++) {
                        cuerdas[i] = dis.readBoolean();
                    }
                    lista.add(new Charango(mat, nro, cuerdas));
                }
                dis.close();
            }
        } catch (Exception e) {
            System.out.println("Error al leer");
        }
        return lista;
    }

    public void registrarCharango(Charango c) {
        ArrayList<Charango> lista = obtenerLista();
        lista.add(c);
        guardarLista(lista);
    }

    public void eliminarCharangosMalos() {
        ArrayList<Charango> lista = obtenerLista();
        ArrayList<Charango> nuevaLista = new ArrayList<>();
        
        for (Charango c : lista) {
            int contFalse = 0;
            boolean[] cuerdas = c.getCuerdas();
            for (boolean b : cuerdas) {
                if (!b) {
                    contFalse++;
                }
            }
            if (contFalse <= 6) {
                nuevaLista.add(c);
            }
        }
        guardarLista(nuevaLista);
        System.out.println("Se eliminaron los charangos con mas de 6 cuerdas malas.");
    }

    public void listarPorMaterial(String materialX) {
        ArrayList<Charango> lista = obtenerLista();
        System.out.println("Listando charangos de material: " + materialX);
        for (Charango c : lista) {
            if (c.getMaterial().equalsIgnoreCase(materialX)) {
                System.out.println(c);
            }
        }
    }

    public void buscarPorNroCuerdas(int n) {
        ArrayList<Charango> lista = obtenerLista();
        System.out.println("Buscando charangos con " + n + " cuerdas:");
        for (Charango c : lista) {
            if (c.getNroCuerdas() == n) {
                System.out.println(c);
            }
        }
    }

    public void ordenarPorMaterial() {
        ArrayList<Charango> lista = obtenerLista();
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).getMaterial().compareToIgnoreCase(lista.get(j).getMaterial()) > 0) {
                    Charango temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                }
            }
        }
        guardarLista(lista);
        System.out.println("Charangos ordenados por material.");
        for (Charango c : lista) {
            System.out.println(c);
        }
    }
}