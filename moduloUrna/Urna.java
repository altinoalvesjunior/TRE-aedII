package moduloUrna;

import java.util.Scanner;

import arquivo.LerArquivo;
import arquivo.Lista;
import moduloTRE.Candidato;
import moduloTRE.Eleitor;
import moduloTRE.UrnaEletronica;

public class Urna {

	private String nomeMunicipioUrna;
	private int zonaEleitoralUrna;
	private int secaoEleitoralUrna;
	Candidato [] candidatos;
	Eleitor [] eleitores;
	
		
	public Urna(String enderecoUrna, String enderecoEleitores, String enderecoCandidatos) {
		
		UrnaEletronica urnaFake = new UrnaEletronica("BH", 130, 15);
		UrnaEletronica [] urnas = (UrnaEletronica[]) LerArquivo.leituraDosDados(enderecoUrna, urnaFake);
		UrnaEletronica urna = urnas[1];
		this.nomeMunicipioUrna = urna.getNomeMunicipioUrna();
		this.secaoEleitoralUrna = urna.getSecaoEleitoralUrna();
		this.zonaEleitoralUrna = urna.getZonaEleitoralUrna();
		
		Eleitor eleitorFake = new Eleitor("Joao", 123456, "BH", 130, 15);
		Eleitor [] eleitores = (Eleitor[])LerArquivo.leituraDosDados(enderecoEleitores, eleitorFake);
		
		Candidato candidatoFake = new Candidato("Joao", 23, "BH", "ABCD", 'P');
		Candidato [] candidatos = (Candidato[])LerArquivo.leituraDosDados(enderecoCandidatos, candidatoFake);
		
		
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
				int opcao = 0;
				
				System.out.println("Digite o numero do candidato para prefeito:");
				
				opcao = sc.nextInt();
				
				switch(opcao) {
				
					 
				}
				
				System.out.println("Digite o numero do candidato para vereador:");
				
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
	
	Lista quemVotou = new Lista();
	
	public void registroDeQuemVotou (int tituloEleitoral) {
		
		quemVotou.adicionar(tituloEleitoral);
	}
	
	private boolean verificarSeVotou(int tituloEleitoral) {
		
		Object resultado = quemVotou.buscarObjeto(tituloEleitoral);
		
		if (resultado != null) {
			
			return true;
			
		}else {
			
			return false;
		}
	}
}
