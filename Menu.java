import java.io.*;
class Menu {
  BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

  /**
  * @public
  * Abre Menu de opções
  */
  public void abrirMenu() {
    System.out.println("Escolha uma etapa: ");
    System.out.println("1 - Antes das eleições – Preparação");
    System.out.println("2 - Durante as eleições");
    System.out.println("3 - Depois das eleições – Divulgação dos resultados");
    System.out.println("Digite o número da etapa: ");
    try {
      int opcaoNumero = Integer.parseInt(br.readLine());

      switch( opcaoNumero ) {

        case 1: 
          // Abrir Etapa 1: Antes das eleições – Preparação
          this.etapa1();
          break;
        case 2: 
          // Abrir Etapa 2: Durante as eleições
          this.etapa2();
          break;
        case 3: 
          // Abrir Etapa 3: Antes das eleições – Preparação
          this.etapa3();
          break;
        default: 
          this.abrirMenu();
          break;
      }
    } catch(IOException e) {
      e.printStackTrace();
    }

  }

  /**
  * @public
  * Opção do módulo da primeira etapa
  */
  public void etapa1() {
    System.out.println("Escolha um módulo: ");
    System.out.println("1 - TRE");
    System.out.println("2 - URNA");
    try {
      String opcao = br.readLine();

      switch( opcao ) {

        case "1": 
          // TRE opções
          this.etapa1TRE();
          break;
        case "2": 
          // URNA opções
          this.etapa1URNA();
          break;
        default: 
          this.abrirMenu();
          break;
      }
    } catch(IOException e) {
      e.printStackTrace();
    }

  }

  /**
  * @public
  * Opções da primeira etapa do módulo TRE
  */
  public void etapa1TRE() {
    System.out.println("Escolha uma opção: ");
    System.out.println("a - Cadastro de partidos políticos");
    System.out.println("b - Cadastro de municípios");
    System.out.println("c - Cadastro dos candidatos a prefeito e vereador");
    System.out.println("d - Cadastro dos eleitores");
    System.out.println("e - Cadastro das urnas eletrônicas");
    System.out.println("f - Exportar dados para as urnas eletrônicas");

    try {
      String opcao = br.readLine();
      opcao = opcao.toUpperCase();

      switch(opcao) {

        case "A": 
          // TRE opções
          this.etapa1TRE();
          break;
        case "B": 
          // TRE opções
          // Chamar método
          break;
        case "C": 
          // TRE opções
          // Chamar método
          break;
        case "D": 
          // TRE opções
          // Chamar método
          break;
        case "E": 
          // TRE opções
          // Chamar método
          break;
        case "F": 
          // TRE opções
          // Chamar método
          break;
        default:
          this.etapa1TRE();
          break;

      }
    } catch(IOException e) {
      e.printStackTrace();
    }
    
  }

  /**
  * @public
  * Abre ação da URNA da primeira etapa
  */
  public void etapa1URNA() {
    // chamar método de configurar urna eletronica
  }

  public void etapa2() {
    try {
      String opcao = br.readLine();
      opcao = opcao.toUpperCase();

      if( opcao == "A" ) {
        // método de votar
        return;
      } 
      if ( opcao == "B" ) {
        // método de justificar voto
        return;
      }

      this.etapa1URNA();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  /**
  * @public
  * Opções da terceira etapa do módulo URNA ou TRE
  */
  public void etapa3() {
    System.out.println("Escolha um módulo: ");
    System.out.println("1 - URNA");
    System.out.println("2 - TRE");

    try {
      int opcaoNumero = Integer.parseInt(br.readLine());

      if( opcaoNumero == 1 ) {
        // método de EXPORTAR resultados
        return;
      } 
      if ( opcaoNumero == 2 ) {
        // método de opções
        this.etapa3TRE();
        return;
      }

      this.etapa3TRE();
    } catch(IOException e) {
      e.printStackTrace();
    }
   }

  /**
  * @public
  * Opções da terceira etapa do módulo TRE
  */
  public void etapa3TRE() {
    System.out.println("Escolha uma opção: ");
    System.out.println("a - Importar resultados");
    System.out.println("b - Listar prefeitos eleitos");
    System.out.println("c - Listar vereadores eleitos");
    try{
      String opcao = br.readLine();
      opcao = opcao.toUpperCase();

      switch(opcao) {

        case "A": 
          // TRE opções
          this.etapa1TRE();
          break;
        case "B": 
          // TRE opções
          // Chamar método
          break;
        case "C": 
          // TRE opções
          // Chamar método
          break;
        default:
          this.etapa3TRE();
          break;

      }
    } catch(IOException e) {
      e.printStackTrace();
    }
    
  }
  
  /**
  * @public
  * Limpa o console usando código ANSI
  */
  public void limparConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

}
