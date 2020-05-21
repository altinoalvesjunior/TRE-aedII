class Main {
  public static void main(String[] args) {
    Store cadastro;
    cadastro = new Store();

    // EXEMPLO de como cadastrar partido
    cadastro.cadastrarPartido("Partido do Trabalhadores", "PT");
    cadastro.cadastrarPartido("Partido da Social Democracia Brasileira", "PSDB");

    // Imprimir partidos
    cadastro.imprimirPartidos();
    
  }
}
