package moduloTRE;

public class PartidoPolitico {
	
	//Atributos da Classe
	private String nomePartido;
	private String siglaPartido;
	
	//Construtor da Classe
	public PartidoPolitico(String nomePartido, String siglaPartido) {
		this.nomePartido = nomePartido;
		this.siglaPartido = siglaPartido;
	}
	
	//Getters e Setters
	public String getNomePartido() {
		return nomePartido;
	}
	
	public void setNomePartido(String nomePartido) {
		this.nomePartido = nomePartido;
	}
	
	public String getSiglaPartido() {
		return siglaPartido;
	}
	
	public void setSiglaPartido(String siglaPartido) {
		this.siglaPartido = siglaPartido;
	}
}
