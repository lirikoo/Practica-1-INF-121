class Fruta:
    def __init__(self, nombre, tipo, vitaminas=None):
        self.nombre = nombre
        self.tipo = tipo
        self.vitaminas = vitaminas if vitaminas is not None else {}
        self.nroVitaminas = len(self.vitaminas)

    def __str__(self):
        return f"{self.nombre} ({self.tipo}, {self.nroVitaminas} vitaminas)"

    def agregar_vitamina(self, nombre_vitamina, es_citrica):
        self.vitaminas[nombre_vitamina] = es_citrica
        self.nroVitaminas = len(self.vitaminas)

    def obtener_vitaminas(self):
        return list(self.vitaminas.keys())

    def contar_citricas(self):
        return sum(1 for es_citrica in self.vitaminas.values() if es_citrica)


def verificar_fruta_con_mas_vitaminas(frutas):
    if not frutas:
        return None
    fruta_max = max(frutas, key=lambda f: f.nroVitaminas)
    return fruta_max


if __name__ == "__main__":


    kiwi = Fruta("kiwi", "subtropical", {"K": False, "C": True, "E": False})

    mandarina = Fruta("mandarina", "cítrica")
    mandarina.agregar_vitamina("C", True)
    mandarina.agregar_vitamina("A", False)

    manzana = Fruta("manzana", "común", {"A": False})
    manzana.agregar_vitamina("C", False)
    manzana.agregar_vitamina("B6", False)

    todas_las_frutas = [kiwi, mandarina, manzana]

    print("--- ESTADO INICIAL ---")
    for fruta in todas_las_frutas:
        print(fruta)

    fruta_max_vit = verificar_fruta_con_mas_vitaminas(todas_las_frutas)
    print("\n---  FRUTA CON MÁS VITAMINAS ---")
    print(f"La fruta con más vitaminas es: {fruta_max_vit.nombre} ({fruta_max_vit.nroVitaminas} vitaminas)")

    fruta_a_consultar = manzana
    print(f"\n---  VITAMINAS DE {fruta_a_consultar.nombre.upper()} ---")
    print(f"Vitaminas: {', '.join(fruta_a_consultar.obtener_vitaminas())}")

    total_citricas = sum(f.contar_citricas() for f in todas_las_frutas)
    print("\n--- CONTEO DE CÍTRICAS ---")
    print(f"Total de vitaminas cítricas en las frutas: {total_citricas}")


    def primera_vitamina(fruta):
        vits = sorted(fruta.obtener_vitaminas())
        return vits[0] if vits else ''
    frutas_ordenadas = sorted(todas_las_frutas, key=primera_vitamina)
    print("\n---  FRUTAS ORDENADAS POR ALFABÉTICAMENTE POR SU PRIMERA VITAMINA ---")
    for fruta in frutas_ordenadas:
        print(f"{fruta.nombre} (Primera vitamina ordenada: {primera_vitamina(fruta)})")
