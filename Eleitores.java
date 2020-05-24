
public class Eleitores {
	
	String nomeEleitor;
	int tituloEleitora;
	String municipioEleitoral;
	int zonaEleitoral;
	int secaoEleitoral;
	
	public Eleitores(String nomeEleitor, int tituloEleitora, String municipioEleitoral, int zonaEleitoral,
			int secaoEleitoral) {
		this.nomeEleitor = nomeEleitor;
		this.tituloEleitora = tituloEleitora;
		this.municipioEleitoral = municipioEleitoral;
		this.zonaEleitoral = zonaEleitoral;
		this.secaoEleitoral = secaoEleitoral;
	}

	public String getNomeEleitor() {
		return nomeEleitor;
	}

	public void setNomeEleitor(String nomeEleitor) {
		this.nomeEleitor = nomeEleitor;
	}

	public int getTituloEleitora() {
		return tituloEleitora;
	}

	public void setTituloEleitora(int tituloEleitora) {
		this.tituloEleitora = tituloEleitora;
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
