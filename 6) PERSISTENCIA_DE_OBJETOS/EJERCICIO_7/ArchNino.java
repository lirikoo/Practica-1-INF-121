package EJERCICIO_7;

import java.io.*;
import java.util.ArrayList;

public class ArchNino {
    private String na;

    public ArchNino(String na) {
        this.na = na;
    }

    public void crear() {
        try {
            File f = new File(na);
            if (f.createNewFile()) {
                System.out.println("Archivo creado.");
            }
        } catch (Exception e) {
            System.out.println("Error al crear.");
        }
    }

    public void adicionar(Nino n) {
        try {
            ArrayList<Nino> lista = listar();
            lista.add(n);
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(na));
            for (Nino nin : lista) {
                // Datos de Persona
                dos.writeUTF(nin.getNombre());
                dos.writeUTF(nin.getPaterno());
                dos.writeUTF(nin.getMaterno());
                dos.writeInt(nin.getCi());
                // Datos de Nino
                dos.writeInt(nin.getEdad());
                dos.writeDouble(nin.getPeso());
                dos.writeDouble(nin.getTalla());
            }
            dos.close();
        } catch (Exception e) {
            System.out.println("Error al guardar.");
        }
    }

    public ArrayList<Nino> listar() {
        ArrayList<Nino> lista = new ArrayList<>();
        try {
            File f = new File(na);
            if (f.exists()) {
                DataInputStream dis = new DataInputStream(new FileInputStream(na));
                while (dis.available() > 0) {
                    String nom = dis.readUTF();
                    String pat = dis.readUTF();
                    String mat = dis.readUTF();
                    int ci = dis.readInt();
                    int edad = dis.readInt();
                    double peso = dis.readDouble();
                    double talla = dis.readDouble();
                    lista.add(new Nino(nom, pat, mat, ci, edad, peso, talla));
                }
                dis.close();
            }
        } catch (Exception e) {
            System.out.println("Error al leer.");
        }
        return lista;
    }

    // Inciso b) Ninos con peso adecuado
    // Usaremos una regla simple: Peso ideal aproximado = (Edad * 2) + 8
    public void contarPesoAdecuado() {
        ArrayList<Nino> lista = listar();
        int cont = 0;
        for (Nino n : lista) {
            double pesoIdeal = (n.getEdad() * 2) + 8;
            // Si el peso esta en un rango de +/- 3kg del ideal
            if (n.getPeso() >= pesoIdeal - 3 && n.getPeso() <= pesoIdeal + 3) {
                cont++;
            }
        }
        System.out.println("Cantidad de ninos con peso adecuado: " + cont);
    }

    // Inciso c) Ninos SIN peso o talla adecuada
    public void mostrarInadecuados() {
        ArrayList<Nino> lista = listar();
        System.out.println("Ninos con peso/talla inadecuada:");
        for (Nino n : lista) {
            double pesoIdeal = (n.getEdad() * 2) + 8;
            double tallaIdeal = (n.getEdad() * 6) + 77; 
            
            boolean pesoMal = (n.getPeso() < pesoIdeal - 3 || n.getPeso() > pesoIdeal + 3);
            boolean tallaMal = (n.getTalla() < tallaIdeal - 10 || n.getTalla() > tallaIdeal + 10);

            if (pesoMal || tallaMal) {
                System.out.println(n);
            }
        }
    }

    // Inciso d) Promedio de edad
    public void promedioEdad() {
        ArrayList<Nino> lista = listar();
        if (lista.isEmpty()) {
            System.out.println("No hay ninos.");
        } else {
            double suma = 0;
            for (Nino n : lista) {
                suma += n.getEdad();
            }
            System.out.println("El promedio de edad es: " + (suma / lista.size()));
        }
    }

    // Inciso e) Buscar por carnet
    public void buscarPorCarnet(int x) {
        ArrayList<Nino> lista = listar();
        boolean encontrado = false;
        for (Nino n : lista) {
            if (n.getCi() == x) {
                System.out.println("Encontrado: " + n);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No existe el carnet " + x);
    }

    // Inciso f) Talla mas alta
    public void mostrarMasAltos() {
        ArrayList<Nino> lista = listar();
        if (lista.isEmpty()) {
            System.out.println("Lista vacia.");
        } else {
            double max = -1;
            for (Nino n : lista) {
                if (n.getTalla() > max) {
                    max = n.getTalla();
                }
            }
            System.out.println("Ninos con la talla mas alta (" + max + " cm):");
            for (Nino n : lista) {
                if (n.getTalla() == max) {
                    System.out.println(n);
                }
            }
        }
    }
    
    public void mostrarTodos() {
        ArrayList<Nino> lista = listar();
        for (Nino n : lista) {
            System.out.println(n);
        }
    }
}