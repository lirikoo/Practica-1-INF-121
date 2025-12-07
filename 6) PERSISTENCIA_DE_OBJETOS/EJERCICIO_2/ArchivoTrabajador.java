package EJERCICIO_2;

import java.io.*;
import java.util.ArrayList;

public class ArchivoTrabajador {
    private String nombreArch = "trabajadores.dat";

    public ArchivoTrabajador() {
        
    }

    public void crearArchivo() {
        try {
            File f = new File(nombreArch);
            if (f.createNewFile()) {
                System.out.println("Archivo creado.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (Exception e) {
            System.out.println("Error al crear archivo.");
        }
    }

    private void guardarLista(ArrayList<Trabajador> lista) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(nombreArch));
            for (Trabajador t : lista) {
                dos.writeUTF(t.getNombre());
                dos.writeInt(t.getCarnet());
                dos.writeDouble(t.getSalario());
            }
            dos.close();
        } catch (Exception e) {
            System.out.println("Error al guardar lista.");
        }
    }

    private ArrayList<Trabajador> obtenerLista() {
        ArrayList<Trabajador> lista = new ArrayList<>();
        try {
            File f = new File(nombreArch);
            if (f.exists()) {
                DataInputStream dis = new DataInputStream(new FileInputStream(nombreArch));
                while (dis.available() > 0) {
                    String nom = dis.readUTF();
                    int ci = dis.readInt();
                    double sal = dis.readDouble();
                    lista.add(new Trabajador(nom, ci, sal));
                }
                dis.close();
            }
        } catch (Exception e) {
            System.out.println("Error al leer lista.");
        }
        return lista;
    }

    public void guardarTrabajador(Trabajador t) {
        ArrayList<Trabajador> lista = obtenerLista();
        lista.add(t);
        guardarLista(lista);
    }

    public void aumentarSalario(int monto, Trabajador t) {
        ArrayList<Trabajador> lista = obtenerLista();
        boolean encontrado = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCarnet() == t.getCarnet()) {
                double nuevoSalario = lista.get(i).getSalario() + monto;
                lista.get(i).setSalario(nuevoSalario);
                encontrado = true;
                System.out.println("Salario aumentado a " + lista.get(i).getNombre());
            }
        }
        if (encontrado) {
            guardarLista(lista);
        }
    }

    public void buscarMayorSalario() {
        ArrayList<Trabajador> lista = obtenerLista();
        if (lista.isEmpty()) {
            System.out.println("No hay trabajadores.");
        } else {
            Trabajador mayor = lista.get(0);
            for (Trabajador t : lista) {
                if (t.getSalario() > mayor.getSalario()) {
                    mayor = t;
                }
            }
            System.out.println("El trabajador con mayor salario es: " + mayor);
        }
    }

    public void ordenarPorSalario() {
        ArrayList<Trabajador> lista = obtenerLista();
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).getSalario() > lista.get(j).getSalario()) { 
                    Trabajador temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                }
            }
        }
        guardarLista(lista);
        System.out.println("Trabajadores ordenados por salario (ascendente):");
        for (Trabajador t : lista) {
            System.out.println(t);
        }
    }
    
    public void listarTodos() {
        ArrayList<Trabajador> lista = obtenerLista();
        for(Trabajador t : lista) {
            System.out.println(t);
        }
    }
}