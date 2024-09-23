package JavaProject.Dayoung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DayoungApplication {

	public static void main(String[] args) {
		SpringApplication.run(DayoungApplication.class, args);
	}

}
