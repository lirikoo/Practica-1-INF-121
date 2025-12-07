package EJERCICIO_3;

import java.io.*;
import java.util.ArrayList;

public class ArchivoProducto {
    private String nomA;

    public ArchivoProducto(String nomA) {
        this.nomA = nomA;
    }

    public void crearArchivo() {
        try {
            File f = new File(nomA);
            if (f.createNewFile()) {
                System.out.println("Archivo creado correctamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (Exception e) {
            System.out.println("Error al crear el archivo.");
        }
    }

    private ArrayList<Producto> listar() {
        ArrayList<Producto> lista = new ArrayList<>();
        try {
            File f = new File(nomA);
            if (f.exists()) {
                DataInputStream dis = new DataInputStream(new FileInputStream(nomA));
                while (dis.available() > 0) {
                    int cod = dis.readInt();
                    String nom = dis.readUTF();
                    float pre = dis.readFloat();
                    lista.add(new Producto(cod, nom, pre));
                }
                dis.close();
            }
        } catch (Exception e) {
            System.out.println("Error al leer.");
        }
        return lista;
    }

    private void guardarLista(ArrayList<Producto> lista) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(nomA));
            for (Producto p : lista) {
                dos.writeInt(p.getCodigo());
                dos.writeUTF(p.getNombre());
                dos.writeFloat(p.getPrecio());
            }
            dos.close();
        } catch (Exception e) {
            System.out.println("Error al guardar.");
        }
    }

    public void guardarProducto(Producto p) {
        ArrayList<Producto> lista = listar();
        lista.add(p);
        guardarLista(lista);
        System.out.println("Producto guardado: " + p.getNombre());
    }

    public Producto buscaProducto(int c) {
        ArrayList<Producto> lista = listar();
        for (Producto p : lista) {
            if (p.getCodigo() == c) {
                return p;
            }
        }
        return null;
    }

    public void calcularPromedio() {
        ArrayList<Producto> lista = listar();
        if (lista.isEmpty()) {
            System.out.println("No hay productos para promediar.");
        } else {
            float suma = 0;
            for (Producto p : lista) {
                suma = suma + p.getPrecio();
            }
            float promedio = suma / lista.size();
            System.out.println("El promedio de precios es: " + promedio);
        }
    }

    public void mostrarMasCaro() {
        ArrayList<Producto> lista = listar();
        if (lista.isEmpty()) {
            System.out.println("No hay productos.");
        } else {
            Producto mayor = lista.get(0);
            for (Producto p : lista) {
                if (p.getPrecio() > mayor.getPrecio()) {
                    mayor = p;
                }
            }
            System.out.println("El producto mas caro es: " + mayor);
        }
    }
}