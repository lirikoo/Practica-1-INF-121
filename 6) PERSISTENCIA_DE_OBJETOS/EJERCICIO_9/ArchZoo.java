package EJERCICIO_9;

import java.io.*;
import java.util.ArrayList;

public class ArchZoo {
    private String nombre;

    public ArchZoo(String nombre) {
        this.nombre = nombre;
    }

    public void crear() {
        try {
            File f = new File(nombre);
            if (f.createNewFile()) {
                System.out.println("Archivo Zoo creado.");
            }
        } catch (Exception e) {
            System.out.println("Error creando archivo.");
        }
    }

    private ArrayList<Zoologico> listar() {
        ArrayList<Zoologico> lista = new ArrayList<>();
        try {
            File f = new File(nombre);
            if (f.exists()) {
                DataInputStream dis = new DataInputStream(new FileInputStream(nombre));
                while (dis.available() > 0) {
                    int id = dis.readInt();
                    String nomZ = dis.readUTF();
                    int nro = dis.readInt();
                    
                    Zoologico z = new Zoologico(id, nomZ);
                    for (int i = 0; i < nro; i++) {
                        String esp = dis.readUTF();
                        String nomA = dis.readUTF();
                        int cant = dis.readInt();
                        z.agregarAnimal(new Animal(esp, nomA, cant));
                    }
                    lista.add(z);
                }
                dis.close();
            }
        } catch (Exception e) {
            System.out.println("Error al leer.");
        }
        return lista;
    }

    private void guardarLista(ArrayList<Zoologico> lista) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(nombre));
            for (Zoologico z : lista) {
                dos.writeInt(z.getId());
                dos.writeUTF(z.getNombre());
                dos.writeInt(z.getNroAnimales());
                
                Animal[] ans = z.getAnimales();
                for (int i = 0; i < z.getNroAnimales(); i++) {
                    dos.writeUTF(ans[i].getEspecie());
                    dos.writeUTF(ans[i].getNombre());
                    dos.writeInt(ans[i].getCantidad());
                }
            }
            dos.close();
        } catch (Exception e) {
            System.out.println("Error al guardar.");
        }
    }

    // a) Crear, Modificar, Eliminar
    public void adicionar(Zoologico z) {
        ArrayList<Zoologico> lista = listar();
        lista.add(z);
        guardarLista(lista);
    }

    public void modificarNombre(int id, String nuevoNombre) {
        ArrayList<Zoologico> lista = listar();
        for (Zoologico z : lista) {
            if (z.getId() == id) {
                z.setNombre(nuevoNombre);
            }
        }
        guardarLista(lista);
    }

    public void eliminarZoo(int id) {
        ArrayList<Zoologico> lista = listar();
        ArrayList<Zoologico> nuevaLista = new ArrayList<>();
        for (Zoologico z : lista) {
            if (z.getId() != id) {
                nuevaLista.add(z);
            }
        }
        guardarLista(nuevaLista);
        System.out.println("Zoo eliminado si existia.");
    }

    // b) Mayor cantidad variedad de animales (El que tiene mas tipos distintos)
    public void mostrarMayorVariedad() {
        ArrayList<Zoologico> lista = listar();
        if (lista.isEmpty()) return;

        int max = -1;
        for (Zoologico z : lista) {
            if (z.getNroAnimales() > max) {
                max = z.getNroAnimales();
            }
        }
        
        System.out.println("Zoologicos con mas variedad (" + max + "):");
        for (Zoologico z : lista) {
            if (z.getNroAnimales() == max) {
                System.out.println(z);
            }
        }
    }

    // c) Listar vacios y eliminarlos
    public void eliminarVacios() {
        ArrayList<Zoologico> lista = listar();
        ArrayList<Zoologico> nuevaLista = new ArrayList<>();
        boolean huboVacios = false;

        System.out.println("Zoologicos vacios encontrados:");
        for (Zoologico z : lista) {
            if (z.getNroAnimales() == 0) {
                System.out.println(z);
                huboVacios = true;
            } else {
                nuevaLista.add(z);
            }
        }

        if (huboVacios) {
            guardarLista(nuevaLista);
            System.out.println("Se eliminaron los zoologicos vacios.");
        } else {
            System.out.println("No habia vacios.");
        }
    }

    // d) Mostrar animales de especie X
    public void mostrarPorEspecie(String esp) {
        ArrayList<Zoologico> lista = listar();
        System.out.println("Buscando especie: " + esp);
        for (Zoologico z : lista) {
            Animal[] ans = z.getAnimales();
            for (int i = 0; i < z.getNroAnimales(); i++) {
                if (ans[i].getEspecie().equalsIgnoreCase(esp)) {
                    System.out.println("En Zoo " + z.getNombre() + ": " + ans[i]);
                }
            }
        }
    }

    // e) Mover animales de zoo X a zoo Y
    public void moverAnimales(int idOrigen, int idDestino) {
        ArrayList<Zoologico> lista = listar();
        Zoologico origen = null;
        Zoologico destino = null;

        for (Zoologico z : lista) {
            if (z.getId() == idOrigen) origen = z;
            if (z.getId() == idDestino) destino = z;
        }

        if (origen != null && destino != null) {
            Animal[] ansOrigen = origen.getAnimales();
            for (int i = 0; i < origen.getNroAnimales(); i++) {
                destino.agregarAnimal(ansOrigen[i]);
            }
            origen.vaciar(); // El origen queda vacio
            
            guardarLista(lista);
            System.out.println("Se movieron los animales del Zoo " + idOrigen + " al Zoo " + idDestino);
        } else {
            System.out.println("No se encontraron los IDs.");
        }
    }
    
    public void mostrarTodo() {
        ArrayList<Zoologico> lista = listar();
        for (Zoologico z : lista) {
            System.out.println(z);
            Animal[] a = z.getAnimales();
            for(int i=0; i<z.getNroAnimales(); i++) {
                System.out.println("   " + a[i]);
            }
        }
    }
}