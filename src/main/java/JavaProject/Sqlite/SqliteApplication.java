package JavaProject.Sqlite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SqliteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqliteApplication.class, args);
	}

}
