package br.com.mariojp.exemplos.pathfinding;

import br.com.mariojp.ai.agent.Functions;
import br.com.mariojp.ai.agent.INode;

public class Funcoes extends Functions {

	public Funcoes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double h(INode no) {
		//Obtendo o estado
		Estado estado = (Estado)no.getState();
		//Funcao Heuristica

        int[] posicaoAtual = estado.getPosicaoAtual();
        int[] posicaoFinal = estado.getPosicaoDestino();
		
		int catetoA = posicaoAtual[0] - posicaoFinal[0];
		int catetoB = posicaoAtual[1] - posicaoFinal[1];
        

		return Math.hypot(catetoA, catetoB);
	}
}
