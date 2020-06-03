package moduloUrna;

import java.io.IOException;
import java.util.Scanner;

import arquivo.LerArquivo;
import arquivo.Lista;
import moduloTRE.Candidato;
import moduloTRE.Eleitor;
import moduloTRE.UrnaEletronica;

public class Urna {

	private UrnaEletronica urna;
	private Candidato [] candidatos;
	private TituloEleitor [] titulos;
	private Lista vereador = new Lista();
	private Lista prefeito = new Lista();
	private Lista quemVotou = new Lista();
	
	public Urna(TituloEleitor[] titulos, Candidato[] candidatos, String municipio, int zona, int secao) {
		
		urna = new UrnaEletronica(municipio,zona,secao);
		this.candidatos= candidatos;
		this.titulos = titulos;
		System.out.println("Urna instalada com sucesso!");	
	}


//	public void processarVotos(int tituloEleitoral) {
//		
//		boolean existe = verificarExistenciaEleitor(eleitores, tituloEleitoral);
//		
//		if (existe==false) {
//			
//			System.out.println("Erro! Eleitor nao identificado!");
//			
//		}else {
//			
//			boolean verificarSeVotou = verificarSeVotou(tituloEleitoral);
//			
//			if (verificarSeVotou == true) {
//				
//				System.out.println("Eleitor ja votou!");
//				
//			}else {
//				
//				Scanner sc = new Scanner (System.in);
//				int pref = 0;
//				
//				System.out.println("Digite o numero do candidato para prefeito:");
//				pref = sc.nextInt();
//				
//				for(int i=0; i<candidatos.length; i++) {
//					
//					if(candidatos[i].getNumeroCandidato()==pref) {
//						prefeito.adicionar(candidatos[i]);
//						System.out.println("Voto computado com sucesso!");
//					}
//				}
//			
//				
//				System.out.println("Digite o numero do candidato para vereador:");
//				int vere = 0;
//				vere = sc.nextInt();
//				for(int i=0; i<candidatos.length; i++) {
//					
//					if(candidatos[i].getNumeroCandidato()==vere) {
//						vereador.adicionar(candidatos[i]);
//						System.out.println("Voto computado com sucesso!");
//					}
//				}	
//				registroDeQuemVotou (tituloEleitoral);
//		
//				}
//			}
//		}
//	
//	
//	
//	
//	
//	
//	public boolean verificarExistenciaEleitor(Eleitor [] eleitores, int tituloEleitoral) {
//		
//		for(int i = 0; i < eleitores.length; i++) {
//			
//			if (eleitores[i].getTituloEleitor()==tituloEleitoral) {
//				
//				return true;
//			}
//		}
//		
//		return false;
//	}
//	
//	
//	
//	
//	
//	public void registroDeQuemVotou (int tituloEleitoral) {
//		
//		quemVotou.adicionar(tituloEleitoral);
//	}
//	
//	
//	
//	
//	public boolean verificarSeVotou(int tituloEleitoral) {
//		
//		Object resultado = quemVotou.buscarObjeto(tituloEleitoral);
//		
//		if (resultado != null) {
//			
//			return true;
//			
//		}else {
//			
//			return false;
//		}
//	}
//	
	
}
