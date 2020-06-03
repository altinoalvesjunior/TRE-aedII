package moduloTRE;

import moduloUrna.Urna;

class Main {
  public static void main(String[] args) {
//    Store cadastro;
//    cadastro = new Store();
//
//    // EXEMPLO de como cadastrar partido
//    cadastro.cadastrarPartido("Partido do Trabalhadores", "PT");
//    cadastro.cadastrarPartido("Partido da Social Democracia Brasileira", "PSDB");
//
//    // Imprimir partidos
//    cadastro.imprimirPartidos();
	  
	  Urna urna = new Urna("/Users/leticiameireles/Desktop/UrnasEletronicas.txt", "/Users/leticiameireles/Desktop/Eleitores.txt", "/Users/leticiameireles/Desktop/Candidato");
	  
//	  urna.registroDeQuemVotou(tituloEleitoral);
//	  urna.verificarExistenciaEleitor(eleitores, tituloEleitoral)
    
  }
}
