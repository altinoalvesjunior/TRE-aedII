package moduloUrna;

import java.util.Scanner;

import arquivo.LerArquivo;
import arquivo.Lista;
import moduloTRE.Candidato;
import moduloTRE.Eleitor;
import moduloTRE.UrnaEletronica;

public class Urna {

	UrnaEletronica urna;
	Candidato [] candidatos;
	Eleitor [] eleitores;
	Lista vereador = new Lista();
	Lista prefeito = new Lista();
	Lista quemVotou = new Lista();
	
		
	public Urna(String enderecoUrna, String enderecoEleitores, String enderecoCandidatos) {
		
		UrnaEletronica [] urnas = (UrnaEletronica[]) LerArquivo.leituraDosDados(enderecoUrna, UrnaEletronica.class);
		UrnaEletronica urna = urnas[1];
		
		Eleitor [] eleitores = (Eleitor[]) LerArquivo.leituraDosDados(enderecoEleitores, Eleitor.class);
		
		Candidato [] candidatos = (Candidato[]) LerArquivo.leituraDosDados(enderecoCandidatos, Candidato.class);
		
		
		System.out.println("Urna instalada com sucesso!");
		
	}
	
	
	public void processarVotos(int tituloEleitoral) {
		
		boolean existe = verificarExistenciaEleitor(eleitores, tituloEleitoral);
		
		if (existe==false) {
			
			System.out.println("Erro! Eleitor nao identificado!");
			
		}else {
			
			boolean verificarSeVotou = verificarSeVotou(tituloEleitoral);
			
			if (verificarSeVotou == true) {
				
				System.out.println("Eleitor ja votou!");
				
			}else {
				
				Scanner sc = new Scanner (System.in);
				int pref = 0;
				
				System.out.println("Digite o numero do candidato para prefeito:");
				pref = sc.nextInt();
				
				for(int i=0; i<candidatos.length; i++) {
					
					if(candidatos[i].getNumeroCandidato()==pref) {
						prefeito.adicionar(candidatos[i]);
						System.out.println("Voto computado com sucesso!");
					}
				}
			
				
				System.out.println("Digite o numero do candidato para vereador:");
				int vere = 0;
				vere = sc.nextInt();
				for(int i=0; i<candidatos.length; i++) {
					
					if(candidatos[i].getNumeroCandidato()==vere) {
						vereador.adicionar(candidatos[i]);
						System.out.println("Voto computado com sucesso!");
					}
				}	
				registroDeQuemVotou (tituloEleitoral);
		
				}
			}
		}
	
	
	
	
	
	
	public boolean verificarExistenciaEleitor(Eleitor [] eleitores, int tituloEleitoral) {
		
		for(int i = 0; i < eleitores.length; i++) {
			
			if (eleitores[i].getTituloEleitor()==tituloEleitoral) {
				
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
	
	public void registroDeQuemVotou (int tituloEleitoral) {
		
		quemVotou.adicionar(tituloEleitoral);
	}
	
	
	
	
	public boolean verificarSeVotou(int tituloEleitoral) {
		
		Object resultado = quemVotou.buscarObjeto(tituloEleitoral);
		
		if (resultado != null) {
			
			return true;
			
		}else {
			
			return false;
		}
	}
	
	
}
