class Persona:
    def __init__(self, nombre, carnet):
        self.nombre = nombre
        self.carnet = carnet

    def mostrar_datos_personales(self):
        return f"Nombre: {self.nombre}, Carnet: {self.carnet}"


class Estudiante(Persona):
    def __init__(self, nombre, carnet, materia, nota):
        super().__init__(nombre, carnet)
        self.materia = materia
        self.nota = nota

    def mostrar_datos_completos(self):
        return f"{self.mostrar_datos_personales()}, Materia: {self.materia}, Nota: {self.nota}"


class Empleado(Persona):
    def __init__(self, nombre, carnet, cargo):
        super().__init__(nombre, carnet)
        self.cargo = cargo

    def mostrar_datos_completos(self):
        return f"{self.mostrar_datos_personales()}, Cargo: {self.cargo}"


class Administrativo(Persona):
    def __init__(self, nombre, carnet, salario, cargo):
        super().__init__(nombre, carnet)
        self.salario = salario
        self.cargo = cargo

    def mostrar_datos_completos(self):
        return f"{self.mostrar_datos_personales()}, Cargo: {self.cargo}, Salario: {self.salario}"


class Docente(Persona):
    def __init__(self, nombre, carnet, materia, salario):
        super().__init__(nombre, carnet)
        self.materia = materia
        self.salario = salario

    def mostrar_datos_completos(self):
        return f"{self.mostrar_datos_personales()}, Materia: {self.materia}, Salario: {self.salario}"

    def pasa_clases_con(self, estudiante):
        return self.materia == estudiante.materia


estudiante1 = Estudiante("Ana Lopez", 101, "POO", 85.5)
empleado1 = Empleado("Carlos Ruiz", 201, "Limpieza")
admin1 = Administrativo("Laura Mena", 301, 3500.0, "Contabilidad")
docente1 = Docente("Dr. Pérez", 401, "POO", 5000.0)

print(f"Estudiante: {estudiante1.nombre} (Materia: {estudiante1.materia})")
print(f"Docente: {docente1.nombre} (Materia: {docente1.materia})")

objetos = [estudiante1, empleado1, admin1, docente1]
for obj in objetos:
    print(f"{obj.__class__.__name__}: {obj.mostrar_datos_personales()}")

pasan = docente1.pasa_clases_con(estudiante1)

if pasan:
    print(f"{estudiante1.nombre} SÍ pasa clases con {docente1.nombre}")
else:
    print(f"{estudiante1.nombre} NO pasa clases con {docente1.nombre}")