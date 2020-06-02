package moduloTRE;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {

	 /*
	  * Função para ler as linhas do arquivo
	  * @params {String} caminhoDoArquivo - caminho do arquivo
	  */
		public static Lista lerLinhasArquivo(String caminhoDoArquivo) {
			
			Lista linhasArquivo = new Lista();
			String linha;
			
		    try{
			
					BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo));
					
					while(br.ready()){
						
						linha = br.readLine();
						
						linhasArquivo.adicionar(linha);
						
					}
					
					br.close();
					
				}catch(IOException ioe){
					ioe.printStackTrace();
				} 
		    
		    return linhasArquivo;
		  } 
	
// Cria um vetor de objetos a partir do arquivo ".txt" lido
// Cada posicao do vetor possui um objeto do tipo do arquivo lido (ex.: municipio, partido politico, etc)
//@params {String} caminho - caminho do arquivo; {Object} objeto - tipo do objeto que estah guardado no arquivo
		
		
	public static Object leituraDosDados(String caminho, Object objeto) {
		
		Lista linhasArquivo = lerLinhasArquivo(caminho);
		
		if(objeto instanceof PartidoPolitico) {
			
			PartidoPolitico [] partidosPoliticos = new PartidoPolitico[linhasArquivo.getTamanho()];
		
			Celula aux = linhasArquivo.inicio;
			String linha = aux.objeto.toString();
	
			
			for(int i=0; i<linhasArquivo.getTamanho(); i++) {
				
				String vetorString[] = linha.split(";");
				partidosPoliticos[i] = new PartidoPolitico(vetorString[0],vetorString[1]);
				linha = aux.prox.objeto.toString();
			}
		}
	
	
		if(objeto instanceof Municipio) {
		
			Municipio [] municipios = new Municipio[linhasArquivo.getTamanho()];
			
			Celula aux = linhasArquivo.inicio;
			String linha = aux.objeto.toString();
			
			for(int i=0; i<linhasArquivo.getTamanho(); i++) {
				
				String vetorString[] = linha.split(";");
				municipios[i] = new Municipio (vetorString[0],vetorString[1], Integer.parseInt(vetorString[2]), Integer.parseInt(vetorString[3]));
				aux = aux.prox;
				if(aux!=null) {
				linha = aux.objeto.toString();}
			
	
			}
			
			for (int i =0; i<linhasArquivo.getTamanho(); i++) {
				System.out.println(municipios[i].nomeMunicipio + municipios[i].estado + municipios[i].quantidadeHabitantes + municipios[i].numVagasVereador);
			}
			System.out.println();

		}
		
		
		if(objeto instanceof UrnaEletronica) {
			
			UrnaEletronica [] urna = new UrnaEletronica[linhasArquivo.getTamanho()];
			
			Celula aux = linhasArquivo.inicio;
			String linha = aux.objeto.toString();
			
			for(int i=0; i<linhasArquivo.getTamanho(); i++) {
				
				String vetorString[] = linha.split(";");
				urna[i] = new UrnaEletronica (vetorString[0], Integer.parseInt(vetorString[1]), Integer.parseInt(vetorString[2]));
				aux = aux.prox;
				if(aux!=null) {
				linha = aux.objeto.toString();}
			
	
			}


		}
		
		
		if(objeto instanceof Candidato) {
			
			Candidato [] candidatos = new Candidato[linhasArquivo.getTamanho()];
			
			Celula aux = linhasArquivo.inicio;
			String linha = aux.objeto.toString();
			
			for(int i=0; i<linhasArquivo.getTamanho(); i++) {
				
				String vetorString[] = linha.split(";");
				candidatos[i] = new Candidato(vetorString[0], Integer.parseInt(vetorString[1]), vetorString[2], vetorString[3], vetorString[4].charAt(0));
				aux = aux.prox;
				if(aux!=null) {
				linha = aux.objeto.toString();}
			
	
			}
		}
		
		
		if(objeto instanceof Eleitor) {
			
			Eleitor [] eleitores = new Eleitor[linhasArquivo.getTamanho()];
			
			Celula aux = linhasArquivo.inicio;
			String linha = aux.objeto.toString();
			
			for(int i=0; i<linhasArquivo.getTamanho(); i++) {
				
				String vetorString[] = linha.split(";");
				eleitores[i] = new Eleitor(vetorString[0], Integer.parseInt(vetorString[1]), vetorString[2], Integer.parseInt(vetorString[3]), Integer.parseInt(vetorString[4]));
				aux = aux.prox;
				if(aux!=null) {
				linha = aux.objeto.toString();}
			
	
			}
			
			for (int i =0; i<linhasArquivo.getTamanho(); i++) {
				
				System.out.println(eleitores[i].nomeEleitor 
						+ " "+ eleitores[i].tituloEleitor
						+ " "+ eleitores[i].municipioEleitoral
						+ " "+ eleitores[i].secaoEleitoral
						+ " "+ eleitores[i].zonaEleitoral);
			}
			System.out.println();

			
		}	
		return null;
		
	}
	

}
