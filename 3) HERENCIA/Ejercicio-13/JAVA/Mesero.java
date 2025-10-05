public class Mesero extends Empleado {
    public double propina;
    public int horaExtra;
    public float sueldoHora;

    public Mesero(String nombre, float sueldomes, double propina, int horaExtra, float sueldoHora) {
        super(nombre, sueldomes);
        this.propina = propina;
        this.horaExtra = horaExtra;
        this.sueldoHora = sueldoHora;
    }

    // c) Sobrecarga/Sobreescritura: Sumar horas extra y propina
    @Override
    public float sueldoTotal() {
        float pagoHorasExtra = this.horaExtra * this.sueldoHora;
        return this.sueldomes + pagoHorasExtra + (float)this.propina;
    }
}