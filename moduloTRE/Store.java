package moduloTRE;
// Classe criada para gerenciar inserções
public class Store {

  /*
  * Função para cadastrar Partido 
  * @params {String} nome - nome do partido
  * @params {String} sigla - sigla do partido
  * @params {String} nomeArquivo - nome do arquivo a ser salvo
  */
  public void cadastrarPartido(String nome, String sigla) {
    Files arquivo;
    arquivo = new Files();

    String[] dados = {nome, sigla};

    arquivo.salvarArquivo("partidos.txt","Arquivo salvo com sucesso", dados);
    
    
  }

  public void imprimirPartidos() {
    Files arquivo;
    arquivo = new Files();

    arquivo.lerDadosArquivo("partidos.txt");
  }

}
