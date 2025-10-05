class Parada:
    MAX_SIZE = 10

    def __init__(self, nombreP="Parada Sin Nombre"):
        self.nombreP = nombreP

        self.admins = []
        self.autos = []

        self.nroAdmins = 0
        self.nroAutos = 0

    def mostrar(self):
        print("\n" + "-" * 30)
        print(f"PARADA: {self.nombreP}")

        print(f"ADMINISTRADORES ({self.nroAdmins} de {self.MAX_SIZE}):")
        if self.nroAdmins > 0:
            for i, admin in enumerate(self.admins):
                print(f"  {i + 1}. {admin}")
        else:
            print("  (No hay administradores)")

        print(f"AUTOS ({self.nroAutos} de {self.MAX_SIZE}):")
        if self.nroAutos > 0:
            print("  Índice | Modelo | Conductor | Placa")
            for i, auto in enumerate(self.autos):
                print(f"  {i + 1}. {auto[0]} | {auto[1]} | {auto[2]}")
        else:
            print("  (No hay autos)")
        print("-" * 30)

    def adicionar(self, *args):
        num_args = len(args)

        if num_args == 1:
            admin = args[0]
            if self.nroAdmins < self.MAX_SIZE:
                self.admins.append(admin)
                self.nroAdmins += 1
            else:
                print("[ERROR] Límite de administradores (10) alcanzado.")

        elif num_args == 3:
            modelo, conductor, placa = args
            if self.nroAutos < self.MAX_SIZE:
                nuevo_auto = [modelo, conductor, placa]
                self.autos.append(nuevo_auto)
                self.nroAutos += 1
            else:
                print("[ERROR] Límite de autos (10) alcanzado.")

        else:
            print(f"[ERROR] Método adicionar llamado con {num_args} argumentos. Se espera 1 (admin) o 3 (auto).")


if __name__ == "__main__":
    parada_central = Parada("Parada Central")
    parada_defecto = Parada()

    parada_central.adicionar("Laura G.", "Toyota", "A1B2C3")
    parada_central.adicionar("Javier V.")
    parada_central.adicionar("Mario C.")
    parada_central.adicionar("Nissan", "Pedro A.", "X7Y8Z9")

    parada_central.mostrar()
    parada_defecto.mostrar()
