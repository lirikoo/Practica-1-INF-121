class Producto:
    def __init__(self, nombre, precio):
        self._nombre = nombre
        self._precio = precio
        print(f"Producto '{self._nombre}' creado.")

    def __del__(self):
        print(f"Producto '{self._nombre}' eliminado.")

    def get_nombre(self):
        return self._nombre

    def set_nombre(self, nuevo_nombre):
        self._nombre = nuevo_nombre

    def get_precio(self):
        return self._precio

    def set_precio(self, nuevo_precio):
        if nuevo_precio >= 0:
            self._precio = nuevo_precio

    def mostrar_datos(self):
        return f"Producto: {self._nombre} | Precio: ${self._precio:.2f}"


class Pedido:
    def __init__(self, cliente, estado="registrado"):
        self._cliente = cliente
        self._estado = estado
        self._productos = []
        print(f"Pedido de {self._cliente} creado con estado '{self._estado}'.")

    def __del__(self):
        print(f"Pedido de {self._cliente} eliminado.")

    def get_cliente(self):
        return self._cliente

    def set_estado(self, nuevo_estado):
        estados_validos = ["registrado", "preparado", "entregado"]
        if nuevo_estado in estados_validos:
            self._estado = nuevo_estado

    def get_estado(self):
        return self._estado

    def agregar_producto(self, producto):
        self._productos.append(producto)

    def calcular_total(self):
        total = sum(p.get_precio() for p in self._productos)
        return total

    def mostrar_datos(self):
        detalles = f"Pedido de {self._cliente} | Estado: {self._estado} | Total: ${self.calcular_total():.2f}\nProductos:\n"
        for p in self._productos:
            detalles += f"  - {p.mostrar_datos()}\n"
        return detalles.strip()


if __name__ == "__main__":
    cafe = Producto("Café Latte", 3.50)
    pastel = Producto("Pastel de Chocolate", 4.75)

    pedido_ana = Pedido("Ana Torres")
    pedido_ana.agregar_producto(cafe)
    pedido_ana.agregar_producto(pastel)

    print(f"Nombre del producto 1 (Getter): {cafe.get_nombre()}")
    pastel.set_precio(5.00)
    print(f"Nuevo precio de pastel (Getter): {pastel.get_precio()}")

    print("\nEstado inicial del pedido:")
    print(pedido_ana.mostrar_datos())

    pedido_ana.set_estado("preparado")
    print(f"\nEstado actualizado del pedido (Setter): {pedido_ana.get_estado()}")

    pedido_ana.set_estado("entregado")
    print(f"\nEstado final del pedido: {pedido_ana.get_estado()}")
    del cafe
    del pastel
    del pedido_ana
