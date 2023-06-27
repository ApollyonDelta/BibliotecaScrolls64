package scrolls64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BibliotecaScrolls64Application {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaScrolls64Application.class, args);
	}

}
