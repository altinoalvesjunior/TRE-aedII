package arquivo;

public class Lista{
	
	Celula inicio;
	
	//Metodo adicionar()
	//Possui a funcao de iniciar e adicionar elementos na lista
	//A lista serve para armazenar as linhas do arquivo para pesquisa e impressao
	public void adicionar(Object objeto) {
		
		Celula aux = inicio;
		
		if (aux==null) {
			
			inicio = new Celula(objeto);
			
			
		} else {
			
			while(aux.prox!=null) {
				
				aux = aux.prox;
			}

			aux.prox = new Celula(objeto);
			
		}
	}
	
	//Metodo toString()
	//Transforma o objeto armazenado na lista em string para impressao
	@Override
	public String toString() {
		
		String result = "";
		Celula aux = inicio;
		
		while(aux!=null) {
			
			result = result + aux.objeto.toString() + System.lineSeparator();
			
			aux = aux.prox;
		}
		
		return result;
	}
	
	
	//Metodo de busca de objetos dentro da lista e verificacao de existencia
	
	public Object buscarObjeto(Object objeto) {
		
		Celula aux = inicio;
		
		if(aux.objeto == objeto) {
			
			return aux.objeto;
			
		} else {
			
			aux = aux.prox;
		}
		
		return null;
	}
	
	public int getTamanho() {
		
		int i=0;
		Celula aux = inicio;
		
		//VERIFICAR SE IRA FUNCIONAR
		while(aux!=null) {
			
			i++;
			aux = aux.prox;
		}
		return i;
		
	}
	
	//Metodo para imprimir a lista inteira
	public void imprimirListaInteira() {
		
		System.out.println(toString());
	}
	
	
	

}
