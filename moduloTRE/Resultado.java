package moduloTRE;

public class Resultado {
	
	//Atributos da Classe
	private String idCandidato;
	private int resultado;
	
	//Construtores da Classe
	public Resultado(String idCandidato) {
		this.idCandidato = idCandidato;
		this.resultado = 0;
	}
	
	public Resultado(String idCandidato, int resultado) {
		this.idCandidato = idCandidato;
		this.resultado = resultado;
	}
	
	//Getters e Setters
	public String getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(String idCandidato) {
		this.idCandidato = idCandidato;
	}
	
	public int getResultado() {
		return resultado;
	}
	
	public void adicionarVoto() {
		this.resultado++;
	}

}
