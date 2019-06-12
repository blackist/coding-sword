package java7.ioc.agent;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO mesage
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/9
 */
public class DevAgentFinder extends AgentFinder {

	private List<String> agents;

	public DevAgentFinder() {
		agents = new ArrayList<>();
		agents.add("Java A");
		agents.add("PHP B");
		agents.add("Python C");
		agents.add("Java D");
	}

	@Override
	public List<String> getAllAgents() {
		return agents;
	}
}
