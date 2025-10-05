class Producto:
    def __init__(self, nombre, precio, stock):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock

    def vender(self, cantidad):
        if self.stock >= cantidad:
            self.stock -= cantidad

    def reabastecer(self, cantidad):
        self.stock += cantidad

    def __str__(self):
        return f"Producto: {self.nombre} | Precio: ${self.precio} | Stock: {self.stock}"

if __name__ == "__main__":
    frijoles = Producto("Frijoles", 1.99, 50)

    print("---  PRODUCTO  ---")
    print("Estado Inicial:")
    print(frijoles)

    frijoles.vender(15)
    print("\nDespués de vender 15 unidades:")
    print(frijoles)

    frijoles.reabastecer(75)
    print("\nDespués de reabastecer 75 unidades:")
    print(frijoles)

    frijoles.vender(300)
    print("\nIntentando vender 300 (sin stock suficiente):")
    print(frijoles)
