class Mp4:
    def __init__(self, marca, capacidadGb):
        self.marca = marca
        self.capacidadGb = capacidadGb * 1024 * 1024
        self.nroCanciones = 0
        self.canciones = []
        self.nroVideos = 0
        self.videos = []

    def capacidad_disponible(self):
        peso_total_kb = 0
        for cancion in self.canciones:
            peso_total_kb += cancion['pesoKb']

        peso_total_mg = 0
        for video in self.videos:
            peso_total_mg += video['pesoMg']

        peso_total_kb += (peso_total_mg * 1024)

        capacidad_kb = self.capacidadGb
        disponible_kb = capacidad_kb - peso_total_kb

        return disponible_kb / (1024 * 1024)

    def borrar_cancion(self, nombre=None, artista=None, pesoKb=None):
        canciones_a_borrar = []
        for cancion in self.canciones:
            match_nombre = nombre is None or cancion.get('nombre') == nombre
            match_artista = artista is None or cancion.get('artista') == artista
            match_peso = pesoKb is None or cancion.get('pesoKb') == pesoKb

            if match_nombre and match_artista and match_peso:
                canciones_a_borrar.append(cancion)

        if not canciones_a_borrar:
            return False

        for cancion in canciones_a_borrar:
            self.canciones.remove(cancion)
            self.nroCanciones -= 1
        return True

    def __add__(self, nueva_cancion):
        nombre = nueva_cancion['nombre']
        pesoKb = nueva_cancion['pesoKb']

        existe = any(c['nombre'] == nombre for c in self.canciones)

        if existe:
            return self

        if (self.capacidad_disponible() * 1024 * 1024) >= pesoKb:
            self.canciones.append(nueva_cancion)
            self.nroCanciones += 1
        return self

    def __sub__(self, nuevo_video):
        nombre = nuevo_video['nombre']
        pesoMg = nuevo_video['pesoMg']
        pesoKb = pesoMg * 1024

        existe = any(v['nombre'] == nombre for v in self.videos)

        if existe:
            return self

        if (self.capacidad_disponible() * 1024 * 1024) >= pesoKb:
            self.videos.append(nuevo_video)
            self.nroVideos += 1
        return self


mp4_player = Mp4("Sony", 4.0)

cancion_A = {'nombre': "Cancion A", 'artista': "Artista X", 'pesoKb': 100}
cancion_B = {'nombre': "Cancion B", 'artista': "Artista Y", 'pesoKb': 200}
video_1 = {'nombre': "Video 1", 'artista': "Video Artista", 'pesoMg': 10}
video_2 = {'nombre': "Video 2", 'artista': "Video Artista", 'pesoMg': 20}

mp4_player = mp4_player + cancion_A
mp4_player = mp4_player - video_1

print("--- Inicialización y D) Capacidad ---")
print(f"Canciones: {mp4_player.nroCanciones}, Videos: {mp4_player.nroVideos}")
print(f"Capacidad Disponible: {mp4_player.capacidad_disponible():.3f} GB")

print("\n--- B) Sobrecarga '+' (Añadir Canción) ---")
mp4_player = mp4_player + cancion_B
mp4_player = mp4_player + cancion_A
print(f"Total Canciones: {mp4_player.nroCanciones}")

print("\n--- C) Sobrecarga '-' (Añadir Video) ---")
mp4_player = mp4_player - video_2
print(f"Total Videos: {mp4_player.nroVideos}")

print("\n--- A) Sobrecarga método (Borrar) ---")
mp4_player.borrar_cancion(nombre="Cancion B")
print(f"Total Canciones después de borrar: {mp4_player.nroCanciones}")

print("\n--- D) Capacidad Final ---")
print(f"Capacidad Disponible Final: {mp4_player.capacidad_disponible():.3f} GB")