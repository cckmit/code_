package dubbo.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceFrontCnProvider {
	
	private static final Log log = LogFactory.getLog(ServiceFrontCnProvider.class);

	public static void main(String[] args) {
		String[] springXML = new String[]{"classpath:spring-core.xml","classpath:spring-dubbo-consumer.xml","classpath:spring-dubbo-provider.xml","classpath:spring-mybatis.xml",
				"classpath:spring-activemq.xml"};
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springXML);
			context.start();
		} catch (Exception e) {
			log.error("== ServiceBossProvider context start error:",e);
		}
		synchronized (ServiceFrontCnProvider.class) {
			while (true) {
				try {
					ServiceFrontCnProvider.class.wait();
				} catch (InterruptedException e) {
					log.error("== synchronized error:",e);
				}
			}
		}
	}
    
}