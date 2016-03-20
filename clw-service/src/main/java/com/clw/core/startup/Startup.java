package com.clw.core.startup;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Startup {
	private static volatile boolean running = true;
	private static Logger _log = LoggerFactory.getLogger(Startup.class);

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath*:/spring/spring-*.xml"});
		context.start();
		_log.info("service publish success");
		
		System.out.println(new Date(1449156348243L));

		synchronized (Startup.class) {
			while (running) {
				try {
					Startup.class.wait();
				} catch (Throwable e) {
					context.close();
					_log.error(e.getMessage());
				}
			}
		}
	}
}
