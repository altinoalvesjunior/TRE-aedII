package moduloTRE;

import java.io.*;

import arquivo.CriarArquivo;
import arquivo.LerArquivo;
import arquivo.Lista;

class MainTRE {
	
	/*Método principal (main) para teste de todos os métodos do módulo TRE*/
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static Eleitor [] eleitores;
	private static Candidato[] candidatos;
	private static Municipio [] municipios;
	private static PartidoPolitico [] partidos;
	private static UrnaEletronica [] urnas;
	private static Lista resultadoGeralPrefeitos = new Lista();
	private static Lista resultadoGeralVereadores = new Lista();

	/**
	 * @public
	 * Abre Menu de opções do modulo TRE
	 */
	public static void main(String [] args) {

		int opcaoNumero = 0;

		do {
			
			System.out.println("Escolha uma etapa: ");
			System.out.println("1 - Antes das eleições – Preparação");
			System.out.println("3 - Depois das eleições – Divulgação dos resultados");
			System.out.println("Digite o número da etapa ou -1 para sair: ");
			
			try {

				opcaoNumero = Integer.parseInt(br.readLine());

				switch( opcaoNumero ) {

				case 1: 
					// Abrir Etapa 1: Antes das eleições – Preparação
					limparConsole();
					etapa1TRE();
					break;

				case 2: 
					// Abrir Etapa 2: Durante as eleições
					//this.etapa2();
					break;

				case 3: 
					// Abrir Etapa 3: Antes das eleições – Preparação
					limparConsole();
					etapa3TRE();
					break;

				}

			} catch(IOException e) {
				e.printStackTrace();
			}
			
			System.out.println();

		}while(opcaoNumero != -1);
	
	}

