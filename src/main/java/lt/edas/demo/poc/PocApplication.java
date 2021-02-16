package lt.edas.demo.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"lt.edas.demo.poc.rest.controllers", "lt.edas.demo.poc.rest", "lt.edas.demo.poc"})
@ServletComponentScan(basePackages = {"lt.edas.demo.poc.rest.controllers", "lt.edas.demo.poc.rest", "lt.edas.demo.poc"})
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

}
