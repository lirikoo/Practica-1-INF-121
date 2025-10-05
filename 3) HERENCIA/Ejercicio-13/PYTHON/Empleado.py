class Empleado:
    def __init__(self, nombre, sueldomes):
        self._nombre = nombre
        self.sueldomes = sueldomes

    def sueldo_total(self):
        # Sueldo total base (sin extras)
        return self.sueldomes

    def __str__(self):
        return f"Nombre: {self._nombre}, Sueldo Base Mensual: ${self.sueldomes:,.2f}"

class Administrativo(Empleado):
    def __init__(self, nombre, sueldomes, cargo):
        super().__init__(nombre, sueldomes)
        self.cargo = cargo

    # SueldoTotal: No hay extras, solo hereda el sueldomes
    def sueldo_total(self):
        return super().sueldo_total()

    def __str__(self):
        return f"ADMINISTRATIVO - {super().__str__()} - Cargo: {self.cargo}"

class Chef(Empleado):
    def __init__(self, nombre, sueldomes, horaExtra, tipo, sueldoHora):
        super().__init__(nombre, sueldomes)
        self.horaExtra = horaExtra
        self.tipo = tipo
        self.sueldoHora = sueldoHora

    # c) Sobrecargar el método SueldoTotal: sumándole las horas extra
    def sueldo_total(self):
        sueldo_base = super().sueldo_total()
        pago_horas_extra = self.horaExtra * self.sueldoHora
        return sueldo_base + pago_horas_extra

    def __str__(self):
        return f"CHEF - {super().__str__()} - Tipo: {self.tipo}, Horas Extra: {self.horaExtra}"

class Mesero(Empleado):
    def __init__(self, nombre, sueldomes, propina, horaExtra, sueldoHora):
        super().__init__(nombre, sueldomes)
        self.propina = propina
        self.horaExtra = horaExtra
        self.sueldoHora = sueldoHora

    def sueldo_total(self):
        sueldo_base = super().sueldo_total()
        pago_horas_extra = self.horaExtra * self.sueldoHora
        return sueldo_base + pago_horas_extra + self.propina

    def __str__(self):
        return f"MESERO - {super().__str__()} - Propina Estimada: ${self.propina:,.2f}, Horas Extra: {self.horaExtra}"

chef = Chef("Gustave", 4000.0, 10, "Pastelería", 25.0)
mesero1 = Mesero("Alfredo", 1500.0, 500.0, 5, 10.0)
mesero2 = Mesero("Colette", 1500.0, 650.0, 15, 10.0)
admin1 = Administrativo("Skinner", 3000.0, "Gerente")
admin2 = Administrativo("Amelie", 2800.0, "Recursos Humanos")

personal = [chef, mesero1, mesero2, admin1, admin2]

print("--- Sueldos Totales (c) y Datos Generales ---")
for empleado in personal:
    sueldo = empleado.sueldo_total()
    print(f"{empleado} | Sueldo TOTAL: ${sueldo:,.2f}")
print("-" * 50)

X = 1500.0
print(f"--- b) Empleados con sueldomes igual a ${X:,.2f} ---")

encontrados = [e for e in personal if e.sueldomes == X]

if encontrados:
    for e in encontrados:
        print(f"ENCONTRADO: {e._nombre} (Clase: {e.__class__.__name__})")
else:
    print(f"No se encontraron empleados con sueldomes igual a ${X:,.2f}.")