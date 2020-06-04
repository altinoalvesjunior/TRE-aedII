package arquivo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import moduloTRE.Candidato;
import moduloTRE.Eleitor;
import moduloTRE.Municipio;
import moduloTRE.PartidoPolitico;
import moduloTRE.Resultados;
import moduloTRE.UrnaEletronica;
import moduloUrna.TituloEleitor;

public class LerArquivo {

	/*
	 * Função para ler as linhas do arquivo
	 * @params {String} caminhoDoArquivo - caminho do arquivo
	 */
	public static Lista lerLinhasArquivo(String caminhoDoArquivo) throws IOException {

		/*Criação de uma nota lista em que receberá cada linha do arquivo em cada Célula*/
		Lista linhasArquivo = new Lista();
		String linha;

		BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo));

		while(br.ready()){

			linha = br.readLine();
			
			if(!linha.isBlank())
				linhasArquivo.adicionar(linha);

		}

		br.close();

		return linhasArquivo;
	} 

	// Cria um vetor de objetos a partir do arquivo ".txt" lido
	// Cada posicao do vetor possui um objeto do tipo do arquivo lido (ex.: municipio, partido politico, etc)
	//@params {String} caminho - caminho do arquivo; {Object} objeto - tipo do objeto que estah guardado no arquivo
	public static Object leituraDosDados(String caminho, Class<?> cls) throws IOException {


		Lista linhasArquivo = lerLinhasArquivo(caminho);

		if(cls.getName().equals(PartidoPolitico.class.getName())) {

			PartidoPolitico [] partidosPoliticos = new PartidoPolitico[linhasArquivo.getTamanho()];

			Celula aux = linhasArquivo.inicio;
			String linha = aux.objeto.toString();


			for(int i=0; i<linhasArquivo.getTamanho(); i++) {

				String vetorString[] = linha.split(";");
				partidosPoliticos[i] = new PartidoPolitico(vetorString[0],vetorString[1]);
				linha = aux.prox.objeto.toString();
			}
			return partidosPoliticos;
		}


		if(cls.getName().equals(Municipio.class.getName())) {

			Municipio [] municipios = new Municipio[linhasArquivo.getTamanho()];

			Celula aux = linhasArquivo.inicio;
			String linha = aux.objeto.toString();

			for(int i=0; i<linhasArquivo.getTamanho(); i++) {

				String vetorString[] = linha.split(";");
				municipios[i] = new Municipio (vetorString[0],vetorString[1], Integer.parseInt(vetorString[2]), Integer.parseInt(vetorString[3]));
				aux = aux.prox;

				if(aux!=null) {

					linha = aux.objeto.toString();
				}
			}
			return municipios;
		}


		if(cls.getName().equals(UrnaEletronica.class.getName())) {

			UrnaEletronica [] urna = new UrnaEletronica[linhasArquivo.getTamanho()];

			Celula aux = linhasArquivo.inicio;
			String linha = aux.objeto.toString();

			for(int i=0; i<linhasArquivo.getTamanho(); i++) {

				String vetorString[] = linha.split(";");
				urna[i] = new UrnaEletronica (vetorString[0], Integer.parseInt(vetorString[1]), Integer.parseInt(vetorString[2]));
				aux = aux.prox;

				if(aux!=null) {

					linha = aux.objeto.toString();

				}
			}

			return urna;

		}


		if(cls.getName().equals(Candidato.class.getName())) {

			Candidato [] candidatos = new Candidato[linhasArquivo.getTamanho()];

			Celula aux = linhasArquivo.inicio;
			String linha = aux.objeto.toString();

			for(int i=0; i<linhasArquivo.getTamanho(); i++) {

				String vetorString[] = linha.split(";");
				candidatos[i] = new Candidato(vetorString[0], Integer.parseInt(vetorString[1]), vetorString[2], vetorString[3], vetorString[4].charAt(0));
				aux = aux.prox;

				if(aux!=null) {

					linha = aux.objeto.toString();
				}
			}
			return candidatos;
		}


		if(cls.getName().equals(Eleitor.class.getName())) {

			Eleitor [] eleitores = new Eleitor[linhasArquivo.getTamanho()];

			Celula aux = linhasArquivo.inicio;
			String linha = aux.objeto.toString();

			for(int i=0; i<linhasArquivo.getTamanho(); i++) {

				String vetorString[] = linha.split(";");
				eleitores[i] = new Eleitor(vetorString[0], Integer.parseInt(vetorString[1]), vetorString[2], Integer.parseInt(vetorString[3]), Integer.parseInt(vetorString[4]));
				aux = aux.prox;

				if(aux!=null) {

					linha = aux.objeto.toString();
				}
			}
			return eleitores;
		}	
		
		if(cls.getName().equals(TituloEleitor.class.getName())) {

			TituloEleitor [] titulos = new TituloEleitor[linhasArquivo.getTamanho()];

			Celula aux = linhasArquivo.inicio;
			String linha = aux.objeto.toString();

			for(int i=0; i<linhasArquivo.getTamanho(); i++) {

				titulos[i] = new TituloEleitor(Integer.parseInt(linha));
				aux = aux.prox;

				if(aux!=null) {

					linha = aux.objeto.toString();
				}
			}
			return titulos;
		}
		
//		if(cls.getName().equals(Resultados.class.getName())) {
//
//			Resultados [] resultado = new Resultados[linhasArquivo.getTamanho()];
//
//			Celula aux = linhasArquivo.inicio;
//			String linha = aux.objeto.toString();
//
//
//			for(int i=0; i<linhasArquivo.getTamanho(); i++) {
//
//				String[] vetorString = linha.split(";");
//				resultado[i] = new Resultados(Integer.parseInt(vetorString[0]),Integer.parseInt(vetorString[1]));
//				linha = aux.prox.objeto.toString();
//			}
//			return resultado;
//		}
//		
		return null;

	}


}
