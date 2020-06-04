package moduloUrna;

import java.io.*;

import arquivo.LerArquivo;
import moduloTRE.Candidato;

class MainUrna {


	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Urna urna;
	private static String enderecoCandidatos = "";
	/**
	 * @public
	 * Abre Menu de opções do modulo TRE
	 */
	public static void main(String [] args) {

		int opcaoNumero = 0;

		do {
			
			System.out.println("URNA CONFIG - > Escolha uma etapa: ");
			System.out.println("1 - Configurar Urna Eletronica");
			System.out.println("2 - Ativar Função Realizar Votacao");
			System.out.println("3 - Ativar Função de Contabilizar Votacao");
			System.out.println("Digite o número da etapa ou -1 para sair: ");
			
			try {

				opcaoNumero = Integer.parseInt(br.readLine());

				switch( opcaoNumero ) {

				case 1: 
					// Abrir Etapa 1: Configurar Urna
					limparConsole();
					etapa1Urna();
					System.out.println();

					break;
					
				case 2: 
					// Abrir Etapa 2: Realizar Votacao na Urna
					limparConsole();
					etapa2Urna();
					System.out.println();

					break;	
				
				case 3: 
					// Abrir Etapa 3: Contabilizar votos
					limparConsole();
					etapa3Urna();
					System.out.println();

					break;
			}
				

			} catch(IOException e) {
				e.printStackTrace();
			}
			
			System.out.println();

		}while(opcaoNumero != -1);
	
	}
	
	//Responsavel por acionar etapa
	private static void etapa3Urna() {
		
		urna.contabilizarVotosPorCandidato(enderecoCandidatos);
		
	}
	
	//Responsavel por acionar etapa
	private static void etapa2Urna() {
		
		int opcaoNumero = 0;

		do {
			
			System.out.println();
			
			System.out.println("Votação");
			System.out.println("1 - Votar");
			System.out.println("2 - Justificar ausencia");
			System.out.println("Digite o número da etapa ou -1 para sair: ");
			
			try {
		
				opcaoNumero = Integer.parseInt(br.readLine());
		
				switch( opcaoNumero ) {
		
				case 1: 
					// Abrir Etapa 1: Configurar Urna
					limparConsole();
					realizarVotacao();
					break;
					
				case 2: 
					// Abrir Etapa 2: Realizar Votacao na Urna
					limparConsole();
					System.out.println("Insira o numero do seu titulo de eleitor");
					int tituloEleitor = Integer.parseInt(br.readLine());
					urna.justificarVoto(tituloEleitor);
					break;
				}
		
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			System.out.println();
		
		}while(opcaoNumero != -1);
	}

	private static void realizarVotacao() {
			
		try {
			
			System.out.println("Insira o numero do seu titulo de eleitor");
			int tituloEleitor = Integer.parseInt(br.readLine());
			
			if (urna.eleitorExiste(tituloEleitor)) {
				
				if(urna.eleitorVotou(tituloEleitor)) {
					
					System.out.println("Voto ja computado para esse eleitor. Não é possivel votar novamente.");
					
				}else {
					
					urna.processarVotos(tituloEleitor);
					
				}
			}else {
				System.out.println("Eleitor não cadastrado na urna!");
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
				
	}

	/**
	 * @throws IOException 
	 * @public
	 * Opções da primeira etapa do módulo da urna, configurar urna
	 */
	public static void etapa1Urna() throws IOException {
		
		//Inicializa a primeira etapa do modulo urna para configuracao

		Candidato[] candidatos = null;
		TituloEleitor [] titulos = null;
		
		String enderecoEleitores="", municipio; 
		int zona, secao;
		
		try{	
			
			System.out.println("Informe o municipio da urna");

			municipio = br.readLine();
			
			System.out.println("Informe a zona da urna");

			zona = Integer.parseInt(br.readLine());
			
			System.out.println("Informe a secao da urna");

			secao = Integer.parseInt(br.readLine());
			
			System.out.println("Informe o endereco do arquivo de titulos de eleitores dessa urna");

			enderecoEleitores = br.readLine();
			
			System.out.println("Informe o endereco do arquivo de candidatos dessa urna");

			enderecoCandidatos = br.readLine();
			
			candidatos = (Candidato[]) LerArquivo.leituraDosDados(enderecoCandidatos, Candidato.class);
			titulos = (TituloEleitor[]) LerArquivo.leituraDosDados(enderecoEleitores, TituloEleitor.class);

			urna = new Urna(titulos, candidatos, municipio, zona, secao);
						
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado - " + e.getLocalizedMessage());
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
