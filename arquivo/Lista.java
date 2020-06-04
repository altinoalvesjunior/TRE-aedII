package arquivo;


import moduloTRE.Resultado;

//Motivo para utilização da lista: A inserção ou remoção de um elemento na 
//lista não implica a mudança de lugar de outros elementos; 
//Não é necessário definir, no momento da criação da lista, o número máximo 
//de elementos que esta poderá ter. Ou seja, é possível alocar memória "dinamicamente", 
//apenas para o número de nós necessários.

public class Lista {

	Celula inicio;

	// Metodo adicionar()
	// Possui a funcao de iniciar e adicionar elementos na lista
	// A lista serve para armazenar as linhas do arquivo para pesquisa e impressao
	
	// metodo de adicionar publico que chama o rescursivo privado
	public void adicionar (Object objeto) {
		Celula aux = inicio;
		if (aux == null) {

			inicio = new Celula(objeto);

		}else {
			adicionarRecursivo(aux, objeto);
		}
	}
	
	//metodo recursivo de insercao  que verifica se o proximo eh nulo e adiciona, caso contrario navega recursivamente com o proximo
	private void adicionarRecursivo(Celula aux, Object objeto) {

		if(aux.prox == null) {
			aux.prox = new Celula(objeto);
		}else{
			adicionarRecursivo(aux.prox,objeto);
		}
	}

	// Metodo toString()
	// Transforma o objeto armazenado na lista em string para impressao
	@Override
	public String toString() {

		String result = "";
		Celula aux = inicio;

		while (aux != null) {

			result = result + aux.objeto.toString() + System.lineSeparator();

			aux = aux.prox;
		}

		return result;
	}

	// Metodo de busca de objetos dentro da lista e verificacao de existencia

	public Object buscarObjeto(Object objeto) {

		Celula aux = inicio;

		if (aux == null) {
			return null;
		}

		do {

			if (aux.objeto.equals(objeto)) {

				return aux.objeto;

			} else {

				aux = aux.prox;
			}

		} while (aux != null);

		return null;

	}

	public Object buscarObjeto(String id) {

		Celula aux = inicio;

		if (aux == null) {
			return null;
		}

		do {
			Resultado atual = (Resultado) aux.objeto;
			if (id.equals(atual.getIdCandidato())) {

				return aux.objeto;

			} else {

				aux = aux.prox;
			}

		} while (aux != null);

		return null;

	}

	public int getTamanho() {

		int i = 0;
		Celula aux = inicio;

		// VERIFICAR SE IRA FUNCIONAR
		while (aux != null) {

			i++;
			aux = aux.prox;
		}
		return i;

	}

	// Metodo para imprimir a lista inteira
	public void imprimirListaInteira() {

		System.out.println(toString());
	}

	public Object getObjeto(int pos) {

		Celula aux = inicio;
		int i = 0;

		while (i < pos) {
			aux = aux.prox;
			i++;
		}
		return aux.objeto;
	}

}
