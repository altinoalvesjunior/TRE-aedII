
public class Candidatos {
	
	String nomeCandidato;
	int numeroCandidato;
	String nomeMunicipioCandidato;
	int siglaPartido;
	char cargo;
	
	public Candidatos(String nomeCandidato, int numeroCandidato, String nomeMunicipioCandidato, int siglaPartido,
			char cargo) {
		this.nomeCandidato = nomeCandidato;
		this.numeroCandidato = numeroCandidato;
		this.nomeMunicipioCandidato = nomeMunicipioCandidato;
		this.siglaPartido = siglaPartido;
		this.cargo = cargo;
	}

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

	public int getSiglaPartido() {
		return siglaPartido;
	}

	public void setSiglaPartido(int siglaPartido) {
		this.siglaPartido = siglaPartido;
	}

	public char getCargo() {
		return cargo;
	}

	public void setCargo(char cargo) {
		this.cargo = cargo;
	}
}
