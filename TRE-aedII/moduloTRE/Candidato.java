package moduloTRE;

public class Candidato {
	//Atributos que compõe a classe
	private String nomeCandidato;
	private int numeroCandidato;
	private String nomeMunicipioCandidato;
	private String siglaPartido;
	private char cargo;
	
	//Construtor da Classe
	public Candidato(String nomeCandidato, int numeroCandidato, String nomeMunicipioCandidato, String siglaPartido,
			char cargo) {
		this.nomeCandidato = nomeCandidato;
		this.numeroCandidato = numeroCandidato;
		this.nomeMunicipioCandidato = nomeMunicipioCandidato;
		this.siglaPartido = siglaPartido;
		this.cargo = cargo;
	}

	//Getters e Setters da Classe
	public String getNomeCandidato() {
		return nomeCandidato;
	}

	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

	public int getNumeroCandidato() {
		return numeroCandidato;
	}

	public void setNumeroCandidato(int numeroCandidato) {
		this.numeroCandidato = numeroCandidato;
	}

	public String getNomeMunicipioCandidato() {
		return nomeMunicipioCandidato;
	}

	public void setNomeMunicipioCandidato(String nomeMunicipioCandidato) {
		this.nomeMunicipioCandidato = nomeMunicipioCandidato;
	}

	public String getSiglaPartido() {
		return siglaPartido;
	}

	public void setSiglaPartido(String siglaPartido) {
		this.siglaPartido = siglaPartido;
	}

	public char getCargo() {
		return cargo;
	}

	public void setCargo(char cargo) {
		this.cargo = cargo;
	}
}
