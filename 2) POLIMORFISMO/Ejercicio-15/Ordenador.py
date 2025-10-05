class Ordenador:
    def __init__(self, codigo_serial, numero, memoria_ram, procesador, estado):
        self.codigo_serial = codigo_serial
        self.numero = numero
        self.memoria_ram = memoria_ram
        self.procesador = procesador
        self.estado = estado

    def __str__(self):
        return f"Serial: {self.codigo_serial}, RAM: {self.memoria_ram}GB, Estado: {self.estado}"


class Laboratorio:
    def __init__(self, nombre, capacidad):
        self.nombre = nombre
        self.capacidad = capacidad
        self.ordenadores = {}
        self.cantidad_ordenadores = 0

    def agregar_ordenador(self, ordenador):
        if self.cantidad_ordenadores < self.capacidad:
            self.ordenadores[ordenador.codigo_serial] = ordenador
            self.cantidad_ordenadores += 1
            return True
        return False

    def remover_ordenador(self, serial):
        if serial in self.ordenadores:
            ordenador = self.ordenadores.pop(serial)
            self.cantidad_ordenadores -= 1
            return ordenador
        return None

    def informacion(self, estado=None, lab_destino=None, ram_minima=None):
        if estado:
            print(f"--- Ordenadores con estado '{estado}' en {self.nombre} ---")
            for ord_data in self.ordenadores.values():
                if ord_data.estado == estado:
                    print(ord_data)

        elif lab_destino:
            print(f"--- Ordenadores que pertenecen a '{self.nombre}' ---")
            for ord_data in self.ordenadores.values():
                print(ord_data)

        elif ram_minima is not None:
            print(f"--- Ordenadores con más de {ram_minima}GB de RAM en {self.nombre} ---")
            for ord_data in self.ordenadores.values():
                if ord_data.memoria_ram > ram_minima:
                    print(ord_data)

        else:
            print(f"--- Información General de {self.nombre} ---")
            print(f"Capacidad: {self.capacidad}, Ocupación: {self.cantidad_ordenadores}")
            for ord_data in self.ordenadores.values():
                print(ord_data)

    def trasladar_ordenadores(self, destino, seriales):
        ordenadores_trasladados = []

        for serial in seriales:
            ordenador = self.remover_ordenador(serial)
            if ordenador and destino.agregar_ordenador(ordenador):
                ordenadores_trasladados.append(serial)

        return ordenadores_trasladados


lasin1 = Laboratorio("Lasin 1", 4)
lasin2 = Laboratorio("Lasin 2", 4)

ord1 = Ordenador("S001", 1, 8, "i5", "activo")
ord2 = Ordenador("S002", 2, 16, "i7", "activo")
ord3 = Ordenador("S003", 3, 4, "i3", "inactivo")
ord4 = Ordenador("S004", 4, 16, "i7", "activo")
ord5 = Ordenador("S005", 5, 8, "i5", "inactivo")
ord6 = Ordenador("S006", 6, 32, "Ryzen 9", "activo")

lasin1.agregar_ordenador(ord1)
lasin1.agregar_ordenador(ord2)
lasin1.agregar_ordenador(ord3)
lasin1.agregar_ordenador(ord4)

lasin2.agregar_ordenador(ord5)
lasin2.agregar_ordenador(ord6)
lasin1.informacion(estado="activo")
print("\n")
lasin2.informacion(lab_destino=True)
print("\n")
lasin1.informacion(ram_minima=8)

print("\n---  Traslado de ordenadores (Estado Inicial) ---")
print(f"Estado {lasin1.nombre}: {lasin1.cantidad_ordenadores}")
print(f"Estado {lasin2.nombre}: {lasin2.cantidad_ordenadores}")

print("\n---  Ejecutando Traslado ---")
seriales_a_mover = ["S002", "S004"]
trasladados = lasin1.trasladar_ordenadores(lasin2, seriales_a_mover)
print(f"Seriales trasladados: {trasladados}")

print("\n---  Traslado de ordenadores (Estado Final) ---")
print(f"Estado {lasin1.nombre}: {lasin1.cantidad_ordenadores}")
print(f"Estado {lasin2.nombre}: {lasin2.cantidad_ordenadores}")