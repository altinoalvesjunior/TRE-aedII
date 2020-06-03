package moduloTRE;

import arquivo.LerArquivo;

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
	
	public static Object importarDadosUrna(String caminho1, String caminho2, Class<?> cls, Class1<?> cls1) {
		Class = (Class[]) LerArquivo.leituraDosDados(caminho1, Class.class);
		prefeitos = (Prefeito[]) LerArquivo.leituraDosDados(caminho2, Prefeito.class);
	}
}
