package java7.ioc;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.List;

import java7.ioc.agent.AgentFinderModule;
import java7.ioc.agent.AgentFinderService;
import java7.ioc.office.OfficeWriterModule;
import java7.ioc.office.OfficeWriterService;

/**
 * TODO Agent服务
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/11
 */
public class IoCApplication {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new AgentFinderModule(), new OfficeWriterModule());

		AgentFinderService hollywoodService = injector.getInstance(AgentFinderService.class);
		List<String> agents = hollywoodService.getGoodAgents();
		System.out.println(agents);

		OfficeWriterService officeWriterService = injector.getInstance(OfficeWriterService.class);
		officeWriterService.writeData("Test Data");

		OfficeWriterService officeWriterService2 = injector.getInstance(OfficeWriterService.class);
		officeWriterService2.writeData("Test Data");
	}
}
