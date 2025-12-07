package EJERCICIO_8;

import java.io.*;
import java.util.ArrayList;

public class ArchRefri {
    private String nombre;

    public ArchRefri(String nombre) {
        this.nombre = nombre;
    }

    public void crear() {
        try {
            File f = new File(nombre);
            if (f.createNewFile()) {
                System.out.println("Archivo refrigerador creado.");
            }
        } catch (Exception e) {
            System.out.println("Error al crear.");
        }
    }

    private ArrayList<Alimento> listar() {
        ArrayList<Alimento> lista = new ArrayList<>();
        try {
            File f = new File(nombre);
            if (f.exists()) {
                DataInputStream dis = new DataInputStream(new FileInputStream(nombre));
                while (dis.available() > 0) {
                    String nom = dis.readUTF();
                    String fecha = dis.readUTF();
                    int cant = dis.readInt();
                    lista.add(new Alimento(nom, fecha, cant));
                }
                dis.close();
            }
        } catch (Exception e) {
            System.out.println("Error al leer.");
        }
        return lista;
    }

    private void guardarLista(ArrayList<Alimento> lista) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(nombre));
            for (Alimento a : lista) {
                dos.writeUTF(a.getNombre());
                dos.writeUTF(a.getFechaVencimiento());
                dos.writeInt(a.getCantidad());
            }
            dos.close();
        } catch (Exception e) {
            System.out.println("Error al guardar.");
        }
    }

    // a) Crear (Adicionar), Modificar y Eliminar
    public void adicionar(Alimento a) {
        ArrayList<Alimento> lista = listar();
        lista.add(a);
        guardarLista(lista);
    }

    public void modificarNombre(String nomAntiguo, String nomNuevo) {
        ArrayList<Alimento> lista = listar();
        boolean modificado = false;
        for (Alimento a : lista) {
            if (a.getNombre().equalsIgnoreCase(nomAntiguo)) {
                a.setNombre(nomNuevo);
                modificado = true;
            }
        }
        if (modificado) {
            guardarLista(lista);
            System.out.println("Se modifico el nombre de " + nomAntiguo + " a " + nomNuevo);
        } else {
            System.out.println("No se encontro el alimento " + nomAntiguo);
        }
    }

    public void eliminarPorNombre(String nom) {
        ArrayList<Alimento> lista = listar();
        ArrayList<Alimento> nuevaLista = new ArrayList<>();
        boolean eliminado = false;
        
        for (Alimento a : lista) {
            if (!a.getNombre().equalsIgnoreCase(nom)) {
                nuevaLista.add(a);
            } else {
                eliminado = true;
            }
        }
        
        if (eliminado) {
            guardarLista(nuevaLista);
            System.out.println("Alimento eliminado: " + nom);
        } else {
            System.out.println("No se encontro para eliminar: " + nom);
        }
    }

    // b) Caducaron antes de fecha X
    public void mostrarCaducadosAntesDe(String fechaX) {
        ArrayList<Alimento> lista = listar();
        System.out.println("Alimentos que vencen antes de " + fechaX + ":");
        for (Alimento a : lista) {
            // Comparamos cadenas (Funciona si el formato es AAAA-MM-DD)
            if (a.getFechaVencimiento().compareTo(fechaX) < 0) {
                System.out.println(a);
            }
        }
    }

    // c) Eliminar cantidad 0
    public void eliminarVacios() {
        ArrayList<Alimento> lista = listar();
        ArrayList<Alimento> nuevaLista = new ArrayList<>();
        int cont = 0;

        for (Alimento a : lista) {
            if (a.getCantidad() > 0) {
                nuevaLista.add(a);
            } else {
                cont++;
            }
        }

        if (cont > 0) {
            guardarLista(nuevaLista);
            System.out.println("Se eliminaron " + cont + " alimentos con cantidad 0.");
        }
    }

    // d) Buscar ya vencidos (Necesitamos saber la fecha de "hoy")
    public void buscarVencidos(String fechaActual) {
        ArrayList<Alimento> lista = listar();
        System.out.println("Alimentos ya vencidos al dia de hoy (" + fechaActual + "):");
        for (Alimento a : lista) {
            if (a.getFechaVencimiento().compareTo(fechaActual) < 0) {
                System.out.println(a);
            }
        }
    }

    // e) Alimento con mas cantidad
    public void mostrarMasCantidad() {
        ArrayList<Alimento> lista = listar();
        if (lista.isEmpty()) {
            System.out.println("Refrigerador vacio.");
        } else {
            Alimento mayor = lista.get(0);
            for (Alimento a : lista) {
                if (a.getCantidad() > mayor.getCantidad()) {
                    mayor = a;
                }
            }
            System.out.println("El alimento con mas cantidad es: " + mayor);
        }
    }

    public void listarTodo() {
        ArrayList<Alimento> lista = listar();
        for(Alimento a : lista) System.out.println(a);
    }
}