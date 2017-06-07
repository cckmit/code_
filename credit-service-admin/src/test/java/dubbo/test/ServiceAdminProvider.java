package dubbo.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceAdminProvider {
	
	private static final Log log = LogFactory.getLog(ServiceAdminProvider.class);

	public static void main(String[] args) {
		String[] springXML = new String[]{"classpath:spring-core.xml","classpath:spring-dubbo-provider.xml","classpath:spring-dubbo-consumer.xml","classpath:spring-mybatis-ge.xml","classpath:spring-mybatis-gs.xml","classpath:spring-mybatis-admin.xml"};
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springXML);
			context.start();
		} catch (Exception e) {
			log.error("== ServiceBossProvider context start error:",e);
		}
		synchronized (ServiceAdminProvider.class) {
			while (true) {
				try {
					ServiceAdminProvider.class.wait();
				} catch (InterruptedException e) {
					log.error("== synchronized error:",e);
				}
			}
		}
	}
    
}