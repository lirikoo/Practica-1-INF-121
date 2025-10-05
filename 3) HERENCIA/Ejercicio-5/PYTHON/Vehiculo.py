class Vehiculo:
    def __init__(self, conductor, placa, id):
        # Atributos protegidos (#)
        self._conductor = conductor
        self._placa = placa
        self._id = id

    def mostrar_datos(self):
        print(f"ID: {self._id}, Placa: {self._placa}, Conductor: {self._conductor}")

    def cambiar_conductor(self, nuevo_conductor):
        # c) Crear un método para cambiar al conductor de un vehículo
        self._conductor = nuevo_conductor
        print(f"El conductor del vehículo con placa {self._placa} ha cambiado a {nuevo_conductor}.")


class Bus(Vehiculo):
    def __init__(self, conductor, placa, id, capacidad, sindicato):
        super().__init__(conductor, placa, id)
        # Atributos privados (-)
        self.__capacidad = capacidad
        self.__sindicato = sindicato

    def mostrar_datos_completos(self):
        self.mostrar_datos()
        print(f"Capacidad: {self.__capacidad}, Sindicato: {self.__sindicato}")


class Auto(Vehiculo):
    def __init__(self, conductor, placa, id, caballosFuerza, descapotable):
        super().__init__(conductor, placa, id)
        # Atributos privados (-)
        self.__caballosFuerza = caballosFuerza
        self.__descapotable = descapotable

    def mostrar_datos_completos(self):
        self.mostrar_datos()
        estado_descapotable = "Sí" if self.__descapotable else "No"
        print(f"Caballos de Fuerza: {self.__caballosFuerza}, Descapotable: {estado_descapotable}")


class Moto(Vehiculo):
    def __init__(self, conductor, placa, id, cilindrada, casco):
        super().__init__(conductor, placa, id)
        # Atributos privados (-)
        self.__cilindrada = cilindrada
        self.__casco = casco

    def mostrar_datos_completos(self):
        self.mostrar_datos()
        estado_casco = "Sí" if self.__casco else "No"
        print(f"Cilindrada: {self.__cilindrada}, Requiere Casco: {estado_casco}")


if __name__ == "__main__":

    bus_ejemplo = Bus("Carlos Ruiz", "BCA-100", 1, 50, "Sindicato Azul")
    auto_ejemplo = Auto("Ana Gómez", "AUT-202", 2, 250, True)
    moto_ejemplo = Moto("Pedro Salas", "MOT-303", 3, 650, False)

    vehiculos = [bus_ejemplo, auto_ejemplo, moto_ejemplo]

    print("--- b) Mostrar Placa y Conductor de cada vehículo ---")
    for v in vehiculos:
        print(f"{v.__class__.__name__}: ", end="")
        v.mostrar_datos()

    print("\n--- c) Cambiar el conductor de un vehículo ---")
    auto_ejemplo.cambiar_conductor("Marta Linares")

    print("\n--- Verificación del cambio ---")
    auto_ejemplo.mostrar_datos()

    print("\n--- Datos completos ---")
    bus_ejemplo.mostrar_datos_completos()
    auto_ejemplo.mostrar_datos_completos()
    moto_ejemplo.mostrar_datos_completos()