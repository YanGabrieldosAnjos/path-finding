package br.com.mariojp.exemplos.pathfinding;

import java.util.List;


import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.IAgent;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;

public class AgentPathfinding {
    public void exec(int numeroAgente, int numeroMapa) {
			AgentModel model = new AgentModel();

			LoadMap initMap = new LoadMap("initMap", "br.com.mariojp_agentefw_jar_0.0.1-UNEB/src/test/resources/maps/" + numeroMapa + "-init-map");
			Estado init = new Estado(initMap);
			model.setInitState(init);

			LoadMap targetMap = new LoadMap("targetMap", "br.com.mariojp_agentefw_jar_0.0.1-UNEB/src/test/resources/maps/" + numeroMapa + "-target-map");
			Estado target = new Estado(targetMap);
			model.addObjective(target);

			// Movimentações retas
			model.addAction("MoveRight",new MoveRight());
			model.addAction("MoveLeft", new MoveLeft());
			model.addAction("MoveUp", new MoveUp());
			model.addAction("MoveDown", new MoveDown());

			// Movimentações em diagonais
			model.addAction("MoveNE", new MoveNE());
			model.addAction("MoveNW", new MoveNW());
			model.addAction("MoveSW", new MoveSW());
			model.addAction("MoveSE", new MoveSE());
					
			model.setFunctions(new Funcoes());
			model.setType(numeroAgente);
			IAgent agent = AgentFactory.createAgent(model);
			
			INode nofinal = null;
			try {
				nofinal = agent.function();
			} catch (EmptyBorderException e) {}
			
			List<INode> cam = agent.getPath(nofinal);
			agent.showGraphic(cam, "pathfinding");
			System.out.println(cam);
			System.out.println(agent);
			System.out.println(nofinal);
			System.out.println("\n" + "\u001B[31m" + "Wait to next..." + "\u001B[0m" + "\n");
    }
}
