package moduloUrna;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import arquivo.CriarArquivo;
import arquivo.Lista;
import moduloTRE.Candidato;
import moduloTRE.Eleitor;
import moduloTRE.UrnaEletronica;

public class Urna {

	private UrnaEletronica urna;
	private Candidato [] candidatos;
	private TituloEleitor [] titulos;
	private Lista resultadoPrefeitos= new Lista();
	private Lista resultadoVereadores= new Lista();
	private Lista quemVotou = new Lista();
	private Lista quemJustificou = new Lista();

	public Urna(TituloEleitor[] titulos, Candidato[] candidatos, String municipio, int zona, int secao) {

		urna = new UrnaEletronica(municipio,zona,secao);
		this.candidatos= candidatos;
		this.titulos = titulos;
		System.out.println("Urna instalada com sucesso!");	
	}
	
	public void justificarVoto(int tituloEleitoral) {

		boolean existeEleitor = eleitorExiste(tituloEleitoral);

		if (existeEleitor == false) {
			
			boolean verificarJustificativa = verificarSeJustificou(tituloEleitoral);

			if (verificarJustificativa == true) {
				
				System.out.println("Eleitor já justificou o voto!");
				
			}else{	
				
				registroDeQuemJustificou(tituloEleitoral);
				System.out.print("\n Justificativa realizada com sucesso!");

			}
			
		}else {
			System.out.println("Eleitor cadastrado na urna! Não é possivel justificar. Realize o seu voto.");
		}
				
	}
	
	public void registroDeQuemJustificou(int tituloEleitoral) {
		quemJustificou.adicionar(tituloEleitoral);
	}

	private boolean verificarSeJustificou(int tituloEleitoral) {
		Object resultado = quemJustificou.buscarObjeto(tituloEleitoral);

		if (resultado != null)
			return true;
		else 
			return false;
	}

	// Realiza o processamento do voto, olhando dentro dos vetores.
	public void processarVotos(int tituloEleitoral) {

		Scanner sc = new Scanner (System.in);
		int pref = 0;

		System.out.println("Digite o numero do candidato para prefeito:");
		pref = sc.nextInt();

		for(int i=0; i<candidatos.length; i++) {

			if(candidatos[i].getNumeroCandidato()==pref) {
				resultadoPrefeitos.adicionar(candidatos[i]);
			}
		}


		System.out.println("Digite o numero do candidato para vereador:");
		int vere = 0;
		vere = sc.nextInt();
		for(int i=0; i<candidatos.length; i++) {

			if(candidatos[i].getNumeroCandidato()==vere) {
				resultadoVereadores.adicionar(candidatos[i]);
			}
		}	
		
		System.out.println("Votos computados!");
		registroDeQuemVotou (tituloEleitoral);

	}
	
	// Verifica se o eleitor existe na lista de titulos
	public boolean eleitorExiste(int tituloEleitoral) {

		for(int i = 0; i < titulos.length; i++) {

			if (titulos[i].getTitulo()==tituloEleitoral) {
				return true;
			}
		}

		return false;
	}
	// Registra na lista quem votou
	public void registroDeQuemVotou (int tituloEleitoral) {

		quemVotou.adicionar(tituloEleitoral);
	}
	
	// Verifica se o eleitor já votou
	public boolean eleitorVotou(int tituloEleitoral) {

		Object resultado = quemVotou.buscarObjeto(tituloEleitoral);

		if (resultado != null) {

			return true;

		}else {

			return false;
		}
	}
	
	//Contabiliza os votos de vereador e prefeito da urna
	public void contabilizarVotosPorCandidato(String endereco) {
		
		// Gera a lista de resultados da votacao a partir do numero de votos garantindo que haja a quantidade suficiente de votos
		Lista resultadoIndividualVereador = new Lista();
		Lista resultadoIndividualPrefeito = new Lista();
		
		int votosTotais = 0;
		
		for (int i = 0 ; i < resultadoPrefeitos.getTamanho() ; i++) {
				
			Candidato candidato = (Candidato) resultadoPrefeitos.getObjeto(i);
			
			Resultado resultado = (Resultado)resultadoIndividualPrefeito.buscarObjeto(String.valueOf(candidato.getNumeroCandidato()));
			
			if (resultado != null ) {
									
					resultado.adicionarVoto();
					votosTotais++;
										
			}else {
				
				resultado = new Resultado(String.valueOf(candidato.getNumeroCandidato()));
				resultado.adicionarVoto();
				resultadoIndividualPrefeito.adicionar(resultado);
			}
			
		}
		
		//Contabiliza os votos de vereador
		for (int i = 0 ; i < resultadoVereadores.getTamanho() ; i++) {
			
			Candidato candidato = (Candidato) resultadoVereadores.getObjeto(i);
			
			Resultado resultado = (Resultado)resultadoIndividualVereador.buscarObjeto(String.valueOf(candidato.getNumeroCandidato()));
			
			if (resultado != null ) {
									
					resultado.adicionarVoto();
					votosTotais++;
										
			}else {
				
				resultado = new Resultado(String.valueOf(candidato.getNumeroCandidato()));
				resultado.adicionarVoto();
				resultadoIndividualVereador.adicionar(resultado);
			}
			
		}
		
		CriarArquivo.criarArquivoResultadoCandidato(endereco, resultadoIndividualPrefeito);
		CriarArquivo.criarArquivoResultadoCandidato(endereco, resultadoIndividualVereador);

		
	}

	public void exportarResultados(String enderecoPasta) {
		
		//Criação de Subpasta
		File file = new File(enderecoPasta + "resultados");
		boolean sucesso = file.getParentFile().mkdirs();
		System.out.println("Subpasta criada com sucesso: " + sucesso);
						
		//Criar arquivo e salvar informacoes dos candidatos nele
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
			for (int i =0; i<candidatos.length; i++) {
				bw.write(String.valueOf(candidatos[i].getNomeCandidato()));
				bw.write(";");
				bw.write(String.valueOf(candidatos[i].getNumeroCandidato()));
				bw.write(";");
				bw.write(String.valueOf(candidatos[i].getNomeMunicipioCandidato()));
				bw.write(";");
				bw.write(String.valueOf(candidatos[i].getSiglaPartido()));
				bw.write(";");
				bw.write(String.valueOf(candidatos[i].getCargo()));
				bw.newLine();
			}
		}
		catch(IOException excecao) {
			excecao.printStackTrace();
		}
	}

}
