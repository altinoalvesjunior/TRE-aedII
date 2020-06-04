package moduloTRE;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import arquivo.CriarArquivo;
import arquivo.LerArquivo;
import arquivo.Lista;

public class MainTRE {


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

		//Inicializa a primeira etapa do TRE onde sao lidos os arquivos

		eleitores = null;
		candidatos = null;
		municipios = null;
		partidos = null;
		urnas = null;

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
						exportarDados(eleitores, candidatos, municipios, urnas, partidos);
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
	 * Listar prefeitos eleitos
	 */
	public static void listarPrefeitosEleitos() {

		int todosVotos = 0;
		
		try {
			Resultado primeiro = (Resultado) resultadoGeralPrefeitos.getObjeto(0);
			Resultado aux, segundo = new Resultado("",0);
			todosVotos = primeiro.getResultado();
			
			//descobre quem tem a quantidade maior de votos atraves de um auxiliar, comecando ja do segundo
			for (int i = 1 ; i < resultadoGeralPrefeitos.getTamanho() ; i++) {
				
				aux = (Resultado) resultadoGeralPrefeitos.getObjeto(i);
				
				todosVotos = todosVotos + aux.getResultado();
				
				if (primeiro.getResultado() < aux.getResultado()) {
					segundo = primeiro;
					primeiro = aux;
				}else {
					if(segundo.getResultado()<aux.getResultado()) {
						segundo = aux;
					}
				}
				
			}
			
			int eleitoresMunicipio = 0;
			
			//procura os municipios cujo candidato seja o mesmo para saber qual a quantidade de habitantes presente no municipio
			for (int i = 0 ; i < municipios.length ; i++) {
				for (int j = 0 ; j < candidatos.length ; j++) {
					if (primeiro.getIdCandidato().equals(String.valueOf(candidatos[j].getNumeroCandidato()))) {
						if (municipios[i].getNomeMunicipio().equals(candidatos[j].getNomeMunicipioCandidato())) {
							eleitoresMunicipio = municipios[i].getQuantidadeHabitantes();
							break;
						}
					}
				}
			}
			
			
			
			// verifica se a quantidade de eleitores do municipio for menor que 200000, se for nao precisa verificar a porcentagem
			if(eleitoresMunicipio < 200_000) {
				
				System.out.println("O prefeito, de numero " + primeiro.getIdCandidato() +  ", ganhou com: " + primeiro.getResultado() + " votos");
			
			}else {
				
				//calcula a porcentagem em int entre 0 e 100 convertendo de float para fazer a divisao corretamente
				int porcentagem = (int) (((float)primeiro.getResultado() / todosVotos) * 100);
				
				if (porcentagem > 50) {
					
					System.out.println("O prefeito, de numero " + primeiro.getIdCandidato() +  ", ganhou com: " + primeiro.getResultado() + " votos");
				
				}else {
					
					System.out.println("O segundo turno irá ser entre os candidatos de numero" + primeiro.getIdCandidato() + " e " + segundo.getIdCandidato());
				}
				
			}
		}catch(NullPointerException e) {
			System.out.println("Nao eh possivel calcular prefeito eleito!");
			System.out.println("Razao: Nenhum valor para prefeito foi computado. ");
			System.out.println("Nenhuma urna foi importada ou arquivos como candidatos e municipios nao foram carregados na etapa 1 do modulo do TRE.");

		}
		
	}
	
	
	/**
	 * @public
	 * Listar vereadores eleitos
	 */
	public static void listarVereadoresEleitos() {

		int todosVotos = 0;
		try {
			Resultado primeiro = (Resultado) resultadoGeralVereadores.getObjeto(0);
			Resultado aux, segundo = new Resultado("",0);
			todosVotos = primeiro.getResultado();
	
			//descobre quem tem a quantidade maior de votos atraves de um auxiliar, comecando ja do segundo
	
			for (int i = 1 ; i < resultadoGeralVereadores.getTamanho() ; i++) {
				
				aux = (Resultado) resultadoGeralVereadores.getObjeto(i);
				
				todosVotos = todosVotos + aux.getResultado();
				
				if (primeiro.getResultado() < aux.getResultado()) {
					segundo = primeiro;
					primeiro = aux;
				}else {
					if(segundo.getResultado()<aux.getResultado()) {
						segundo = aux;
					}
				}
				
			}
			
			int eleitoresMunicipio = 0;
			
			//procura os municipios cujo candidato seja o mesmo para saber qual a quantidade de habitantes presente no municipio
			for (int i = 0 ; i < municipios.length ; i++) {
				for (int j = 0 ; j < candidatos.length ; j++) {
					if (primeiro.getIdCandidato().equals(String.valueOf(candidatos[j].getNumeroCandidato()))) {
						if (municipios[i].getNomeMunicipio().equals(candidatos[j].getNomeMunicipioCandidato())) {
							eleitoresMunicipio = municipios[i].getQuantidadeHabitantes();
							break;
						}
					}
				}
			}
		
			
			// verifica se a quantidade de eleitores do municipio for menor que 200000, se for nao precisa verificar a porcentagem
			if(eleitoresMunicipio < 200_000) {
				
				System.out.println("O vereador, de numero " + primeiro.getIdCandidato() +  ", ganhou com: " + primeiro.getResultado() + " votos");
			
			}else {
				
				//calcula a porcentagem em int entre 0 e 100 convertendo de float para fazer a divisao corretamente
				int porcentagem = (int) (((float)primeiro.getResultado() / todosVotos) * 100);
			
				if (porcentagem > 50) {
					System.out.println("O vereador, de numero " + primeiro.getIdCandidato() +  ", ganhou com: " + primeiro.getResultado() + " votos");
				}else {
					System.out.println("O segundo turno irá ser entre os candidatos de numero" + primeiro.getIdCandidato() + " e " + segundo.getIdCandidato());
				}
				
			}
		}catch(NullPointerException e) {
			System.out.println("Nao eh possivel calcular prefeito eleito!");
			System.out.println("Razao 1: Nenhum valor para prefeito foi computado. ");
			System.out.println("Razao 2: Nenhuma urna foi importada ou arquivos como candidatos e municipios nao foram carregados na etapa 1 do modulo do TRE.");

		}
	}

	

