package java7.ioc.agent;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * TODO AgentFinder绑定模型
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/11
 */
public class AgentFinderModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AgentFinder.class).annotatedWith(Names.named("primary")).to(DevAgentFinder.class);
				// .in(Session.class);
	}
}
