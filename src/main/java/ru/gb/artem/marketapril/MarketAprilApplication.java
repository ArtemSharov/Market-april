package ru.gb.artem.marketapril;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import ru.gb.artem.marketapril.configs.AppConfig;
// Домашнее задание:
// 1. При оформлении заказа нужно указать доп информацию: телефон, адрес доставки
// 2. Регистрация пользователей через отправку JSON
// {
//   "username": "bob",
//   "password": "123"
//   "email": "bob@gmail.com"
// }
// 3. *Исследовательская* Загрузка товаров из файла

@SpringBootApplication
@PropertySource("classpath:app.properties")
public class MarketAprilApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		SpringApplication.run(MarketAprilApplication.class, args);

		context.close();
	}

}
