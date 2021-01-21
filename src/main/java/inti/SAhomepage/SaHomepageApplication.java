package inti.SAhomepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class SaHomepageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaHomepageApplication.class, args);
	}

	/*@Bean
	public InternalResourceViewResolver setupViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("");      // spring ~ starter-freemarker의 경우 src/main/resources/templates로 기본 설정됨
		resolver.setSuffix(".ftl");  // freemarker 확장자 = .ftl
		return resolver;
	}//지워야 될거같긴한데 음*/
}
