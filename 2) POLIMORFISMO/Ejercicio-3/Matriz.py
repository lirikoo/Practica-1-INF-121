class Matriz:
    def __init__(self, valores=None, size=3):
        self.size = size
        self.matriz = [[0.0 for _ in range(size)] for _ in range(size)]

        if valores is None:
            for i in range(size):
                self.matriz[i][i] = 1.0
        else:
            for i in range(min(size, len(valores))):
                for j in range(min(size, len(valores[i]))):
                    self.matriz[i][j] = float(valores[i][j])

    def __add__(self, otra_matriz):
        resultado = Matriz(size=self.size)
        for i in range(self.size):
            for j in range(self.size):
                resultado.matriz[i][j] = self.matriz[i][j] + otra_matriz.matriz[i][j]
        return resultado

    def __sub__(self, otra_matriz):
        resultado = Matriz(size=self.size)
        for i in range(self.size):
            for j in range(self.size):
                resultado.matriz[i][j] = self.matriz[i][j] - otra_matriz.matriz[i][j]
        return resultado

    def __eq__(self, otra_matriz):
        if isinstance(otra_matriz, Matriz):
            for i in range(self.size):
                for j in range(self.size):
                    if self.matriz[i][j] != otra_matriz.matriz[i][j]:
                        return False
            return True
        return False

    def __str__(self):
        s = "Matriz:\n"
        for fila in self.matriz:
            s += " ".join(f"{x:.1f}" for x in fila) + "\n"
        return s


if __name__ == "__main__":
    matriz_identidad = Matriz(size=3)

    valores_A = [[1.0, 2.0, 3.0], [4.0, 5.0, 6.0], [7.0, 8.0, 9.0]]
    matriz_A = Matriz(valores_A, size=3)

    valores_B = [[1.0, 1.0, 1.0], [0.0, 0.0, 0.0], [1.0, 1.0, 1.0]]
    matriz_B = Matriz(valores_B, size=3)

    matriz_suma = matriz_A + matriz_B
    matriz_resta = matriz_A - matriz_B
    matriz_original_sumada = matriz_resta + matriz_B

    print("Matriz A:")
    print(matriz_A)

    print("Matriz B:")
    print(matriz_B)

    print("Suma (A + B):")
    print(matriz_suma)

    print("Resta (A - B):")
    print(matriz_resta)

    print(f"¿A es igual a (Resta + B)? {matriz_A == matriz_original_sumada}")
    print(f"¿A es igual a Identidad? {matriz_A == matriz_identidad}")
