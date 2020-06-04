package moduloTRE;

import java.io.IOException;

import arquivo.LerArquivo;
import arquivo.Lista;

public class Resultados {
		
	private static Lista linhasArquivos = new Lista();
	
	//Metodo responsavel por ler os dados dos resultados dos candidatos das urnas
	public static Resultado[] importarDadosCandidatos(String caminho) {

		try {
			linhasArquivos = LerArquivo.lerLinhasArquivo(caminho);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Resultado [] resultados = new Resultado[linhasArquivos.getTamanho()];
		
		for(int i=0; i < linhasArquivos.getTamanho(); i++) {
			
			String linha = (String) linhasArquivos.getObjeto(i);
			String vetorString[] = linha.split(";");
			
			resultados[i] = new Resultado (vetorString[0],Integer.valueOf(vetorString[1]));
		}
		
		return resultados;
	}
}
