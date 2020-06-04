package moduloTRE;

public class UrnaEletronica {
	
	//Atributos da Classe
	private String nomeMunicipioUrna;
	private int zonaEleitoralUrna;
	private int secaoEleitoralUrna;
	
	//Construtor da Classe
	public UrnaEletronica(String nomeMunicipioUrna, int zonaEleitoralUrna, int secaoEleitoralUrna) {
		this.nomeMunicipioUrna = nomeMunicipioUrna;
		this.zonaEleitoralUrna = zonaEleitoralUrna;
		this.secaoEleitoralUrna = secaoEleitoralUrna;
	}

	//Getters e Setters da Classe
	public String getNomeMunicipioUrna() {
		return nomeMunicipioUrna;
	}

	public void setNomeMunicipioUrna(String nomeMunicipioUrna) {
		this.nomeMunicipioUrna = nomeMunicipioUrna;
	}

	public int getZonaEleitoralUrna() {
		return zonaEleitoralUrna;
	}

	public void setZonaEleitoralUrna(int zonaEleitoralUrna) {
		this.zonaEleitoralUrna = zonaEleitoralUrna;
	}

	public int getSecaoEleitoralUrna() {
		return secaoEleitoralUrna;
	}

	public void setSecaoEleitoralUrna(int secaoEleitoralUrna) {
		this.secaoEleitoralUrna = secaoEleitoralUrna;
	}
}
