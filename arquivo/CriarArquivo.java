package arquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import moduloTRE.Eleitor;
import moduloUrna.Resultado;
import moduloTRE.Candidato;

public class CriarArquivo {

	/*
	 * métodos responsáveis para exportação dos dados para urna. Um arquivo contém
	 * os números dos títulos eleitorais dos eleitores que votarão na seção
	 * eleitoral relacionada à urna; e outro arquivo texto contendo todas as
	 * informações dos candidatos a prefeito e vereador do município onde a urna
	 * será utilizada. Primeiramente, criando uma subpasta para saída dos arquivos,
	 * e em seguida função para escrever no arquivo seguindo padrão.
	 */

	public static void criarArquivoNumeroEleitores(String enderecoPasta, Eleitor[] eleitores) {

		// Criação de Subpasta recebendo o endereço da Pasta como parametro, asssim
		// criando um arquivo txt dentro da mesma
		File file = new File(enderecoPasta + "/urna/eleitores.txt");
		boolean sucesso = file.getParentFile().mkdirs();
		System.out.println("Subpasta criada com sucesso: " + sucesso);

		// Recebe o arquivo criado anteriormente mente e realiza a escrita no mesmo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			for (int i = 0; i < eleitores.length; i++) {
				bw.write(String.valueOf(eleitores[i].getTituloEleitor()));
				bw.newLine();
			}
		} catch (IOException excecao) {
			excecao.printStackTrace();
		}
	}

	public static void criarArquivoCandidato(String enderecoPasta, Candidato[] candidatos) {

		// Criação da subpasta e arquivo
		File file = new File(enderecoPasta + "/urna/candidatos.txt");
		boolean sucesso = file.getParentFile().mkdirs();
		System.out.println("Subpasta criada com sucesso: " + sucesso);

		// Recebe o arquivo criado anteriormente mente e realiza a escrita no mesmo com
		// as informações seguindo o padrão (dados seprados por ponto e vírgula)
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			for (int i = 0; i < candidatos.length; i++) {
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
		} catch (IOException excecao) {
			excecao.printStackTrace();
		}
	}

	//Método para criação do Arquivo e escrita do Resultados dos candidatos seguindo os padrões anteriores
	public static String criarArquivoResultadoCandidato(String enderecoPasta, Lista resultados) {

		String[] endereco = enderecoPasta.split("/");

		enderecoPasta = enderecoPasta.replace(endereco[endereco.length - 1], "");

		// Criação da subpasta e arquivo
		File file = new File(enderecoPasta + "resultado.txt");
		boolean sucesso = file.getParentFile().mkdirs();
		System.out.println("Subpasta criada com sucesso: " + sucesso);

		// escrita
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			for (int i = 0; i < resultados.getTamanho(); i++) {
				Resultado resultado = (Resultado) resultados.getObjeto(i);
				bw.write(String.valueOf((resultado.getIdCandidato())));
				bw.write(";");
				bw.write(String.valueOf((resultado.getResultado())));
				bw.newLine();
			}
		} catch (IOException excecao) {
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

	public static String criarArquivoInformacoes(String enderecoPasta, int votosTotais, int justificados)
			throws IOException {

		String[] endereco = enderecoPasta.split("/");

		enderecoPasta = enderecoPasta.replace(endereco[endereco.length - 1], "");

		// Criação da subpasta e arquivo
		File file = new File(enderecoPasta + "informacoes.txt");
		boolean sucesso = file.getParentFile().mkdirs();
		System.out.println("Subpasta criada com sucesso: " + sucesso);

		// escrita
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			bw.write("votosTotais;" + String.valueOf(votosTotais));
			bw.newLine();
			bw.write("votosJustificados;" + String.valueOf(justificados));
		} catch (IOException excecao) {
			excecao.printStackTrace();
		}
		return file.getCanonicalPath();
	}

	/*
	 * public static void criarArquivo(String enderecoPasta, String nomeArquivo,
	 * Objeto[] objetos) {
	 * 
	 * //Criação de Subpasta File file = new File(enderecoPasta + nomeArquivo);
	 * boolean sucesso = file.getParentFile().mkdirs();
	 * System.out.println("Subpasta criada com sucesso: " + sucesso);
	 * 
	 * //Criar arquivo try (BufferedWriter bw = new BufferedWriter(new
	 * FileWriter(file, true))){ for (int i =0; i<objetos.length; i++) {
	 * bw.write(dados[i]+";"); bw.newLine(); } } catch(IOException e) {
	 * e.printStackTrace(); } }
	 */

}