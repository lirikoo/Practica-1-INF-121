class Persona:
    def __init__(self, nombre, paterno, materno, edad, ci):
        self.nombre = nombre
        self.paterno = paterno
        self.materno = materno
        self.edad = edad
        self.ci = ci

    def mostrar_datos(self):
        print(f"Nombre: {self.nombre} {self.paterno} {self.materno}, Edad: {self.edad}, CI: {self.ci}")

    def mayor_de_edad(self):
        return self.edad >= 18

    def modificar_edad(self, nueva_edad):
        self.edad = nueva_edad

    def mismo_apellido_paterno(self, otra_persona):
        return self.paterno == otra_persona.paterno


if __name__ == "__main__":
    persona1 = Persona("Ana", "García", "López", 25, "1234567")
    persona2 = Persona("Carlos", "García", "Martínez", 16, "9876543")

    print("--- PRUEBA  ---")

    print("\n1. Mostrar datos iniciales:")
    persona1.mostrar_datos()
    persona2.mostrar_datos()

    print("\n2. Verificar mayoría de edad:")
    print(f"{persona1.nombre} es mayor de edad: {persona1.mayor_de_edad()}")
    print(f"{persona2.nombre} es mayor de edad: {persona2.mayor_de_edad()}")

    print("\n3. Modificar edad de la persona 2:")
    persona2.modificar_edad(18)
    persona2.mostrar_datos()
    print(f"Nueva verificación para {persona2.nombre}: {persona2.mayor_de_edad()}")

    print("\n4. Verificar mismo apellido paterno:")
    print(
        f"¿{persona1.nombre} y {persona2.nombre} tienen el mismo apellido paterno? {persona1.mismo_apellido_paterno(persona2)}")

    persona3 = Persona("Laura", "Pérez", "Soto", 30, "1122334")
    print(
        f"¿{persona1.nombre} y {persona3.nombre} tienen el mismo apellido paterno? {persona1.mismo_apellido_paterno(persona3)}")
