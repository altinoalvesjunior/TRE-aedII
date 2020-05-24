package moduloTRE;

public class PartidoPolitico {
	
	String nomePartido;
	String siglaPartido;
	
	public PartidoPolitico(String nomePartido, String siglaPartido) {
		this.nomePartido = nomePartido;
		this.siglaPartido = siglaPartido;
	}
	
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
