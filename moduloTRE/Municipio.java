package moduloTRE;


public class Municipio {
	
	//Atributos da Classe
	private String nomeMunicipio;
	private String estado;
	private int quantidadeHabitantes;
	private int numVagasVereador;
	
	//Construtor da Classe
	public Municipio(String nomeMunicipio, String estado, int quantidadeHabitantes, int numVagasVereador) {
		this.nomeMunicipio = nomeMunicipio;
		this.estado = estado;
		this.quantidadeHabitantes = quantidadeHabitantes;
		this.numVagasVereador = numVagasVereador;
	}
	
	//Getters e Setters da Classe
	public Municipio(String nomeMunicipio, String estado) {
		this.nomeMunicipio = nomeMunicipio;
		this.estado = estado;
	}

	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getQuantidadeHabitantes() {
		return quantidadeHabitantes;
	}

	public void setQuantidadeHabitantes(int quantidadeHabitantes) {
		this.quantidadeHabitantes = quantidadeHabitantes;
	}

	public int getNumVagasVereador() {
		return numVagasVereador;
	}

	public void setNumVagasVereador(int numVagasVereador) {
		this.numVagasVereador = numVagasVereador;
	}
}
