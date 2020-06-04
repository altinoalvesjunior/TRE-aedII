package moduloTRE;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*; 
import javax.swing.JOptionPane;


// Classe criada para gerenciar arquivos
public class Files {
  
  /*
  * Função para salvar arquivo
  * @params {String} nomeArquivo - nome do arquivo
  * @params {String} mensagem - mensagem após salvar o arquivo
  * @params {String} dados - array dos dados  
  * arquivo
  */
  public void salvarArquivo(String nomeArquivo, String mensagem, String dados[]) {
    
   try{
      int i = 0;

    // Ler arquivo
    Scanner ler = new Scanner(System.in);

    // Nome do arquivo 
    FileWriter arq = new FileWriter(nomeArquivo, true);

    // Gravar no arquivo passado como parâmetro
    PrintWriter gravarArq = new PrintWriter(arq);

    // Iterar sobre os dados 
    for(i = 0; i < dados.length; i++) {

      // Salvar no arquivo dados iterados
      gravarArq.printf(dados[i] + ";" + " ");

    }
    gravarArq.printf("\n");

    // Fechar arquivos
    arq.close();


    // Mensagem após fazer as operações
    System.out.println(mensagem);
   } catch (IOException e) {
      System.out.println("There was a problem prompting for story");
      e.printStackTrace();
    }
  } 

  /*
  * Função para ler dados do arquivo
  * @params {String} nomeArquivo - nome do arquivo
  * arquivo
  */
  public void lerDadosArquivo(String nomeArquivo) {
  	try{
			
			// String nome;
			// nome = JOptionPane.showInputDialog(null,"Entre com o nome do arquivo");
			
			BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
			while(br.ready()){
				String linha = br.readLine();
			System.out.println("-> " + linha);
		}
			br.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		} 
  } 

}