	/**
	 * @public
	 * Opções da primeira etapa do módulo TRE
	 */
	public static void etapa1TRE() {
		
		//Nessa etapa é realizada a configuração da urna, onde são inserido dados
		// como município, zona e seção. São importados documentos que possuem os dados
		// dos eleitores e candidatos de acordo com os dados inseridos.
		
		//Inicializa a primeira etapa do TRE onde sao lidos os arquivos
		eleitores = null;
		candidatos = null;
		municipios = null;
		partidos = null;
		urnas = null;

		String endereco, opcao = "";
		
		do {
			//Método para cadastros em que é recebido um arquivo txt, no qual é lido e salvo em uma lista.
			System.out.println("Escolha uma opção: ");
			System.out.println("a - Cadastro de partidos políticos");
			System.out.println("b - Cadastro de municípios");
			System.out.println("c - Cadastro dos candidatos a prefeito e vereador");
			System.out.println("d - Cadastro dos eleitores");
			System.out.println("e - Cadastro das urnas eletrônicas");
			System.out.println("f - Exportar dados para as urnas eletrônicas"); // Método para exportação de dados das urnas
			System.out.println("z - Digite Z para voltar ao menu anterior");
	
			try {
	
				opcao = br.readLine();
				opcao = opcao.toUpperCase();
	
				try {
	
					switch(opcao) {
					//Nesses cases o usuário informa o endereço de onde está o arquivo, o mesmo é lido e criado um vetor através da leitura dos dados do arquivo txt.
					
					case "A": 
						// TRE opções 
						System.out.println("Informe o endereço do arquivo");
						endereco = br.readLine();
						partidos = (PartidoPolitico[]) LerArquivo.leituraDosDados(endereco, PartidoPolitico.class);
						break;
					
					case "B": 
						// TRE opções
						System.out.println("Informe o endereço do arquivo");
						endereco = br.readLine();
						municipios = (Municipio[]) LerArquivo.leituraDosDados(endereco, Municipio.class);
						break;
					
					case "C": 
						// TRE opções
						System.out.println("Informe o endereço do arquivo");
						endereco = br.readLine();
						candidatos = (Candidato[]) LerArquivo.leituraDosDados(endereco, Candidato.class);
						break;
					
					case "D": 
						// TRE opções
						System.out.println("Informe o endereço do arquivo");
						endereco = br.readLine();
						eleitores = (Eleitor[]) LerArquivo.leituraDosDados(endereco, Eleitor.class);
						break;
					
					case "E": 
						// TRE opções
						System.out.println("Informe o endereço do arquivo");
						endereco = br.readLine();
						urnas = (UrnaEletronica[]) LerArquivo.leituraDosDados(endereco, UrnaEletronica.class);
						break;
					
					case "F": 
						// TRE opções
						exportarDados(eleitores, candidatos, municipios, urnas, partidos);
						break;
	
					}
					
				} catch (FileNotFoundException e) {
					System.out.println("Arquivo não encontrado - " + e.getLocalizedMessage()); //Mensagem de erro exibida caso o arquivo não seja encontrado.
				}
	
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("");
		
			
		// Faz repetir o menu ate uma escolha correta ser realizada
		}while(!opcao.equalsIgnoreCase("Z"));

	}
	
	// Método para exportação dos dados, recebendo vetores de objetos.
	public static void exportarDados(Eleitor[] eleitores, Candidato[] candidatos, Municipio[] municipios, UrnaEletronica[] urnas, PartidoPolitico[] partidos) {
		
		if(eleitores == null || candidatos == null || municipios == null || urnas == null) {
			
			System.out.print("Nem todos os arquivos foram cadastrados! Retornando ao menu para cadastrar o restante.");
		
		}else {
						
			System.out.println("Informe o endereco em que o arquivo sera armazenado:");
			
			String enderecoPastaRaiz = "";
			
			try {
				
				enderecoPastaRaiz = br.readLine();
				
			} catch (IOException e) {
		
				e.printStackTrace();
			}
			
			
			// metodo percorre a lista de municipios para encontrar na lista de urna qual urna seja a desejada e depois verificando o candidato pertecente ao municipio
			// em conjunto adiciona os eleitores que estao naquela secao
			for (int j = 0 ; j < municipios.length ; j++) {
			
				for (int i = 0 ; i< urnas.length ; i++) {
					
					if (municipios[j].getNomeMunicipio().equalsIgnoreCase(urnas[i].getNomeMunicipioUrna())) {
						
						String enderecoCompleto = enderecoPastaRaiz.concat("/"+
								urnas[i].getNomeMunicipioUrna()+
								"/zona-"+urnas[i].getZonaEleitoralUrna()+
								"/secao-"+ urnas[i].getSecaoEleitoralUrna());
						
						for (int f = 0 ; f < candidatos.length; f++) {
							
							if ( candidatos[f].getNomeMunicipioCandidato().equals(urnas[i].getNomeMunicipioUrna())) {
								
								Candidato [] candidatoUrna = new Candidato[1];
								
								candidatoUrna[0] = candidatos[f];
								
								CriarArquivo.criarArquivoCandidato(enderecoCompleto, candidatoUrna);
							
							}
						}
						
						for(int f = 0 ; f < eleitores.length; f++) {
							
							if( eleitores[f].getSecaoEleitoral() == urnas[i].getSecaoEleitoralUrna()){
								
								Eleitor [] eleitorUrna = new Eleitor[1];
								
								eleitorUrna[0] = eleitores[f];
								
								CriarArquivo.criarArquivoNumeroEleitores(enderecoCompleto, eleitorUrna);
								
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * @public
	 * Retornar prefeitos eleitos
	 */
//	public static void listarPrefeitosEleitos() {
//		ListaCandidatos lista = new Resultados().importarDadosCandidatos();
//		int todosVotos = 0;
//		int primeiro = 0;
//		int segundo = 0;
//		
//		 for (String s : lista) {
//		      String[] wrapper = s.split(";");
//		      int num = Integer.parseInt(wrapper[0]);
//		      int votos = Integer.parseInt(wrapper[1]);
//		      
//		      if(primeiro > votos) {
//		    	  primeiro = votos;
//		      }
//		      if(segundo > votos && segundo < votos) {
//		    	  segundo = votos;
//		      }
//		}
//		int porcentagem = (primeiro / segundo) * 100;
//		 
//		if(porcentagem > 50) {
//			System.out.println("O primeiro prefeito ganhou com: " + primeiro + "votos");
//			
//		}  else {
//			System.out.println("O segundo turno irá ser entre...");
//		}
//	}

	/**
	 * @public
	 * Opções da terceira etapa do módulo TRE
	 */
	public static void etapa3TRE() {
		// Etapa 3 em que é permitido a importação dos resultados que são gerados
		// em um txt e são lidos nesse módulo, além de listar os prefeitos eleitos
		//ou no segundo turno e os vereadores eleitos em cada município.
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
				System.out.println();
				etapaImportarResultados();
				break;
			case "B": 
				// Chamar método
				break;
			case "C": 
				// TRE opções
				// Chamar método
				break;
			default:
				etapa3TRE();
				break;

			}
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

	//Importação dos Resultados
	private static void etapaImportarResultados() {
		
		System.out.println("Informe o endereço do arquivo da urna desejada");
		String caminho;
		Resultado [] resultados;
		Lista listaResultados = new Lista();
		
		try {
			
			caminho = br.readLine();
			resultados = Resultados.importarDadosCandidatos(caminho);
			
			for (int i = 0 ; i < resultados.length ; i++) {
				listaResultados.adicionar(resultados[i]);
			}
			
			for (int i = 0 ; i < listaResultados.getTamanho() ; i++) {
				
				Resultado resultado = (Resultado)listaResultados.getObjeto(i);
				
				for (int j = 0 ; j < candidatos.length ; j++) {
					
					if (resultado.getIdCandidato().equals(String.valueOf(candidatos[j].getNumeroCandidato()))) {
						
						if ( candidatos[j].getCargo() == 'P') {
							
							Resultado geral = (Resultado)resultadoGeralPrefeitos.buscarObjeto(resultado.getIdCandidato());
							
							if (geral != null) {
								
								geral = new Resultado(geral.getIdCandidato(), geral.getResultado() + resultado.getResultado());
								
							}else {
								resultadoGeralPrefeitos.adicionar(resultado);
							}
							
						}else {
							
							Resultado geral = (Resultado)resultadoGeralVereadores.buscarObjeto(resultado.getIdCandidato());
							
							if (geral != null) {
								
								geral = new Resultado(geral.getIdCandidato(), geral.getResultado() + resultado.getResultado());
								
							}else {
								resultadoGeralVereadores.adicionar(resultado);
							}
							
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @public
	 * Limpa o console usando código ANSI
	 */
	public static void limparConsole() {
		try
		{
			final String os = System.getProperty("os.name");

			if (os.contains("Windows"))
			{
				Runtime.getRuntime().exec("cls");
			}
			else
			{
				Runtime.getRuntime().exec("clear");
			}
		}
		catch (final Exception e){}
	}

}