	/**
	 * @public
	 * Opções da terceira etapa do módulo TRE
	 */
	public static void etapa3TRE() {
		
		String opcao = "";
		
		do {
			
			System.out.println("Escolha uma opção: ");
			System.out.println("a - Importar resultado de uma urna");
			System.out.println("b - Listar prefeitos eleitos");
			System.out.println("c - Listar vereadores eleitos");
			System.out.println("Z - PARA RETORNAR A ETAPA ANTERIOR");
			
			try{
				
				opcao = br.readLine();
				opcao = opcao.toUpperCase();
	
				switch(opcao) {
				
				// TRE opções modulo 3
				case "A": 
					System.out.println();
					etapaImportarResultados();
					break;
				
				case "B": 
					listarPrefeitosEleitos();
					break;
				
				case "C": 
					listarVereadoresEleitos();
					break;
				}
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}while(!opcao.equalsIgnoreCase("Z"));

	}

	
	private static void etapaImportarResultados() {

		System.out.println("Informe o endereço do arquivo da urna desejada");
		String caminho;
		Resultado [] resultados;

		try {

			caminho = br.readLine();
			resultados = Resultados.importarDadosCandidatos(caminho);

			for (int i = 0 ; i < resultados.length ; i++) {
				//busca se um resultado ja foi computado para esse candidado prefeito ou vereador
				Resultado resultadoPrefeito = (Resultado) resultadoGeralPrefeitos.buscarObjeto(resultados[i].getIdCandidato());
				Resultado resultadoVereador = (Resultado) resultadoGeralVereadores.buscarObjeto(resultados[i].getIdCandidato());
				// se algum deles for diferente de null quer dizer que já foi computado algum deles entao tem que somar mais votos novos
				if(resultadoPrefeito!=null || resultadoVereador!= null) {
					if (resultadoPrefeito!=null) {
						resultadoPrefeito.adicionarVoto(resultados[i].getResultado());
					}else {
						resultadoVereador.adicionarVoto(resultados[i].getResultado());
					}
				// caso nenhum seja null quer dizer que ainda esse candidato ainda nao foi computado e precisa ser adicionado no resultadoGeral
				}else {
					for (int j = 0 ; j < candidatos.length ; j++) {
						//descobre qual as informacoes do candidato ao encontrar o que tem o mesmo numero no vetor de candidatos
						// precisa pegar essa informacao para saber se o candidato seria vereador ou prefeito
						if (resultados[i].getIdCandidato().equals(String.valueOf(candidatos[j].getNumeroCandidato()))) {
							if(candidatos[j].getCargo()=='P') {
								resultadoGeralPrefeitos.adicionar(resultados[i]);
							}else {
								resultadoGeralVereadores.adicionar(resultados[i]);
							}	
							break;
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
