package arquivo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import moduloTRE.Eleitor;
import moduloUrna.Resultado;
import moduloTRE.Candidato;

public class CriarArquivo{
	
	public static void criarArquivoNumeroEleitores(String enderecoPasta, Eleitor[] eleitores) {

		//Criação de Subpasta
		File file = new File(enderecoPasta + "/urna/eleitores.txt");
		boolean sucesso = file.getParentFile().mkdirs();
		System.out.println("Subpasta criada com sucesso: " + sucesso);
						
		//Criar arquivo e salva os titulos de eleitor da urna
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
			for (int i =0; i<eleitores.length; i++) {
				bw.write(String.valueOf(eleitores[i].getTituloEleitor()));
				bw.newLine();
			}
		}
		catch(IOException excecao) {
			excecao.printStackTrace();
		}
	}
	
	public static void criarArquivoCandidato(String enderecoPasta, Candidato[] candidatos) {

		//Criação de Subpasta
		File file = new File(enderecoPasta + "/urna/candidatos.txt");
		boolean sucesso = file.getParentFile().mkdirs();
		System.out.println("Subpasta criada com sucesso: " + sucesso);
						
		//Criar arquivo e salvar informacoes do candidato nele
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
			for (int i =0; i<candidatos.length; i++) {
				bw.write(String.valueOf(candidatos[i].getNomeCandidato()));
				bw.write(";");
				bw.write(String.valueOf(candidatos[i].getNumeroCandidato()));
				bw.write(";");
				bw.write(String.valueOf(candidatos[i].getNomeMunicipioCandidato()));
				bw.write(";");
				bw.write(String.valueOf(candidatos[i].getSiglaPartido()));
				bw.write(";");
				bw.write(String.valueOf(candidatos[i].getCargo()));
				bw.newLine();
			}
		}
		catch(IOException excecao) {
			excecao.printStackTrace();
		}
	}
	
	public static String criarArquivoResultadoCandidato(String enderecoPasta, Lista resultados) {

		String [] endereco = enderecoPasta.split("/");
		
		enderecoPasta = enderecoPasta.replace(endereco[endereco.length-1], "");
		
		//Criação de Subpasta
		File file = new File(enderecoPasta + "resultado.txt");
		boolean sucesso = file.getParentFile().mkdirs();
		System.out.println("Subpasta criada com sucesso: " + sucesso);
						
		//Criar arquivo e salvar informacoes do candidato nele
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
			for (int i =0; i<resultados.getTamanho(); i++) {
				Resultado resultado = (Resultado)resultados.getObjeto(i);
				bw.write(String.valueOf((resultado.getIdCandidato())));
				bw.write(";");
				bw.write(String.valueOf((resultado.getResultado())));
				bw.newLine();
			}
		}
		catch(IOException excecao) {
			excecao.printStackTrace();
		}
		try {
			return file.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String criarArquivoInformacoes(String enderecoPasta, int votosTotais, int justificados) throws IOException {

		String [] endereco = enderecoPasta.split("/");
		
		enderecoPasta = enderecoPasta.replace(endereco[endereco.length-1], "");
		
		//Criação de Subpasta
		File file = new File(enderecoPasta + "informacoes.txt");
		boolean sucesso = file.getParentFile().mkdirs();
		System.out.println("Subpasta criada com sucesso: " + sucesso);
						
		//Criar arquivo e salvar informacoes do candidato nele
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
			bw.write("votosTotais;"+String.valueOf(votosTotais));
			bw.newLine();
			bw.write("votosJustificados;"+String.valueOf(justificados));
		}
		catch(IOException excecao) {
			excecao.printStackTrace();
		}
		return file.getCanonicalPath();
	}
	
	
	/*public static void criarArquivo(String enderecoPasta, String nomeArquivo, Objeto[] objetos) {

		//Criação de Subpasta
		File file = new File(enderecoPasta + nomeArquivo);
		boolean sucesso = file.getParentFile().mkdirs();
		System.out.println("Subpasta criada com sucesso: " + sucesso);
						
		//Criar arquivo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
			for (int i =0; i<objetos.length; i++) {
				bw.write(dados[i]+";");
				bw.newLine();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}*/
	
	

	
}