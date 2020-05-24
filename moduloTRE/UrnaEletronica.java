package moduloTRE;

public class UrnaEletronica {
	String nomeMunicipioUrna;
	int zonaEleitoralUrna;
	int secaoEleitoralUrna;
	
	public UrnaEletronica(String nomeMunicipioUrna, int zonaEleitoralUrna, int secaoEleitoralUrna) {
		this.nomeMunicipioUrna = nomeMunicipioUrna;
		this.zonaEleitoralUrna = zonaEleitoralUrna;
		this.secaoEleitoralUrna = secaoEleitoralUrna;
	}

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
