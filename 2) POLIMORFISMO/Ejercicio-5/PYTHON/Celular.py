class Celular:
    def __init__(self, nroTel, dueño, espacio, ram, nroApp):
        self.nroTel = nroTel
        self.dueño = dueño
        self.espacio = espacio
        self.ram = ram
        self.nroApp = nroApp

    def __str__(self):
        return f"Dueño: {self.dueño}, Apps: {self.nroApp}, Espacio: {self.espacio} GB"

    def __iadd__(self, otro):
        self.nroApp += 10
        return self

    def __isub__(self, otro):
        self.espacio -= 5
        if self.espacio < 0:
            self.espacio = 0
        return self

celular = Celular("555-1234", "Estudiante", 100.0, 8, 5)

print("---  Estado Inicial ---")
print(celular)

print("\n--- Aplicando Operador ++ (nroApp + 10) ---")
celular += 1
print(celular)

print("\n--- Aplicando Operador -- (espacio - 5 GB) ---")
celular -= 1
print(celular)