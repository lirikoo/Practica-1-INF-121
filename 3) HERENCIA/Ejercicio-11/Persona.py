from abc import ABC, abstractmethod

class Persona:
    def __init__(self, nombre, edad):
        self._nombre = nombre
        self._edad = edad

    def obtener_nombre(self):
        return self._nombre


class Empleado:
    def __init__(self, sueldo, cargo):
        self._sueldo = sueldo
        self._cargo = cargo

    def obtener_sueldo(self):
        return self._sueldo


class Policia:
    def __init__(self, grado, placa):
        self._grado = grado
        self._placa = placa

    def obtener_grado(self):
        return self._grado


class JefePolicia(Persona, Empleado, Policia):
    def __init__(self, nombre, edad, sueldo, cargo, grado, placa, sector):
        Persona.__init__(self, nombre, edad)
        Empleado.__init__(self, sueldo, cargo)
        Policia.__init__(self, grado, placa)
        self._sector = sector

    def mostrar_datos(self):
        print(f"--- Jefe de Policía: {self._nombre} ---")
        print(f"Nombre: {self._nombre}, Edad: {self._edad}")
        print(f"Cargo: {self._cargo}, Sueldo: ${self._sueldo:,.2f}")
        print(f"Grado: {self._grado}, Placa: {self._placa}, Sector: {self._sector}")


class IReportable(ABC):
    @abstractmethod
    def generar_reporte(self):
        pass


class JefePoliciaReportable(JefePolicia, IReportable):
    def generar_reporte(self):
        return f"Reporte de {self._nombre}: Sueldo {self._sueldo}, Grado {self._grado}."


if __name__ == "__main__":
    jefe1 = JefePolicia("Daniela Mora", 45, 65000, "Comisaria General", "Comisario Mayor", "JP-001", "Norte")
    jefe2 = JefePolicia("Javier Soto", 50, 72000, "Director de Seguridad", "Inspector Jefe", "JP-002", "Sur")

    jefe1.mostrar_datos()
    jefe2.mostrar_datos()

    if jefe1.obtener_sueldo() > jefe2.obtener_sueldo():
        print(f"El mayor sueldo lo tiene: {jefe1.obtener_nombre()} con ${jefe1.obtener_sueldo():,.2f}")
    elif jefe2.obtener_sueldo() > jefe1.obtener_sueldo():
        print(f"El mayor sueldo lo tiene: {jefe2.obtener_nombre()} con ${jefe2.obtener_sueldo():,.2f}")

    if jefe1.obtener_grado() == jefe2.obtener_grado():
        print(f"VERDADERO: Ambos jefes tienen el mismo grado: {jefe1.obtener_grado()}")
    else:
        print(f"FALSO: Los grados son diferentes (Jefe 1: {jefe1.obtener_grado()}, Jefe 2: {jefe2.obtener_grado()})")

    jefe_reporte = JefePoliciaReportable("Elena Flores", 55, 80000, "Jefa de División", "Comisario Mayor", "JP-003", "Este")
    print(jefe_reporte.generar_reporte())
