class Pasajero:
    def __init__(self, nombre, edad, genero):
        self.nombre = nombre
        self.edad = edad
        self.genero = genero

    def mostrar_datos(self):
        print("--- Datos del Pasajero ---")
        print(f"Nombre: {self.nombre}")
        print(f"Edad: {self.edad}")
        print(f"Género: {self.genero}")
        return self

    def preparar_ingreso(self):
        print(f"Pasajero {self.nombre} listo para ser ingresado.")
        return self


class Crucero:
    MAX_PASAJEROS = 100

    def __init__(self, nombre, paisOrigen, paisDestino, nroPasajeros=0):
        self.nombre = nombre
        self.paisOrigen = paisOrigen
        self.paisDestino = paisDestino
        self.nroPasajeros = nroPasajeros
        self.pasajeros = []

    def agregar_pasajero(self, nombre, habitacion, costo, genero):
        if self.nroPasajeros < self.MAX_PASAJEROS:
            self.pasajeros.append({"nombre": nombre, "habitacion": habitacion, "costo": costo, "genero": genero})
            self.nroPasajeros += 1

    def __pos__(self):
        print(f"Crucero {self.nombre} listo para cargar más datos.")
        return self

    def __sub__(self):
        print(f"\n--- Datos del Crucero: {self.nombre} ---")
        print(f"Ruta: {self.paisOrigen} -> {self.paisDestino}")
        print(f"Total Pasajeros: {self.nroPasajeros}")
        print("Detalles de Pasajeros (Nombre | Hab. | Costo)")
        for p in self.pasajeros:
            print(f"  {p['nombre']} | {p['habitacion']} | {p['costo']} USD")
        return self

    def __eq__(self, other):
        if isinstance(other, Crucero):
            es_igual = (self.paisDestino == other.paisDestino)
            print(f"¿{self.nombre} y {other.nombre} tienen el mismo destino ({self.paisDestino})? -> {es_igual}")
            return es_igual
        return False

    def __add__(self, other):
        suma_total_self = sum(p['costo'] for p in self.pasajeros)

        if isinstance(other, Crucero):
            suma_total_other = sum(p['costo'] for p in other.pasajeros)
            suma_total = suma_total_self + suma_total_other
            print(f"Suma total combinada de {self.nombre} y {other.nombre}: {suma_total} USD.")
            return suma_total

        print(f"Suma total de pasajes en {self.nombre}: {suma_total_self} USD.")
        return suma_total_self

    def __neg__(self):
        conteo_hombres = sum(1 for p in self.pasajeros if p['genero'].lower().startswith('m'))
        conteo_mujeres = self.nroPasajeros - conteo_hombres

        print(f"\nConteo de Géneros en {self.nombre}")
        print(f"  Mujeres: {conteo_mujeres}")
        print(f"  Hombres: {conteo_hombres}")
        return self


if __name__ == "__main__":
    crucero1 = Crucero("El Diamante", "Miami", "Caribe")
    crucero2 = Crucero("La Perla", "Barcelona", "Mediterráneo")
    crucero3 = Crucero("El Rubí", "Cancún", "Caribe")

    p1 = Pasajero("Juan Vargas", 35, "Masculino")
    p2 = Pasajero("Martina Vasques", 28, "Femenino")

    crucero1.agregar_pasajero(p1.nombre, 502, 500, "Masculino")
    crucero1.agregar_pasajero(p2.nombre, 603, 1000, "Femenino")
    crucero2.agregar_pasajero("Elena C.", 101, 800, "Femenino")
    crucero3.agregar_pasajero("Luis A.", 102, 400, "Masculino")
    p1.mostrar_datos()
    -crucero1
    crucero1 + crucero2
    crucero1 == crucero3
    -crucero1
