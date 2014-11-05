package test;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestConfig {
	
	public static FileSystemXmlApplicationContext getApplicationContext() {
		return new FileSystemXmlApplicationContext("/WebContent/WEB-INF/applicationContext.xml");
	}

}
