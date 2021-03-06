package br.com.mariojp.ai.agent.strategies;

import java.util.Date;
import java.util.List;

import br.com.mariojp.ai.agent.Agent;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;

public class BreadthFirstSearchReverse extends Agent  {

	public BreadthFirstSearchReverse(AgentModel iagent) {
		super(iagent);

	}

	@Override
	public INode function() throws EmptyBorderException {
		this.border.add(this.getGoalNode());
		INode node = null;
		boolean completed = false;
		while (!completed) {
			if (this.border.isEmpty()) {
				throw new EmptyBorderException();
			} else {
				node = (INode) this.border.remove(0);
				if (this.isStart(node)) {
					completed = true;
				} else {
					List<INode> list = this.actionCommand.revertActions(node);
					border.addAll(list);
				}
			}

		}
		this.end = new Date();
		return node;
	}

}
