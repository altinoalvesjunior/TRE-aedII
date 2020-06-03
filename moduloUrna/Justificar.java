package moduloUrna;

import java.util.Scanner;

import arquivo.Lista;
import moduloTRE.Candidato;
import moduloTRE.Eleitor;

public class Justificar {

	Eleitor[] eleitores;

	public void justificarVoto(int tituloEleitoral) {

		boolean existeEleitor = verificarExistenciaEleitor(eleitores, tituloEleitoral);

		if (existeEleitor == false)
			System.out.println("Eleitor não existente!");

			else {
				boolean verificarJustificativa = verificarSeJustificou(tituloEleitoral);

			if (verificarJustificativa == true)
				System.out.println("Eleitor já justificou o voto!");
			else 
			{	
				Scanner sc = new Scanner(System.in);
				int op;
				
				do {
				
					System.out.print("\nOpções: \1 - Pressione 1 para confirmar a justificativa do voto \n 2 - Cancelar \n\nSelecione: ");
					op = sc.nextInt();
				}
				while(op != 0 && op != 1);
				
				if(op == 1) {
					registroDeQuemJustificou(tituloEleitoral);
					System.out.print("\n Justificativa realizada com sucesso!");
				}
				else if(op == 2)
					System.out.println("Operação cancelada!");
				
				sc.close();
			}
		}
	}

	public boolean verificarExistenciaEleitor(Eleitor[] eleitores, int tituloEleitoral) {

		for (int i = 0; i < eleitores.length; i++) {

			if (eleitores[i].getTituloEleitor() == tituloEleitoral) {

				return true;
			}
		}

		return false;
	}

	Lista quemJustificou = new Lista();

	public void registroDeQuemJustificou(int tituloEleitoral) {
		quemJustificou.adicionar(tituloEleitoral);
	}

	private boolean verificarSeJustificou(int tituloEleitoral) {
		Object resultado = quemJustificou.buscarObjeto(tituloEleitoral);

		if (resultado != null)
			return true;
		else 
			return false;
	}

}
