package br.com.mariojp.exemplos.pathfinding;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;

/**
 * 
 * @author m4r10
 * 
 */
public class MoveLeft extends AbstractAction {

	@Override
	public List<IState> execute(IState estado)  throws ImpossibleActionException {
		List<IState> novosestados = new ArrayList<IState>();
		Estado copia = (Estado) ((Estado) estado).clone();
		int[] posicaoAtual = copia.getPosicaoAtual();
		int linha = posicaoAtual[0];
		int coluna = posicaoAtual[1];
		String[][] mapa = copia.getMapa();
		if (coluna-1 >= 0 && !mapa[linha][coluna-1].equals(LoadMap.OBSTACLE)) {
			int[] newPositionAtual = {linha,coluna-1};
			copia.setPosicaoAtual(newPositionAtual);
			novosestados.add(copia);
			return novosestados;
		} else {
			throw new ImpossibleActionException("Impossível mover para a direita");
		}
		
	}

}
