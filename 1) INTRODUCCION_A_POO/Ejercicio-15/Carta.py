class Carta:
    def __init__(self, codigo, descripcion, remitente, destinatario):
        self.codigo = codigo
        self.descripcion = descripcion
        self.remitente = remitente
        self.destinatario = destinatario

    def __str__(self):
        return f"Cód: {self.codigo} | Rem: {self.remitente} | Dest: {self.destinatario}"


class Buzon:
    def __init__(self, nro, nroC):
        self.nro = nro
        self.nroC = nroC
        self.cartas = []

    def agregar_carta(self, carta):
        if len(self.cartas) < self.nroC:
            self.cartas.append(carta)
            return True
        return False

    def verificar_cartas_destinatario(self, destinatario_x):
        return sum(1 for c in self.cartas if c.destinatario == destinatario_x)

    def eliminar_carta_por_codigo(self, codigo_x):
        self.cartas = [c for c in self.cartas if c.codigo != codigo_x]

    def verificar_recepcion_remitente(self, remitente_x):
        for c in self.cartas:
            if c.destinatario == remitente_x:
                return c.remitente
        return None

    def buscar_palabra_clave(self, palabra):
        resultados = []
        for c in self.cartas:
            if palabra.lower() in c.descripcion.lower():
                resultados.append(c)
        return resultados


if __name__ == "__main__":


    c1 = Carta("C123", "Querido amigo te escribo para decirte que ella no te ama por lo tanto...", "Juan Álvarez",
               "Peter Chaves")
    c2 = Carta("C456", "Hola, te informo que el paquete ya fue enviado. ¡Con mucho amor!", "Pepe Mujica",
               "Wilmer Pérez")
    c3 = Carta("C789", "Estimado Pepe, recibí tu último mensaje. La respuesta es NO.", "Paty Vasques", "Pepe Mujica")
    c4 = Carta("C001", "Solo quería expresar mi amor por el arte. Saludos.", "Juan Álvarez", "Peter Chaves")


    buzon_a = Buzon("001", 5)
    buzon_b = Buzon("002", 3)
    buzon_c = Buzon("003", 4)


    buzon_a.agregar_carta(c1)
    buzon_a.agregar_carta(c2)
    buzon_a.agregar_carta(c3)
    buzon_a.agregar_carta(c4)

    for carta in buzon_a.cartas:
        print(carta)

    destinatario_x = "Pepe Mujica"
    count = buzon_a.verificar_cartas_destinatario(destinatario_x)
    print(f"\n---  CONTEO DE CARTAS ---")
    print(f"Cartas recibidas por '{destinatario_x}': {count}")

    codigo_a_eliminar = "C123"
    buzon_a.eliminar_carta_por_codigo(codigo_a_eliminar)
    print(f"\n---  CARTA ELIMINADA ({codigo_a_eliminar}) ---")
    print(f"Cartas restantes: {len(buzon_a.cartas)}")

    remitente_a_verificar = "Paty Vasques"
    remitente_original = buzon_a.verificar_recepcion_remitente(remitente_a_verificar)
    print(f"\n---  VERIFICACIÓN DE RECEPCIÓN ---")
    if remitente_original:
        print(f"'{remitente_a_verificar}' sí recibió una carta, enviada por '{remitente_original}'.")
    else:
        print(f"'{remitente_a_verificar}' no recibió cartas en este buzón.")

    palabra_clave = "amor"
    coincidencias = buzon_a.buscar_palabra_clave(palabra_clave)

    print(f"\n--- BÚSQUEDA POR PALABRA CLAVE ('{palabra_clave.upper()}') ---")
    if coincidencias:
        for c in coincidencias:
            print(f"Cód: {c.codigo} | Rem: {c.remitente} | Dest: {c.destinatario}")
    else:
        print("No se encontraron coincidencias.")
