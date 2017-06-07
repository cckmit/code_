package dubbo.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceRecordProvider {
	
	private static final Log log = LogFactory.getLog(ServiceRecordProvider.class);

	public static void main(String[] args) {
		String[] springXML = new String[]{"classpath:spring-core.xml","classpath:spring-mybatis.xml","classpath:spring-dubbo-provider.xml","classpath:spring-dubbo-consumer.xml"};
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springXML);
			context.start();
		} catch (Exception e) {
			log.error("== ServiceBossProvider context start error:",e);
		}
		synchronized (ServiceRecordProvider.class) {
			while (true) {
				try {
					ServiceRecordProvider.class.wait();
				} catch (InterruptedException e) {
					log.error("== synchronized error:",e);
				}
			}
		}
	}
    
}