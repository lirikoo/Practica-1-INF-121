public class MiTeleferico {
    private Linea[] lineas;
    private float cantidadIngresos;

    public MiTeleferico() {
        this.lineas = new Linea[3];
        this.lineas[0] = new Linea("Amarilla", 10); 
        this.lineas[1] = new Linea("Roja", 10);
        this.lineas[2] = new Linea("Verde", 10);
    }

    public void agregarPersonaFila(Persona p, String nombreLinea, int nroCabina) {
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] != null && lineas[i].getColor().equals(nombreLinea)) {
                lineas[i].subirPersonaACabinaEspecifica(p, nroCabina);
                return;
            }
        }
    }

    public void verificarReglas() {
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] != null) {
                Cabina[] cabinas = lineas[i].getCabinas();
                for (int j = 0; j < cabinas.length; j++) {
                    Cabina c = cabinas[j];
                    if (c != null) {
                        if (c.getCantidadActual() > 10) {
                            System.out.println("Error cantidad: Linea " + lineas[i].getColor() + " Cabina " + c.getNroCabina());
                        }
                        if (c.getPesoActual() > 850) {
                            System.out.println("Error peso: Linea " + lineas[i].getColor() + " Cabina " + c.getNroCabina());
                        }
                    }
                }
            }
        }
    }

    public float calcularIngresoTotal() {
        float total = 0;
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] != null) {
                Cabina[] cabinas = lineas[i].getCabinas();
                for (int j = 0; j < cabinas.length; j++) {
                    if (cabinas[j] != null) {
                        Persona[] personas = cabinas[j].getPersonasAbordo();
                        for (int k = 0; k < personas.length; k++) {
                            if (personas[k] != null) {
                                int edad = personas[k].getEdad();
                                if (edad < 25 || edad > 60) {
                                    total += 1.5;
                                } else {
                                    total += 3.0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return total;
    }

    public void mostrarLineaMasIngresoRegular() {
        String mejorLinea = "";
        float mayorIngreso = -1;

        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] != null) {
                float ingresoLinea = 0;
                Cabina[] cabinas = lineas[i].getCabinas();
                for (int j = 0; j < cabinas.length; j++) {
                    if (cabinas[j] != null) {
                        Persona[] personas = cabinas[j].getPersonasAbordo();
                        for (int k = 0; k < personas.length; k++) {
                            if (personas[k] != null) {
                                int edad = personas[k].getEdad();
                                if (edad >= 25 && edad <= 60) {
                                    ingresoLinea += 3.0;
                                }
                            }
                        }
                    }
                }
                if (ingresoLinea > mayorIngreso) {
                    mayorIngreso = ingresoLinea;
                    mejorLinea = lineas[i].getColor();
                }
            }
        }
        System.out.println("Linea mas ingreso regular: " + mejorLinea);
    }
} 
