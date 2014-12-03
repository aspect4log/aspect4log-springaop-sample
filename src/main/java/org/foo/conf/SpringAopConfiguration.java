package org.foo.conf;

import net.sf.aspect4log.aspect.LogAspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.foo")
@EnableAspectJAutoProxy
public class SpringAopConfiguration {

	@Bean
	LogAspect createLogAspect(){
		return new LogAspect();
	}
	
}
