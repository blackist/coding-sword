package java7.ioc.agent;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO IoC测试
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/5/30
 */
public class AgentFinderService {

	private final AgentFinder finder;

	/**
	 * 链接绑定：运行时注入实现类或扩展类
	 */
	// @Inject
	// public AgentFinderService(AgentFinder finder) {
	// 	this.finder = finder;
	// }

	/**
	 * 注解绑定：将注入类的类型和额外的标识符结合起来，标识恰当的注入对象；配置命名依赖项
	 */
	@Inject
	public AgentFinderService(@Named("primary") AgentFinder finder) {
		this.finder = finder;
	}

	public List<String> getGoodAgents() {
		List<String> allAgents = finder.getAllAgents();
		return filterAgents(allAgents);
	}

	private List<String> filterAgents(List<String> agents) {
		List<String> fitAgents = new ArrayList<>();
		for (String agent : agents) {
			if (agent.contains("Java")) {
				fitAgents.add(agent);
			}
		}
		return fitAgents;
	}
}
