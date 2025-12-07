package EJERCICIO_5;

import java.io.*;
import java.util.ArrayList;

public class ArchFarmacia {
    private String na;

    public ArchFarmacia(String na) {
        this.na = na;
    }

    public void crearArchivo() {
        try {
            File f = new File(na);
            if (f.createNewFile()) {
                System.out.println("Archivo creado.");
            }
        } catch (Exception e) {
            System.out.println("Error creando archivo.");
        }
    }

    private ArrayList<Farmacia> listar() {
        ArrayList<Farmacia> lista = new ArrayList<>();
        try {
            File f = new File(na);
            if (f.exists()) {
                DataInputStream dis = new DataInputStream(new FileInputStream(na));
                while (dis.available() > 0) {
                    String nomF = dis.readUTF();
                    int suc = dis.readInt();
                    String dir = dis.readUTF();
                    int nro = dis.readInt();

                    Farmacia farm = new Farmacia(nomF, suc, dir);
                    for (int i = 0; i < nro; i++) {
                        String nomM = dis.readUTF();
                        int cod = dis.readInt();
                        String tipo = dis.readUTF();
                        double prec = dis.readDouble();
                        farm.agregarMedicamento(new Medicamento(nomM, cod, tipo, prec));
                    }
                    lista.add(farm);
                }
                dis.close();
            }
        } catch (Exception e) {
            System.out.println("Error al leer.");
        }
        return lista;
    }

    private void guardarLista(ArrayList<Farmacia> lista) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(na));
            for (Farmacia f : lista) {
                dos.writeUTF(f.getNombreFarmacia());
                dos.writeInt(f.getSucursal());
                dos.writeUTF(f.getDireccion());
                dos.writeInt(f.getNroMedicamentos());

                Medicamento[] meds = f.getMedicamentos();
                for (int i = 0; i < f.getNroMedicamentos(); i++) {
                    dos.writeUTF(meds[i].getNombre());
                    dos.writeInt(meds[i].getCodMedicamento());
                    dos.writeUTF(meds[i].getTipo());
                    dos.writeDouble(meds[i].getPrecio());
                }
            }
            dos.close();
        } catch (Exception e) {
            System.out.println("Error al guardar.");
        }
    }

    public void adicionar(Farmacia f) {
        ArrayList<Farmacia> lista = listar();
        lista.add(f);
        guardarLista(lista);
    }
    
    public void listarTodas() {
        ArrayList<Farmacia> lista = listar();
        for(Farmacia f : lista) {
            System.out.println(f);
            for(int i=0; i<f.getNroMedicamentos(); i++){
                System.out.println("   -> " + f.getMedicamentos()[i]);
            }
        }
    }

    public void mostrarMedicamentosTosSucursal(int x) {
        ArrayList<Farmacia> lista = listar();
        boolean encontrado = false;
        for (Farmacia f : lista) {
            if (f.getSucursal() == x) {
                encontrado = true;
                System.out.println("Medicamentos para la TOS en Sucursal " + x + ":");
                Medicamento[] meds = f.getMedicamentos();
                for (int i = 0; i < f.getNroMedicamentos(); i++) {
                    if (meds[i].getTipo().equalsIgnoreCase("Tos")) {
                        System.out.println(meds[i]);
                    }
                }
            }
        }
        if (!encontrado) System.out.println("No existe la sucursal " + x);
    }

    public void buscarTapsin() {
        ArrayList<Farmacia> lista = listar();
        System.out.println("Farmacias que tienen Tapsin:");
        for (Farmacia f : lista) {
            Medicamento[] meds = f.getMedicamentos();
            for (int i = 0; i < f.getNroMedicamentos(); i++) {
                if (meds[i].getNombre().equalsIgnoreCase("Tapsin")) {
                    System.out.println("Sucursal: " + f.getSucursal() + ", Direccion: " + f.getDireccion());
                    break; 
                }
            }
        }
    }

    public void buscarPorTipo(String tipo) {
        ArrayList<Farmacia> lista = listar();
        System.out.println("Buscando medicamentos tipo: " + tipo);
        for (Farmacia f : lista) {
            Medicamento[] meds = f.getMedicamentos();
            for (int i = 0; i < f.getNroMedicamentos(); i++) {
                if (meds[i].getTipo().equalsIgnoreCase(tipo)) {
                    System.out.println("En Sucursal " + f.getSucursal() + ": " + meds[i].getNombre());
                }
            }
        }
    }

    public void ordenarPorDireccion() {
        ArrayList<Farmacia> lista = listar();
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).getDireccion().compareToIgnoreCase(lista.get(j).getDireccion()) > 0) {
                    Farmacia temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                }
            }
        }
        guardarLista(lista);
        System.out.println("Farmacias ordenadas por direccion.");
        listarTodas();
    }

    public void moverMedicamentos(String tipo, int sucOrigen, int sucDestino) {
        ArrayList<Farmacia> lista = listar();
        Farmacia origen = null;
        Farmacia destino = null;

        for (Farmacia f : lista) {
            if (f.getSucursal() == sucOrigen) origen = f;
            if (f.getSucursal() == sucDestino) destino = f;
        }

        if (origen != null && destino != null) {
            Medicamento[] mOrigen = origen.getMedicamentos();
            ArrayList<Medicamento> conservados = new ArrayList<>();
            
            for (int i = 0; i < origen.getNroMedicamentos(); i++) {
                if (mOrigen[i].getTipo().equalsIgnoreCase(tipo)) {
                    destino.agregarMedicamento(mOrigen[i]);
                } else {
                    conservados.add(mOrigen[i]);
                }
            }

            origen.setNroMedicamentos(0);
            for (Medicamento m : conservados) {
                origen.agregarMedicamento(m);
            }

            guardarLista(lista);
            System.out.println("Se movieron medicamentos tipo " + tipo + " de Sucursal " + sucOrigen + " a " + sucDestino);
        } else {
            System.out.println("No se encontraron las sucursales.");
        }
    }
}