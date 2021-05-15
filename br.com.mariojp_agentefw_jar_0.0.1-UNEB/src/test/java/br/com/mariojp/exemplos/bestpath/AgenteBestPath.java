package br.com.mariojp.exemplos.bestpath;

import java.util.List;


import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.IAgent;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;

public class AgenteBestPath {
    public void exec(int numeroAgente, int numeroMapa) {
			LoadMap initialMap = new LoadMap("initialMap", "br.com.mariojp_agentefw_jar_0.0.1-UNEB/src/test/resources/maps/" + numeroMapa + "-init-map");
			LoadMap finalMap = new LoadMap("finalMap", "br.com.mariojp_agentefw_jar_0.0.1-UNEB/src/test/resources/maps/" + numeroMapa + "-target-map");

			Estado estadoInicial = new Estado(initialMap);
			Estado estadoFinal = new Estado(finalMap);

			AgentModel model = new AgentModel();
			model.setInitState(estadoInicial);
			model.addObjective(estadoFinal);

			// Movimentações retas
			model.addAction("MoverDireita",new MoveRight());
			model.addAction("MoverEsquerda", new MoveLeft());
			model.addAction("MoverCima", new MoveUp());
			model.addAction("MoverBaixo", new MoveDown());

			// Movimentações em diagonais
			model.addAction("MoverDiagCimaDireita", new MoveNE());
			model.addAction("MoverDiagCimaEsquerda", new MoveNW());
			model.addAction("MoverDiagBaixoEsquerda", new MoveSW());
			model.addAction("MoverDiagBaixoDireita", new MoveSE());
					

			model.setFunctions(new Funcoes());
			model.setType(numeroAgente);
			IAgent agente = AgentFactory.createAgent(model);
			
			INode nofinal = null;
			try {
				nofinal = agente.function();
			} catch (EmptyBorderException e) {}
			
			List<INode> cam = agente.getPath(nofinal);
			agente.showGraphic(cam, "bestpath");
			System.out.println(cam);
			System.out.println(agente);
			System.out.println(nofinal);
			System.out.println("-------------");
    }
}
