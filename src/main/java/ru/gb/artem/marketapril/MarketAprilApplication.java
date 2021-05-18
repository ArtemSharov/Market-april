package ru.gb.artem.marketapril;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:app.properties")
public class MarketAprilApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketAprilApplication.class, args);
	}

}
