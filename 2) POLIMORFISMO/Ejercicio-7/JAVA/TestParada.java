class TestParada {
    public static void main(String[] args) {
        Parada paradaTarija = new Parada("Terminal de Tarija");

        paradaTarija.adicionar("Marta R.");
        paradaTarija.adicionar("Pedro S.");

        paradaTarija.adicionar("Nissan", "Luis M.", "TAG-345");
        paradaTarija.adicionar("Ford", "Ana G.", "FSD-101");

        paradaTarija.mostrar();
    }
}