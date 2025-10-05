class Mascota:
    def __init__(self, nombre, tipo, energia=50):
        self.nombre = nombre
        self.tipo = tipo
        self.energia = energia

    def mostrar_datos(self):
        print(f"Mascota: {self.nombre} ({self.tipo}) | Energía: {self.energia}")

    def alimentar(self):
        self.energia += 20
        if self.energia > 100:
            self.energia = 100

    def jugar(self):
        self.energia -= 15
        if self.energia < 0:
            self.energia = 0


if __name__ == "__main__":
    boby = Mascota("Boby", "Perro", 60)
    kitty = Mascota("Kitty", "Gato", 10)

    print("--- MASCOTA ---")

    print("\nEstado Inicial:")
    boby.mostrar_datos()
    kitty.mostrar_datos()

    print("\nAcciones (Boby juega, Kitty se alimenta):")
    boby.jugar()
    kitty.alimentar()

    boby.mostrar_datos()
    kitty.mostrar_datos()

    print("\nAcción extrema (Kitty juega hasta agotarse):")
    for _ in range(5):
        kitty.jugar()
    kitty.mostrar_datos()

    print("\nAcción extrema (Boby se alimenta hasta el límite):")
    for _ in range(5):
        boby.alimentar()
    boby.mostrar_datos()
