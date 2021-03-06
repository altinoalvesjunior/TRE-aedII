package moduloTRE;

public class Eleitor {

	//Atributos que compõe a classe
	private String nomeEleitor;
	private int tituloEleitor;
	private String municipioEleitoral;
	private int zonaEleitoral;
	private int secaoEleitoral;
	
	//Construtor da Classe
	public Eleitor(String nomeEleitor, int tituloEleitor, String municipioEleitoral, int zonaEleitoral,
			int secaoEleitoral) {
		this.nomeEleitor = nomeEleitor;
		this.tituloEleitor = tituloEleitor;
		this.municipioEleitoral = municipioEleitoral;
		this.zonaEleitoral = zonaEleitoral;
		this.secaoEleitoral = secaoEleitoral;
	}
	//commit
	//Getters e Setters da Classe
	public String getNomeEleitor() {
		return nomeEleitor;
	}
	
	public void setNomeEleitor(String nomeEleitor) {
		this.nomeEleitor = nomeEleitor;
	}
	
	public int getTituloEleitor() {
		return tituloEleitor;
	}
	
	public void setTituloEleitor(int tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}
	
	public String getMunicipioEleitoral() {
		return municipioEleitoral;
	}
	
	public void setMunicipioEleitoral(String municipioEleitoral) {
		this.municipioEleitoral = municipioEleitoral;
	}
	
	public int getZonaEleitoral() {
		return zonaEleitoral;
	}
	
	public void setZonaEleitoral(int zonaEleitoral) {
		this.zonaEleitoral = zonaEleitoral;
	}
	
	public int getSecaoEleitoral() {
		return secaoEleitoral;
	}
	
	public void setSecaoEleitoral(int secaoEleitoral) {
		this.secaoEleitoral = secaoEleitoral;
	}	
}
