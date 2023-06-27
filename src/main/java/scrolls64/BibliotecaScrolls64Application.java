package scrolls64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// IMPORTANTE: TROCAR A SENHA DO BANCO DE ACORDO COM A MÁQUINA CORRESPONDENTE
@SpringBootApplication
public class BibliotecaScrolls64Application {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaScrolls64Application.class, args);
	}

}
