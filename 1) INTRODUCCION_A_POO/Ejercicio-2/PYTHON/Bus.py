class Bus:
    def __init__(self, capacidad_maxima):
        self.capacidad_maxima = capacidad_maxima
        self.pasajeros_actuales = 0
        self.recaudacion = 0.0

    def subir(self, cantidad):
        if self.pasajeros_actuales + cantidad <= self.capacidad_maxima:
            self.pasajeros_actuales += cantidad
        else:
            self.pasajeros_actuales = self.capacidad_maxima

    def cobrar_pasaje(self, cantidad):
        self.recaudacion += cantidad * 1.50

    def mostrar_asientos_disponibles(self):
        print(self.capacidad_maxima - self.pasajeros_actuales)

mi_bus = Bus(50)

print(f"Capacidad Maxima del bus: {mi_bus.capacidad_maxima}")
print(f"Pasajeros iniciales: {mi_bus.pasajeros_actuales}")
print(f"Recaudacion inicial: ${mi_bus.recaudacion:.2f}")

print("\n--- Suben 10 pasajeros ---")
mi_bus.subir(10)
mi_bus.cobrar_pasaje(10)
print(f"Pasajeros actuales: {mi_bus.pasajeros_actuales}")
print(f"Recaudacion total: ${mi_bus.recaudacion:.2f}")
print("Asientos disponibles:")
mi_bus.mostrar_asientos_disponibles()
