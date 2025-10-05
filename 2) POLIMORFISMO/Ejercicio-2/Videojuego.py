class Videojuego:
    def __init__(self, nombre, plataforma=None, cantidad_jugadores=0):
        self.nombre = nombre
        self.plataforma = plataforma
        self.cantidad_jugadores = cantidad_jugadores

    def __str__(self):
        return f"Juego: {self.nombre} | Plataforma: {self.plataforma} | Jugadores: {self.cantidad_jugadores}"

    def agregarJugadores(self, cantidad=1):
        if cantidad == 1:
            self.cantidad_jugadores += 1
            print(f"Jugador individual añadido a {self.nombre}.")
        elif cantidad > 1:
            self.cantidad_jugadores += cantidad
            print(f"{cantidad} jugadores añadidos a {self.nombre}.")
        else:
            print("Cantidad de jugadores inválida.")


if __name__ == "__main__":
    juego1 = Videojuego("Cyberpunk 2077", "PC", 1)
    juego2 = Videojuego("Mario Kart", "Switch")
    juego3 = Videojuego("Tetris", cantidad_jugadores=0)

    print("Estado Inicial:")
    print(juego1)
    print(juego2)
    print(juego3)

    print("\nUso del Método Sobrecargado:")

    juego2.agregarJugadores()

    juego1.agregarJugadores(3)

    print("\nEstado Final:")
    print(juego1)
    print(juego2)
