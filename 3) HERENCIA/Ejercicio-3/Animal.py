class Animal:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad

    def desplazarse(self):
        raise NotImplementedError("Cada animal debe definir su propia forma de desplazamiento.")

    def __str__(self):
        return f"{self.nombre} (Edad: {self.edad})"

class Leon(Animal):
    def desplazarse(self):
        return f"{self.nombre} está caminando y rugiendo."

class Pinguino(Animal):
    def desplazarse(self):
        return f"{self.nombre} está nadando y se desliza sobre el hielo."

class Canguro(Animal):
    def desplazarse(self):
        return f"{self.nombre} está saltando con fuerza en la bolsa."

if __name__ == "__main__":
    simba = Leon("Simba", 5)
    skipper = Pinguino("Skipper", 3)
    joey = Canguro("Joey", 2)

    zoo = [simba, skipper, joey]

    for animal in zoo:
        print(f"Animal: {animal}")
        print(f"Acción: {animal.desplazarse()}")
        print("-" * 20)