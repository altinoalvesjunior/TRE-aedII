package arquivo;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ArquivoTextoEscrita {

	BufferedWriter saida;
	
	public void abrirArquivo(String nomeArquivo) {
		
		try {
			saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nomeArquivo), "UTF-8"));
		}
		
		catch (FileNotFoundException excecao) {
			System.out.println("O arquivo não encontrado!");
		}
		
		catch (IOException excecao) {
			System.out.println("Erro na abertura do arquivo de escrita: " + excecao);
		}
	}
	
	public void fecharArquivo() {
		try {
			saida.close();
		}
		
		catch (IOException excecao) {
			System.out.println("Erro para fechar o Arquivo de Escrita: " + excecao);	
		}
	}
	
	public void escreverArquivo(String textoEntrada) {
		try {
			saida.write(textoEntrada);
			saida.newLine();
		}
		catch (IOException excecao){
			System.out.println("Erro: " + excecao);
		}
	}
}
