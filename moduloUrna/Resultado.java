package moduloUrna;

public class Resultado {
	
	private String idCandidato;
	private int resultado;
	
	public Resultado(String idCandidato) {
		this.idCandidato = idCandidato;
		this.resultado = 0;
	}
	
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
