package moduloTRE;

import java.io.*;

import arquivo.CriarArquivo;
import arquivo.LerArquivo;

class MainTRE {


	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * @public
	 * Abre Menu de opções do modulo TRE
	 */
	public static void main(String [] args) {

		int opcaoNumero = 0;

		do {
			
			System.out.println("Escolha uma etapa: ");
			System.out.println("1 - Antes das eleições – Preparação");
			System.out.println("2 - Durante as eleições");
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
		
		//Inicializa a primeira etapa do TRE onde sao lidos os arquivos

		Eleitor [] eleitores = null;
		Candidato[] candidatos = null;
		Municipio [] municipios = null;
		PartidoPolitico [] partidos = null;
		UrnaEletronica [] urnas = null;

		String endereco, opcao = "";
		
		do {
			
			System.out.println("Escolha uma opção: ");
			System.out.println("a - Cadastro de partidos políticos");
			System.out.println("b - Cadastro de municípios");
			System.out.println("c - Cadastro dos candidatos a prefeito e vereador");
			System.out.println("d - Cadastro dos eleitores");
			System.out.println("e - Cadastro das urnas eletrônicas");
			System.out.println("f - Exportar dados para as urnas eletrônicas");
			System.out.println("z - Digite Z para voltar ao menu anterior");
	
			try {
	
				opcao = br.readLine();
				opcao = opcao.toUpperCase();
	
				try {
	
					switch(opcao) {
	
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
						exportarDados(eleitores,candidatos);
						break;
	
					}
					
				} catch (FileNotFoundException e) {
					System.out.println("Arquivo não encontrado - " + e.getLocalizedMessage());
				}
	
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("");
		
			
		// Faz repetir o menu ate uma escolha correta ser realizada
		}while(!opcao.equalsIgnoreCase("Z"));

	}
	
	public static void exportarDados(Eleitor[] eleitores, Candidato[] candidatos) {
		
		System.out.println("Informe o endereco em que o arquivo sera armazenado:");
		
		String enderecoPasta = "";
		
		try {
			
			enderecoPasta = br.readLine();
			
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		CriarArquivo.criarArquivoCandidato(enderecoPasta, candidatos);
		
		CriarArquivo.criarArquivoNumeroEleitores(enderecoPasta, eleitores);
	}

	/**
	 * @public
	 * Opções da terceira etapa do módulo TRE
	 */
	public static void etapa3TRE() {

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
				etapa1TRE();
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
				etapa3TRE();
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
