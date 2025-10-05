public class Chef extends Empleado {
    public int horaExtra;
    public String tipo;
    public float sueldoHora;

    public Chef(String nombre, float sueldomes, int horaExtra, String tipo, float sueldoHora) {
        super(nombre, sueldomes);
        this.horaExtra = horaExtra;
        this.tipo = tipo;
        this.sueldoHora = sueldoHora;
    }

    // c) Sobrecarga/Sobreescritura: Sumar horas extra
    @Override
    public float sueldoTotal() {
        return this.sueldomes + (this.horaExtra * this.sueldoHora);
    }
}