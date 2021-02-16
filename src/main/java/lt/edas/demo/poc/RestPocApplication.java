package lt.edas.demo.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class RestPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestPocApplication.class, args);
	}

}
