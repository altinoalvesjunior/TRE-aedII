package moduloTRE;

import arquivo.LerArquivo;
import arquivo.Lista;

public class Resultados {
	
	int numeroCandidato;
	int quantidadeVotos;
	
	public Resultados(int numeroCandidato, int quantidadeVotos) {
		this.numeroCandidato = numeroCandidato;
		this.quantidadeVotos = quantidadeVotos;
	}

	public int getNumeroCandidato() {
		return numeroCandidato;
	}
	
	public void setNumeroCandidato(int numeroCandidato) {
		this.numeroCandidato = numeroCandidato;
	}
	
	public int getQuantidadeVotos() {
		return quantidadeVotos;
	}
	
	public void setQuantidadeVotos(int quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}
	
	String [] vereadores;
	static Lista linhasArquivos = new Lista();
	
	public static int importarDadosCandidatos(String caminho) {

		linhasArquivos = LerArquivo.lerLinhasArquivo(caminho);
		String [] candidatos = new String[linhasArquivos.getTamanho()];
		Celula aux = linhasArquivos.inicio;
		String linha = aux.objeto.toString();

		for(int i=0; i < linhasArquivos.getTamanho(); i++) {

			String vetorString[] = linha.split(";");
			candidatos[i] = new String (vetorString[0] + ":" +vetorString[1]);
			linha = aux.prox.objeto.toString();
		}
		return candidatos;
	}
}
