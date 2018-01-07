package packageapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.boot.autoconfigure.orm.jpa.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class FoodApplication {

	FoodApplication() {

	}

	public static void main(String[] args) {
		SpringApplication.run(FoodApplication.class, args);
	}
}

