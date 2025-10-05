class Nadador:
    def __init__(self, estiloNatacion):
        self.estiloNatacion = estiloNatacion

    def nadar(self):
        return f"Nadando estilo {self.estiloNatacion}"


class Ciclista:
    def __init__(self, tipoBicicleta):
        self.tipoBicicleta = tipoBicicleta

    def pedalear(self):
        return f"Pedaleando en bicicleta tipo {self.tipoBicicleta}"


class Corredor:
    def __init__(self, distanciaPreferida):
        self.distanciaPreferida = distanciaPreferida

    def correr(self):
        return f"Corriendo una distancia de {self.distanciaPreferida} km"


class Triatleta(Nadador, Ciclista, Corredor):
    def __init__(self, nombre, estiloNatacion, tipoBicicleta, distanciaPreferida):
        Nadador.__init__(self, estiloNatacion)
        Ciclista.__init__(self, tipoBicicleta)
        Corredor.__init__(self, distanciaPreferida)
        self.nombre = nombre

    def presentarse(self):
        print(f"Soy el triatleta {self.nombre} y estoy listo para competir.")


if __name__ == "__main__":
    competidor = Triatleta(
        nombre="Javier Gómez",
        estiloNatacion="Libre",
        tipoBicicleta="Ruta",
        distanciaPreferida=10.0
    )

    competidor.presentarse()

    print("\n--- Acciones del Triatleta ---")
    print(f"Natación: {competidor.nadar()}")
    print(f"Ciclismo: {competidor.pedalear()}")
    print(f"Carrera: {competidor.correr()}")
