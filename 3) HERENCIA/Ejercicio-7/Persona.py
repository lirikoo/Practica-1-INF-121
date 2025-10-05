class Persona:
    def __init__(self, nombre, paterno, materno, edad):
        self._nombre = nombre
        self._paterno = paterno
        self._materno = materno
        self._edad = edad

    def mostrar(self):
        print(f"Nombre: {self._nombre} {self._paterno} {self._materno}, Edad: {self._edad}")

    def obtener_edad(self):
        return self._edad

class Docente(Persona):
    def __init__(self, nombre, paterno, materno, edad, sueldo, regProfesional):
        super().__init__(nombre, paterno, materno, edad)
        self.__sueldo = sueldo
        self.__regProfesional = regProfesional

    def mostrar(self):
        print("--- Docente ---")
        super().mostrar()
        print(f"Sueldo: {self.__sueldo}, Registro Profesional: {self.__regProfesional}")
        print("-" * 15)

    def obtener_sueldo(self):
        return self.__sueldo


class Estudiante(Persona):
    def __init__(self, nombre, paterno, materno, edad, ru, matricula):
        super().__init__(nombre, paterno, materno, edad)
        self.__ru = ru
        self.__matricula = matricula

    def mostrar(self):
        print("--- Estudiante ---")
        super().mostrar()
        print(f"RU: {self.__ru}, Matrícula: {self.__matricula}")
        print("-" * 15)

    def modificar_edad(self, nueva_edad):
        if nueva_edad > 0:
            self._edad = nueva_edad
            print(f"Edad de {self._nombre} modificada a {nueva_edad}.")
        else:
            print("Error: La edad debe ser un valor positivo.")

def promedio_edad(estudiantes):
    if not estudiantes:
        return 0
    suma_edades = sum(e.obtener_edad() for e in estudiantes)
    return suma_edades / len(estudiantes)

def verificar_misma_edad(objeto1, objeto2):
    return objeto1.obtener_edad() == objeto2.obtener_edad()

if __name__ == "__main__":
    docente_ejemplo = Docente("Laura", "Paz", "Soto", 45, 3500.0, "DOC-1234")
    estudiante1 = Estudiante("Andrés", "Ramos", "López", 22, "RU-1001", "MAT-A1")
    estudiante2 = Estudiante("Sofía", "Castro", "Vargas", 22, "RU-1002", "MAT-B2")

    lista_estudiantes = [estudiante1, estudiante2]
    docente_ejemplo.mostrar()
    estudiante1.mostrar()
    print(f"Promedio de edad de los estudiantes: {promedio_edad(lista_estudiantes):.2f} años.")

    estudiante2.modificar_edad(23)

    print(f"\nVerificación: ¿Misma edad que {docente_ejemplo._nombre} (45)?")
    print(f"Andrés (22) vs Laura (45): {verificar_misma_edad(estudiante1, docente_ejemplo)}")
    print(f"Sofía (23) vs Laura (45): {verificar_misma_edad(estudiante2, docente_ejemplo)}")
