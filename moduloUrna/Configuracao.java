package moduloUrna;
import moduloTRE.UrnaEletronica;

public class Configuracao {
	
	UrnaEletronica nomeMunicipioUrna;
	UrnaEletronica zonaEleitoralUrna;
	UrnaEletronica secaoEleitoralUrna;
	
	public Configuracao(UrnaEletronica nomeMunicipioUrna, UrnaEletronica zonaEleitoralUrna,
			UrnaEletronica secaoEleitoralUrna) {
		this.nomeMunicipioUrna = nomeMunicipioUrna;
		this.zonaEleitoralUrna = zonaEleitoralUrna;
		this.secaoEleitoralUrna = secaoEleitoralUrna;
	}

	public UrnaEletronica getNomeMunicipioUrna() {
		return nomeMunicipioUrna;
	}

	public void setNomeMunicipioUrna(UrnaEletronica nomeMunicipioUrna) {
		this.nomeMunicipioUrna = nomeMunicipioUrna;
	}

	public UrnaEletronica getZonaEleitoralUrna() {
		return zonaEleitoralUrna;
	}

	public void setZonaEleitoralUrna(UrnaEletronica zonaEleitoralUrna) {
		this.zonaEleitoralUrna = zonaEleitoralUrna;
	}

	public UrnaEletronica getSecaoEleitoralUrna() {
		return secaoEleitoralUrna;
	}

	public void setSecaoEleitoralUrna(UrnaEletronica secaoEleitoralUrna) {
		this.secaoEleitoralUrna = secaoEleitoralUrna;
	}
	
	
}
