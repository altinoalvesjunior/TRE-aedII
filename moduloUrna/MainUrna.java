package moduloUrna;

import java.io.*;
import java.util.Arrays;

import arquivo.CriarArquivo;
import arquivo.LerArquivo;
import moduloTRE.Candidato;
import moduloTRE.Eleitor;

class MainUrna {


	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Urna urna;
	/**
	 * @public
	 * Abre Menu de opções do modulo TRE
	 */
	public static void main(String [] args) {

		int opcaoNumero = 0;

		do {
			
			System.out.println("Escolha uma etapa: ");
			System.out.println("1 - Configurar Urna Eletronica");
			System.out.println("2 - Realizar Votacao");
			System.out.println("Digite o número da etapa ou -1 para sair: ");
			
			try {

				opcaoNumero = Integer.parseInt(br.readLine());

				switch( opcaoNumero ) {

				case 1: 
					// Abrir Etapa 1: Configurar Urna
					limparConsole();
					etapa1Urna();
					break;
				}

			} catch(IOException e) {
				e.printStackTrace();
			}
			
			System.out.println();

		}while(opcaoNumero != -1);
	
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
		
		String enderecoEleitores="", enderecoCandidatos="", municipio; 
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
//	
//	public static void exportarDados(Eleitor[] eleitores, Candidato[] candidatos, Municipio[] municipios, UrnaEletronica[] urnas, PartidoPolitico[] partidos) {
//		
//		if(eleitores == null || candidatos == null || municipios == null || urnas == null) {
//			
//			System.out.print("Nem todos os arquivos foram cadastrados! Retornando ao menu para cadastrar o restante.");
//		
//		}else {
//						
//			System.out.println("Informe o endereco em que o arquivo sera armazenado:");
//			
//			String enderecoPastaRaiz = "";
//			
//			try {
//				
//				enderecoPastaRaiz = br.readLine();
//				
//			} catch (IOException e) {
//		
//				e.printStackTrace();
//			}
//			
//			
//			// metodo percorre a lista de municipios para encontrar na lista de urna qual urna seja a desejada e depois verificando o candidato pertecente ao municipio
//			// em conjunto adiciona os eleitores que estao naquela secao
//			for (int j = 0 ; j < municipios.length ; j++) {
//			
//				for (int i = 0 ; i< urnas.length ; i++) {
//					
//					if (municipios[j].getNomeMunicipio().equalsIgnoreCase(urnas[i].getNomeMunicipioUrna())) {
//						
//						String enderecoCompleto = enderecoPastaRaiz.concat("/"+
//								urnas[i].getNomeMunicipioUrna()+
//								"/zona-"+urnas[i].getZonaEleitoralUrna()+
//								"/secao-"+ urnas[i].getSecaoEleitoralUrna());
//						
//						for (int f = 0 ; f < candidatos.length; f++) {
//							
//							if ( candidatos[f].getNomeMunicipioCandidato().equals(urnas[i].getNomeMunicipioUrna())) {
//								
//								Candidato [] candidatoUrna = new Candidato[1];
//								
//								candidatoUrna[0] = candidatos[f];
//								
//								CriarArquivo.criarArquivoCandidato(enderecoCompleto, candidatoUrna);
//							
//							}
//						}
//						
//						for(int f = 0 ; f < eleitores.length; f++) {
//							
//							if( eleitores[f].getSecaoEleitoral() == urnas[i].getSecaoEleitoralUrna()){
//								
//								Eleitor [] eleitorUrna = new Eleitor[1];
//								
//								eleitorUrna[0] = eleitores[f];
//								
//								CriarArquivo.criarArquivoNumeroEleitores(enderecoCompleto, eleitorUrna);
//								
//							}
//						}
//					}
//				}
//			}
//		}
//	}

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
